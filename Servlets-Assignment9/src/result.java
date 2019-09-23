
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.Cookie;





public class result extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
			
			
			
			
			
			
			
				
				
				
				
			    
			       
			       
			        try {
			        	
			        	
						
						

						String user=req.getParameter("user");
						String pass=req.getParameter("pass");
						
						res.setContentType("text/html");
						PrintWriter out=res.getWriter();
						
						
						
						Cookie c1=new Cookie("user",user);
						Cookie c2=new Cookie ("pass",pass);
						out.println("<html>");
						out.println("<body>");
						res.addCookie(c1);
						res.addCookie(c2);
						Cookie[] c=req.getCookies();
						
						 
						 if (c.equals(null)) {
							out.println("<h1 align='center'><b>Welcome new user " + user + "</b></h1>");
						 }
						
						 else {
							 
							 
							 
							 if (c[0].getValue().equals(user) && c[1].getValue().equals(pass)) {
								 
							 out.println("<h1 align='center'><b>Welcome back " + user + "</b></h1>");
							 
							 }
						 
						 else {
							 out.println("<h1 align='center'><b>Welcome new user " + user + "</b></h1>");
							 
						 }
							 
						 }
						 
						
						 out.println("</body>");
						 out.println("</html>");
						
						out.close();
						

			            
						
			           
			        }
			        catch(Exception e) {
			            e.printStackTrace();
			        }
			                       
			    }
				
	
				
				
		        
				
	}







