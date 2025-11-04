<%@page import="java.sql.*" %>
<html>
<body>
<h1 align="center">Details of the Books</h1>
<%
try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "srinidhi", "nidhi");
    String q = "select * from books1";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(q);
%>

<table cellspacing=0 align=center border=2 cellpadding=10>
<tr>
    <th>Title</th>
    <th>Author</th>
    <th>ISBN</th>
    <th>Publisher</th>
    <th>Edition</th>
    <th>Price</th>
</tr>

<%
    while(rs.next()) {
%>
<tr>
    <td><%= rs.getString("title") %></td>
    <td><%= rs.getString("author") %></td>
    <td><%= rs.getString("isbn") %></td>
    <td><%= rs.getString("publisher") %></td>
    <td><%= rs.getInt("edition") %></td>
    <td><%= rs.getInt("price") %></td>
</tr>
<%
    }

    rs.close();
    st.close();
    con.close();
} 
catch(Exception e) {
    out.println(e);
}
%>

</table>
</body>
</html>
