import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ConfigDemo extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        ServletConfig conf=getServletConfig();
        String u=conf.getInitParameter("username");
        String p=conf.getInitParameter("password");
        out.println("<h1>");
        out.println("Initialization Parameters from web.xml");
        out.println("Username:"+u);
        out.println("Password:"+p);
        out.println("</h1>");
    }
}

/*output:
http://localhost:8084/dsb/Config
Initialization Parameters from web.xml Username:admin Password:admin
*/