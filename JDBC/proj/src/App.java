import java.util.ArrayList;
import java.util.Scanner;

import org.javatuples.Pair;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Calc myCalc = new Calc();
        int n;
        myCalc.gen_sieve(1000000);
        System.out.println("Enter number.");
        while((n = sc.nextInt()) >= 0) {
            System.out.println(myCalc.pairs_div(n));
            System.out.println(myCalc.factorize(n));

        }
        sc.close();
    }
}

class Calc {
    ArrayList<Integer> primes;
    public ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> out = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) out.add(i);
        }
        return out;
    }
    public ArrayList<Pair<Integer, Integer>> pairs_div(int n) {
        ArrayList<Pair<Integer, Integer>> out = new ArrayList<Pair<Integer, Integer>>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) out.add(new Pair<Integer,Integer>(i, n / i));
        }
        return out;
    }
    
    public void gen_sieve(int bound) {
        primes = new ArrayList<>();
        int S[] = {1, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 49, 53, 59};

        ArrayList<Boolean> bools = new ArrayList<>(bound + 2);
        for(int i = 0; i < bound + 2; i++) bools.add(false);
        // System.out.println(bools.size());
        int p = (int)Math.ceil(Math.sqrt(bound));

        primes.add(2);
        primes.add(3);
        primes.add(5);
        // System.out.println(".");

        for(int x = 1; x <= p; x++) {
            for(int y = 1; y <= p; y += 2){
                int m = 4*x*x + y*y;
                if(m > bound) break;
                int q = m % 60;
                int s[] = {1, 13, 17, 29, 37, 41, 49, 53};
                for(int j = 0; j < 8; j++)
                    if(q == s[j]) {bools.set(m, !bools.get(m)); break;}   
            }
        }

        for(int x = 1; x <= p; x++){
            for(int y = 2; y <= p; y += 2){
                int m = 3*x*x + y*y;
                if(m > bound) break;
                int q = m % 60;
                int s[] = {7, 19, 31, 43};
                for(int j = 0; j < 4; j++)
                    if(q == s[j]) {bools.set(m, !bools.get(m)); break;}
            }
        }
        for(int x = 2; x <= p; x++){
            for(int y = x - 1; y >= 1; y -= 2){
                int m = 3*x*x - y*y;
                if(m > bound) break;
                int q = m % 60;
                int s[] = {11, 23, 47, 59};
                for(int j = 0; j < 4; j++)
                    if(q == s[j]) {bools.set(m, !bools.get(m)); break;}
            }
        }

        ArrayList<Integer> holes = new ArrayList<>(bound + 2);
        // holes.ensureCapacity(bound + 2);
        for(int i = 0; i <= bound; i += 60){
            for(int j = 0; j < 16; j++){
                holes.add(i + S[j]);
            }
        }

        for(int i = 0; i < holes.size(); i++){
            int sq = holes.get(i)*holes.get(i);
            if(sq > bound) break;
            if(bools.get(i)){
                for(int r = 0; r < holes.size(); r++){
                    int m = sq * r;
                    if(m > bound) break;
                    bools.set(m, false);
                }
            }
        }
        for(int i = 0; i <= bound; i++){
            if(bools.get(i)){
                this.primes.add(i);
            }
        }
    }

    public ArrayList<Pair<Integer, Integer>> factorize(int n) {
        ArrayList<Pair<Integer, Integer>> out = new ArrayList<>();
        int count = 0;
        for(int i : primes) {
            while (n % i == 0) {
                n /= i;
                count++;
            }
            if (count > 0) {
                out.add(new Pair<Integer,Integer>(i, count));
                count = 0;
            }
        }

        return out;
    }
}
