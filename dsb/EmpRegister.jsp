<%@page import="java.sql.*" %>
<%
	Integer id=Integer.parseInt(request.getParameter("t1"));
	String name=request.getParameter("t2");
	String des=request.getParameter("t3");
	String dept=request.getParameter("t4");
	Float sal=Float.parseFloat(request.getParameter("t5"));
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","srinidhi","nidhi");
		String q ="insert into employee9 values(?,?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(q);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3,des);
		ps.setString(4,dept);
		ps.setFloat(5,sal);
		int r=ps.executeUpdate();
		if(r==1)
			out.println("<h1>Registered Successfully</h1>");
		ps.close();
		con.close();
	}
	catch(Exception e){
		out.println(e);
	}
%>