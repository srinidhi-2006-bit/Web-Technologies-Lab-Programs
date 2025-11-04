import java.sql.*;
import java.util.Scanner;
class Update
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Student rollno:");
            String r=sc.nextLine();
            System.out.println("Enter name,branch,year and cgpa values to be updated");
            String n=sc.nextLine();
            String b=sc.nextLine();
            int y=sc.nextInt();
            float c=sc.nextFloat();
            Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            String q="update student1 set sname=?,sbranch=?,syear=?,scgpa=? where sroll=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,n);
            ps.setString(2,b);
            ps.setInt(3,y);
            ps.setFloat(4,c);
            ps.setString(5,r);
            int count=ps.executeUpdate();
            if(count==0)
                System.out.println("No student record found");
            else
                System.out.println("Student record updated");
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
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Update.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java Update
Enter Student rollno:
67b4
Enter name,branch,year and cgpa values to be updated
nidhi
cse-ds
3
9.6
Connected to the database
Student record updated
*/