import java.io.FileInputStream;
import java.sql.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        DB db = new DB();
        db.connect(); // connect
        db.ddl(); // creates views, tables and triggers.
        db.io(); // accepts user input in loop
    }
}

class DB {
    Connection c;
    DatabaseMetaData md;
/*
    public void reset() throws Exception {
        Statement st = c.createStatement();
        st.execute("drop schema public cascade;");
        st.execute("create schema public;");
        FileInputStream f1 = new FileInputStream("../sql/DDL.sql");
        Scanner sc1 = new Scanner(f1);
        FileInputStream f2 = new FileInputStream("../sql/largeRelationsInsertFile.sql");
        Scanner sc2 = new Scanner(f2);
        String s1 = "";
        String s2 = "";
        while(sc1.hasNextLine()) s1 += sc1.nextLine();
        while(sc2.hasNextLine()) s2 += sc2.nextLine();

        
        st.execute(s1);
        st.execute(s2);
        sc1.close();
        sc2.close();


        ddl();

    }
 */
    
    public void ddl() throws Exception {
        FileInputStream f3 = new FileInputStream("sql/ex3.sql");
        Scanner sc3 = new Scanner(f3);
        FileInputStream f4 = new FileInputStream("sql/ex4.sql");
        Scanner sc4 = new Scanner(f4);
        String s3 = "";
        String s4 = "";
        while(sc3.hasNextLine()) s3 += sc3.nextLine();
        while(sc4.hasNextLine()) s4 += sc4.nextLine();

        Statement st = c.createStatement();
        st.execute(s3);
        st.execute(s4);
        sc3.close();
        sc4.close();

    }

    public void io() throws Exception{
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        String pch;
        System.out.println("Choices are: ");
        System.out.println("1: Print entirety of a table.");
        System.out.println("2: Prerequisites of a given course.");
        System.out.println("3: Trigger tests.");
        System.out.println("4: CGPA retrieval.");
        System.out.println("5: Ranksheets.");
        System.out.println("-1: Terminate.");

        while(true){
            System.out.println("Enter choice.");
            while((pch = sc.nextLine()).equals(""));
            ch = Integer.parseInt(pch);
            switch(ch) {
                case 1: new ex1(c, md, sc); break;
                case 2: new ex2(c, md, sc); break;
                case 3: new ex3(c, md, sc); break;
                case 4: new ex4(c, md, sc); break;
                case 5: new ex5(c, md, sc); break;
                case -1: sc.close(); return;
                default: break;
            }

        }

    }
    
    public void connect() throws Exception{
        String url = "jdbc:postgresql://localhost:5433/univdb"; // Usually port 5432, but my machine has another postgres server there, so 5433.
        Properties props = new Properties();
        props.setProperty("user", "MS"); // Manish Singh
        props.setProperty("password", "qwerty");
        Connection conn = DriverManager.getConnection(url, props);
        c = conn;
        md = c.getMetaData();
    }

}

