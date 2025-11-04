import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ContextDemo extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        ServletContext cont=getServletContext();
        String a=cont.getInitParameter("appName");
        String v=cont.getInitParameter("appVersion");
        out.println("<h1>");
        out.println("Context Parameters from web.xml");
        out.println("Application Name:"+a);
        out.println("Application Version:"+v);
        out.println("</h1>");
    }
}
/*output:
http://localhost:8084/dsb/Context
Context Parameters from web.xml Application Name:My Application Application Version:1.0.1
*/