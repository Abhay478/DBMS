import java.sql.*;
import java.util.*;

public class ex1 {
    Connection c;
    DatabaseMetaData md;
    public ex1(Connection c, DatabaseMetaData md, Scanner sc) throws Exception {
        this.c = c;
        this.md = md;
        System.out.println("Enter table name.");

        String tablename = sc.nextLine();
        tablename.trim();
        System.out.println("Enter k.");
        int k = sc.nextInt();
        System.out.println("You chose: 1 -> " + tablename);
        sql(tablename, k);
    }

    private String dashes(int n) {
        String out = "";
        for(int i = 0; i < n; i++) out = out.concat("-");
        return out;
    }

    private int width(ResultSetMetaData rsmd, int i, ArrayList<String> columns) throws Exception {
        int l1 = rsmd.getPrecision(i + 1);
        int l2 = columns.get(i).length(); // this really shouldn't be necessary, but some column names exceed the getPrecision value, so.
        return Math.max(l1, l2) + 2;
    }

    private void sql(String tablename, int k) throws Exception {
        String query = String.format("select * from %s limit %d", tablename, k);
        Statement st = c.createStatement();
        try{
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            ArrayList<String> columns = new ArrayList<>();
            try(ResultSet rs0 = md.getColumns(null, null, tablename, null)) {
                while(rs0.next()) {
                    columns.add(rs0.getString("COLUMN_NAME"));
                }
            }
            catch (Exception e) { System.out.println(e); return;}

            for(int i = 0; i < columns.size(); i++) {
                System.out.printf("+%s" , dashes(width(rsmd, i, columns)));
            } // table decoration
            System.out.println("+");
            for(int i = 0; i < columns.size(); i++) {
                System.out.printf("|%" + (width(rsmd, i, columns)) + "s" , columns.get(i));
            } // column names
            System.out.println("|");
            for(int i = 0; i < columns.size(); i++) {
                System.out.printf("+%s" , dashes(width(rsmd, i, columns)));
            } // more decoration
            System.out.println("+");

            
            
            while(rs.next()) {
                for(int i = 0; i < columns.size(); i++) {
                    System.out.printf("|%" + (width(rsmd, i, columns)) + "s", rs.getString(i + 1));
                } // actual stuff
                System.out.println("|");
            }
            for(int i = 0; i < columns.size(); i++) {
                System.out.printf("+%s" , dashes(width(rsmd, i, columns)));
            } // decoration
            System.out.println("+");
        }
        
        catch(SQLException sq) {System.out.println("Not there.");}
    }

        
}
