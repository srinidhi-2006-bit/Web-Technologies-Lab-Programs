import javax.servlet.*;
import java.io.*;
public class HelloGenericServlet extends GenericServlet
{
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello CSE-DS</h1>");
    }
}