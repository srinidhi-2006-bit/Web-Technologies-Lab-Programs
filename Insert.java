import java.sql.*;
class Insert
{
public static void main(String args[])
{
	try
	{  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
        System.out.println("Connected to the database");
		String q1="insert into employee9 values(101,'Elijah','HR','DataScience',90000)";
		String q2="insert into employee9 values(102,'Hayley','Manager','cloud',84000)";
		Statement st=con.createStatement();
		int c=st.executeUpdate(q1);
		c=c+st.executeUpdate(q2);
		if(c>0)
            System.out.println("Records inserted:"+c);
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
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Insert.java

C:\Users\egala\OneDrive\Desktop\WT LAB>java Insert
Connected to the database
Records inserted:2
*/