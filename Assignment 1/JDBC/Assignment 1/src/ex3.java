import java.sql.*;
import java.util.Scanner;

public class ex3 {
    Connection c;
    DatabaseMetaData md;
    public ex3(Connection c, DatabaseMetaData md, Scanner sc) throws Exception {
        this.c = c;
        this.md = md;
        System.out.println("You entered: 3.");
        System.out.println();
        sql();
    }

    private void sql() throws Exception {
        Statement st = c.createStatement();
        System.out.println("Testing insert into section that shouldn't work: " + "insert into section values ('313', '2', 'Fall', 2010, 'Chandler', '804', 'N');");
        try{st.execute("insert into section values ('313', '2', 'Fall', 2010, 'Chandler', '804', 'N');");}
        catch(SQLException sq){System.out.println(sq); System.out.println("Trigger worked.");}
        System.out.println();
        
        System.out.println("Testing insert into section that should work: " + "insert into section values ('313', '1', 'Spring', 2010, 'Chandler', '804', 'N')");
        try{st.execute("insert into section values ('313', '1', 'Spring', 2010, 'Chandler', '804', 'N')");}
        catch(Exception e) {System.out.println("Shouldn't");}
        System.out.println("Worked.");
        System.out.println();
        
        System.out.println("Testing insert into teaches that shoudln't work: " + "insert into teaches values ('36897', '313', '3', 'Fall', 2010);");
        try{st.execute("insert into teaches values ('36897', '313', '3', 'Fall', 2010);");}
        catch(SQLException sq) {System.out.println(sq); System.out.println("Trigger worked.");}
        System.out.println();
        
        System.out.println("Testing insert into teaches that should work: " + "insert into teaches values ('36897', '313', '1', 'Spring', 2010);");
        try{st.execute("insert into teaches values ('36897', '313', '1', 'Spring', 2010);");}
        catch (Exception e) {System.out.println("Shouldn't.");}
        System.out.println("Worked.");

        System.out.println("Testing update that shouldn't work: " + "update section set time_slot_id = 'F' where course_id = '581';");
        try{st.execute("update section set time_slot_id = 'F' where course_id = '581';");}
        catch (SQLException sq) {System.out.println(sq); System.out.println("Trigger worked.");}
        System.out.println();

        System.out.println("Testing update that should work: " + "update section set time_slot_id = 'A' where course_id = '581';");
        try{st.execute("update section set time_slot_id = 'A' where course_id = '581';");}
        catch (Exception e) {System.out.println("Shouldn't.");}
        System.out.println("Worked.");

        st.execute("delete from teaches where (id, course_id, sec_id, semester, year) = ('36897', '313', '1', 'Spring', 2010);");
        // st.execute("delete from teaches where (id, course_id, sec_id, semester, year) = ('34175', '313', '3', 'Fall', 2010);");
        st.execute("update section set time_slot_id = 'G' where course_id = '581';");
        st.execute("delete from section where (course_id, semester) = ('313', 'Spring')");
        // So that we can run this again.
        System.out.println();

    }
}