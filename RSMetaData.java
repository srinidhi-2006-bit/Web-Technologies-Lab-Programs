import java.sql.*;
class RSMetaData
{ 
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            String q="select * from student1";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
            ResultSetMetaData rsmd=rs.getMetaData();
            int cc=rsmd.getColumnCount();
            System.out.println("Number of columns:"+cc);
            for(int i=1;i<=cc;i++)
            {
                System.out.print(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i)+"\t");
            }
            System.out.println("\n----------------------------------------------------------------------------------------");
            while(rs.next())
            {
                for(int i=1;i<=cc;i++)
                {
                    System.out.print(rs.getString(i)+"\t\t");
                }
                System.out.println();
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

/*output:
 C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>javac RSMetaData.java

C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>java RSMetaData
Connected to the database
Number of columns:5
SROLL VARCHAR2  SNAME VARCHAR2  SBRANCH VARCHAR2        SYEAR NUMBER    SCGPA NUMBER
----------------------------------------------------------------------------------------
67b4            nidhi           cse-ds          3               9.75
6785            khushi          cse-ds          3               9.8
 */