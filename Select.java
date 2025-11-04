import java.sql.*;
class Select
{
public static void main(String args[])
{ 
	try
	{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
		System.out.println("Connected to the database");
        String q="select * from employee9";
		Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        while(rs.next())
        {
            System.out.print("ID:"+rs.getInt(1));
            System.out.print("  NAME:"+rs.getString(2));
            System.out.print("  DESIGNATION:"+rs.getString(3));
            System.out.print("  DEPARTMENT:"+rs.getString(4));
            System.out.print("  SALARY:"+rs.getInt(5));
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
C:\Users\egala\OneDrive\Desktop\WT LAB>javac Select.java
C:\Users\egala\OneDrive\Desktop\WT LAB>java Select
Connected to the database
ID:101  NAME:Elijah  DESIGNATION:HR  DEPARTMENT:DataScience  SALARY:90000
ID:102  NAME:Hayley  DESIGNATION:Manager  DEPARTMENT:cloud  SALARY:84000
*/