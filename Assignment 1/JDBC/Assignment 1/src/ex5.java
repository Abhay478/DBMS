import java.sql.*;
import java.util.Scanner;

public class ex5 {
    Connection c;
    DatabaseMetaData md;
    
    public ex5(Connection c, DatabaseMetaData md, Scanner sc) throws Exception {
        this.c = c;
        this.md = md;
        io(sc);
    }
    
    private void io(Scanner sc) throws Exception {
        System.out.println("Enter subquestion (1, 2 or 3).");
        int ch = sc.nextInt();
        System.out.println("Enter k.");
        int k = sc.nextInt();
        switch(ch) {
            case 1:
                one(k); 
                break;
            case 2:
                System.out.println("Enter department name.");
                String dname = sc.nextLine();
                while(dname.equals("")) dname = sc.nextLine();
                two(dname, k);
                break;
            case 3:
                System.out.println("Enter course id.");
                String cid = sc.nextLine();
                while(cid.equals("")) cid = sc.nextLine();
                three(cid, k);
                break;
            default: System.out.println("Huh?"); break;
        }

    }

    private void one(int k) throws Exception {
        PreparedStatement pst = c.prepareStatement("select \"id\", \"name\", cgpa, dept_name, rank() over (order by cgpa desc) as sr from student natural join CGPA order by sr limit ?");
        System.out.println("You chose 5 -> 1");
        pst.setInt(1, k);
        ResultSet rs = pst.executeQuery();
        String dashes = "+-------+-----------------+-----------------+-----------------+-----------------+";
        System.out.println(dashes);
        System.out.printf("| %5s | %15s | %15s | %15s | %15s |", "Rank", "ID", "Name", "CGPA", "Department");
        System.out.println();
        System.out.println(dashes);
        while(rs.next()) {
            System.out.printf("| %5d | %15d | %15s | %15f | %15s |", rs.getInt(5), rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            System.out.println();
        }
        System.out.println(dashes);
    }

    private void two(String s, int k) throws Exception {
        PreparedStatement pst = c.prepareStatement("select \"id\", \"name\", cgpa, rank() over (order by cgpa desc) as sr from student natural join CGPA where dept_name = ? order by sr limit ?");
        System.out.println("You chose 5 -> 2 -> " + s);
        pst.setString(1, s);
        pst.setInt(2, k);
        ResultSet rs = pst.executeQuery();
        String dashes = "+-------+-----------------+-----------------+-----------------+";
        System.out.println(dashes);
        System.out.printf("| %5s | %15s | %15s | %15s |", "Rank", "ID", "Name", "CGPA");
        System.out.println();
        System.out.println(dashes);
        while(rs.next()) {
            System.out.printf("| %5d | %15d | %15s | %15f |", rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getDouble(3));
            System.out.println();
        }
        System.out.println(dashes);
    }

    private void three(String s, int k) throws Exception {
        PreparedStatement pst = c.prepareStatement("select \"id\", \"name\", cgpa, rank() over (order by cgpa desc) as sr from (student natural join CGPA) as Q where exists (select * from takes where \"id\" = Q.id and course_id = ?) order by sr limit ?");
        System.out.println("You chose 5 -> 3 -> " + s);
        pst.setString(1, s);
        pst.setInt(2, k);
        ResultSet rs = pst.executeQuery();
        String dashes = "+-------+-----------------+-----------------+-----------------+";
        System.out.println(dashes);
        System.out.printf("| %5s | %15s | %15s | %15s |", "Rank", "ID", "Name", "CGPA");
        System.out.println();
        System.out.println(dashes);
        while(rs.next()) {
            System.out.printf("| %5d | %15d | %15s | %15f |", rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getDouble(3));
            System.out.println();
        }
        System.out.println(dashes);
    }

}