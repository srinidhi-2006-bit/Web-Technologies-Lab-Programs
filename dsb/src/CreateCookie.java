import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CreateCookie extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
	 response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String id=request.getParameter("t1");
    String pwd=request.getParameter("t2");
	Cookie c=new Cookie(id,pwd);
	out.println("<h1>Registered Successfully! Cookie created...</h1>");
	response.addCookie(c);
    }
}
