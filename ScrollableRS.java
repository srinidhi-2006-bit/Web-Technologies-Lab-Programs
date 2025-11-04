import java.sql.*;
class ScrollableRS
{ 
    public static void main(String args[])
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            String q="select * from accounts";
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(q);
            System.out.println("FIRST RECORD---");
            rs.first();
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            System.out.println("LAST RECORD---");
            rs.last();
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            System.out.println("ABSOLUTE-5th record");
            rs.absolute(5);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            System.out.println("ABSOLUTE-last 3rd record");
            rs.absolute(-3);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            System.out.println("RELATIVE-curr pos to next");
            rs.relative(1);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            con.close();
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
/*output:
 C:\Users\egala\OneDrive\Desktop\WT LAB>javac ScrollableRS.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java ScrollableRS
Connected to the database
FIRST RECORD---
101 ram 60000.0
LAST RECORD---
106 raju 150000.0
ABSOLUTE-5th record
105 naga 100000.0
ABSOLUTE-last 3rd record
104 suresh 90000.0
RELATIVE-curr pos to next
105 naga 100000.0
 */

