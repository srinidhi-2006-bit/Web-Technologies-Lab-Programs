import java.sql.*;
import java.util.Scanner;
class Delete
{ 
    public static void main(String[] args)
    {
        try
        { 
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Student rollno:");
            String r=sc.nextLine();
            Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            String q="delete from student1 where sroll=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,r);
            int count=ps.executeUpdate();
            if(count==0)
                System.out.println("No student record found");
            else
                System.out.println("Student record deleted");
            sc.close();
            ps.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
/*output:
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Delete.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java Delete
Enter Student rollno:
6785
Connected to the database
Student record deleted

*/
