import java.sql.*; 
class UpdatableRS
{
    public static void main(String args[])
    {
        try
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","cseds");
            System.out.println("Connected to the database");
            String q="select accid,accname,balance from accounts";
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery(q);
            System.out.println("Before Updations:");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            }
            //insert
            rs.moveToInsertRow();
            rs.updateString(1,"107");
            rs.updateString(2,"xxx");
            rs.updateFloat(3,50000);
            rs.insertRow();
            System.out.println("New Record Inserted");
            //delete
            rs.absolute(2);
            rs.deleteRow();
            System.out.println("Record Deleted");
            //update
            rs.absolute(5);
            rs.updateString(2,"yyy");
            rs.updateFloat(3,100000);
            rs.updateRow();
            System.out.println("Record updated");
            System.out.println("After Updations");
            rs.first();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
            }
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
 * C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>javac UpdatableRS.java

C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>java UpdatableRS
Connected to the database
Before Updations:
101 RAM 60000.0
102 SITA 70000.0
103 RAMU 80000.0
104 SURESH 90000.0
105 NAGA 100000.0
106 RAJU 150000.0
New Record Inserted
Record updated
After Updations
 */