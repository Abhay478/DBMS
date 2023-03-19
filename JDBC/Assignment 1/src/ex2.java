import java.sql.*;
import java.util.*;
import org.javatuples.Pair;

public class ex2 {
    ArrayList<Pair<String, String>> prereqs;
    Connection c;
    DatabaseMetaData md;
    public ex2(Connection c, DatabaseMetaData md, Scanner sc) throws Exception {
        this.c = c;
        this.md = md;
        System.out.println("Enter course id");

        String cid = sc.nextLine();
        System.out.println("You chose 2 -> " + cid);
        prereqs = new ArrayList<>();
        sql(cid);
    }

    private ArrayList<Pair<String, String>> recurse(String cid) throws Exception {
        PreparedStatement st = c.prepareStatement("select course_id, title from course where course_id in (select prereq_id from prereq where course_id = ?)");
        st.setString(1, cid);
        ResultSet rs = st.executeQuery();
        ArrayList<Pair<String, String>> out = new ArrayList<>();
        while(rs.next()) {
            Pair<String,String> now = new Pair<String,String>(rs.getString(1), rs.getString(2));
            if(!prereqs.contains(now)) {prereqs.add(now); out.add(now);}
        }
        for (Pair<String, String> p:out) {
            recurse(p.getValue0());
        }

        return out;

    }

    private void sql(String cid) throws Exception {

        recurse(cid);

        String dashes = "+---------------+---------------------------------------------------+";
        System.out.println(dashes);
        System.out.printf("|%15s| %50s|\n", "Prerequisite ID", "Prerequisite course titles");
        System.out.println(dashes);
        for (Pair<String, String> p:prereqs) {
            System.out.printf("|%15s| %50s|\n", p.getValue0(), p.getValue1());
        }
        System.out.println(dashes);
        
    }
}
