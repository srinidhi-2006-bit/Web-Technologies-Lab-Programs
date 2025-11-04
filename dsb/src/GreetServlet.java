import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GreetServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("t1");
	    out.println("<h1>");
        out.println("Hello "+n);
        out.println("</h1>");
    }
}
