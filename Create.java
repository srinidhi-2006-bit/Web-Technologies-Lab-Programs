
import java.sql.*;
class Create
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "srinidhi", "nidhi");
            System.out.println("Connected to the database");
            String q = "create table employee9(eid number,ename varchar2(20),Designation varchar2(22), Department varchar2(24),Salary float)";
            Statement st = con.createStatement();
            st.executeUpdate(q);
            System.out.println("Table is created in DataBase");
            st.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}


/*
set classpath=%CLASSPATH%;C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar
SET LINESIZE 200
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Create.java
C:\Users\egala\OneDrive\Desktop\WT LAB>java Create
Connected to the database
Table is created in DataBase
 */
