import java.sql.*;
import java.util.Scanner;
class Callable
{ 
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.err.println("Enter Students details(roll,name,branch,year,cgpa)");
            String r=sc.nextLine();
            String n=sc.nextLine();
            String b=sc.nextLine();
            int y=sc.nextInt();
            float c=sc.nextFloat();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to DataBase");
            String q="{call InsertStudent(?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(q);
            cs.setString(1,r);
            cs.setString(2,n);
            cs.setString(3,b);
            cs.setInt(4,y);
            cs.setFloat(5,c);
            int count=cs.executeUpdate();
            System.out.println("Procedure Invoked and record is inserted:"+count);
            sc.close();
            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

/*
 * create or replace procedure InsertStudent
(
   roll In varchar2,
   name IN varchar2,
   branch IN varchar2,
   year IN number,
   cgpa IN float
)
AS
BEGIN
  insert into student1 values(roll,name,branch,year,cgpa);
END InsertStudent;
/
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Callable.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java Callable
Enter Students details(roll,name,branch,year,cgpa)
6785
khushi
cse-ds
3
9.8
Connected to DataBase
Procedure Invoked and record is inserted:1

 */