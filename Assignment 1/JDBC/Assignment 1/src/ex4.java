import java.sql.*;
import java.util.Scanner;

public class ex4 {
    Connection c;
    DatabaseMetaData md;
    public ex4(Connection c, DatabaseMetaData md, Scanner sc) throws Exception {
        this.c = c;
        this.md = md;
        System.out.println("Enter student id.");
        int id = sc.nextInt();
        System.out.println("You chose 4 -> " + id);
        sql(id);
    }

    private void sql(int id) throws Exception {
        String s = String.format("select cgpa from CGPA where \"id\"::integer = %d", id);
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(s);
        if(rs.next()) System.out.println("The CGPA is: " + rs.getDouble(1));
        else System.out.println("rs error.");
        System.out.println();
    }
}