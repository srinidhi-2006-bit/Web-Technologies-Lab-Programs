import java.sql.*;
import java.util.Scanner;
class DySelect
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
            String q="select * from student1 where sroll=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,r);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                System.out.println(rs.getString(1)+" "+
                rs.getString(2)+" "+
                rs.getString(3)+" "+
                rs.getInt(4)+" "+
                rs.getFloat(5));
            else
                System.out.println("No records found");
            sc.close();
            rs.close();
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
C:\Users\egala\OneDrive\Desktop\WT LAB>javac DySelect.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java DySelect
Enter Student rollno:
67b4
Connected to the database
67b4 srinidhi cse-ds 3 9.7
*/