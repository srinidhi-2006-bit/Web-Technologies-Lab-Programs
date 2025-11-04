import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class VerifyCookie extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
	 response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String id=request.getParameter("t3");
    String pwd=request.getParameter("t4");
	Cookie co[]=request.getCookies();
	Boolean flag=false;
	for(int i=0;i<co.length;i++)
	{
		if(id.equals(co[i].getName()))
		{
			if(pwd.equals(co[i].getValue()))
			{
				flag=true;
				out.println("<h1> Login is successfull...<br> Welcome:"+id);
				break;
			}
		}
		if(flag==false)
			out.println("<h1> Invalid credentials</h1>");
	}
    }
}
