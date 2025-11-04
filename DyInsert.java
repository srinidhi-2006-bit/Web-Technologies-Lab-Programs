import java.sql.*;
import java.util.Scanner;
class DyInsert
{ 
    public static void main(String[] args)
    {
        try
        { 
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Student details:");
            String r=sc.nextLine();
            String n=sc.nextLine();
            String b=sc.nextLine();
            int y=sc.nextInt();
            float c=sc.nextFloat();
            Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            String q="insert into student1 values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,r);
            ps.setString(2,n);
            ps.setString(3,b);
            ps.setInt(4,y);
            ps.setFloat(5,c);
            int count=ps.executeUpdate();
            if(count>0)
                System.out.println("Row Inserted:"+count);
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

/*
 
create table student1(sroll varchar2(30),sname varchar2(30),sbranch varchar2(30),syear number,scgpa float);

C:\Users\egala\OneDrive\Desktop\WT LAB>javac DyInsert.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java DyInsert
Enter Student details:
67b4
srinidhi
cse-ds
3
9.7
Connected to the database
Row Inserted:1

 */