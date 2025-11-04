import java.sql.*;
class DMetaData
{ 
    public static void main(String args[])
    {
        try
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
            System.out.println("Connected to the database");
            DatabaseMetaData dbmd=con.getMetaData();
            System.out.println("Database Name:"+dbmd.getDatabaseProductName());
            System.out.println("Database Version:"+dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name:"+dbmd.getDriverName());
            System.out.println("Driver Version:"+dbmd.getDriverVersion());
            System.out.println("JDBC URL:"+dbmd.getURL());
            System.out.println("Username:"+dbmd.getUserName());
            System.out.println("Maxzimum Connections:"+dbmd.getMaxConnections());
            System.out.println("Transaction support:"+dbmd.supportsTransactions());
            String types[]={"TABLE","VIEW"};
            ResultSet rs=dbmd.getTables(null,"SYSTEM", "S%", types);
            while(rs.next())
            {
                System.out.println("Table Name:"+rs.getString("TABLE_NAME")+" "+"Type:"+rs.getString("TABLE_TYPE"));
            }
            System.out.println();
            con.close();
            rs.close();
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
/*output:
 * C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>javac DMetaData.java

C:\Users\CVR\Desktop\23B81A67B4_WT_LAB>java DMetaData
Connected to the database
Database Name:Oracle
Database Version:Oracle Database 10g Express Edition Release 10.2.0.1.0 - Production
Driver Name:Oracle JDBC driver
Driver Version:10.2.0.1.0XE
JDBC URL:jdbc:oracle:thin:@localhost:1521/XE
Username:SYSTEM
Maxzimum Connections:0
Transaction support:true
Table Name:SQLPLUS_PRODUCT_PROFILE Type:TABLE
Table Name:STUDENT Type:TABLE
Table Name:STUDENT1 Type:TABLE
Table Name:STUDENT11 Type:TABLE
Table Name:STUDENTS Type:TABLE
 */