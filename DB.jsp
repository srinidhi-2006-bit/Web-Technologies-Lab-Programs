<%@page import="java.sql.*" %>
<html>
<body>
<h1 align="center"> Details of the Employees</h1>
<%
try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "cseds");
    String q = "select * from employee9";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(q);
%>

<table cellspacing=0 align=center border=2 cellpadding=10>
<tr>
    <th>Employee ID</th>
    <th>Employee Name</th>
    <th>Designation</th>
    <th>Department</th>
    <th>Salary</th>
</tr>

<%
    while(rs.next()) {
%>
<tr>
    <td><%= rs.getString(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3) %></td>
    <td><%= rs.getString(4) %></td>
    <td><%= rs.getString(5) %></td>
</tr>
<%
    }

    rs.close();
    st.close();
    con.close();
} 
catch(Exception e) 
{
    out.println(e);
}
%>

</table>
</body>
</html>