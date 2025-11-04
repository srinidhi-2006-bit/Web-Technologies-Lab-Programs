import java.sql.*;
class CreateStudent
{ 
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "srinidhi", "nidhi");
            System.out.println("Connected to the database");
            String q = "create table students (rollno number,name varchar2(30),branch varchar2(20),year number,cgpa float)";
            Statement st = con.createStatement();
            st.executeUpdate(q);
            System.out.println("Student table created successfully in the database.");
            st.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
/*output:
C:\Users\egala\OneDrive\Desktop\WT LAB>javac CreateStudent.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java CreateStudent
Connected to the database
Student table created successfully in the database.
 */