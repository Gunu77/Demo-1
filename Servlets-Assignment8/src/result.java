
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.Cookie;




public class result extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
			
			
			
			
			
			
			
				String user=req.getParameter("user");
				String pass=req.getParameter("pass");
				
				res.setContentType("text/html");
				PrintWriter out=res.getWriter();
				
				
				
				
			    
			       
			        String url="jdbc:mysql://localhost:3306/serv3";
					String user1="root";
					String pass1="Novakdjokovic77@";
					String query="select * from login";
			        try {
			        	
			        	Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=DriverManager.getConnection(url,user1,pass1);
						Statement stm=con.createStatement();
						ResultSet rs=stm.executeQuery(query);
						int i=0;
						int j=0;
						
						
						
						
						Cookie c1=new Cookie("user",user);
						Cookie c2=new Cookie ("pass",pass);
						
						out.println("<html>");
						out.println("<body>");
						res.addCookie(c1);
						res.addCookie(c2);
						Cookie[] c=req.getCookies();
						
						
						
						
						
						
						while(rs.next())
						{
						
						
						String first=rs.getString(1);
						String second=rs.getString(2);
						
						if(c==null) {
							out.println("<h1 align='center'><b>Cookies Created for the user " + user + "</b></h1>");
							out.println("<br/>");
							out.println("<br/>");
							out.println("<h1 align='center'><b>Please log in again</b></h1>");
							i=1;
							j=1;
							break;
						}
						
						
						else if(first.equals(c[0].getValue()) && second.equals(c[1].getValue())) {

							 
								 
								 out.println("<h1 align='center'><b>Welcome " + user + "</b></h1>");
								 
								 
							 
							
					           i=1;
					           
					           
					           break;
							
						}
						
						
						
						}
						
						if(i==0) {
							
							
					           out.println("<h1 align='center'><b>User name or Password is Incorrect</b></h1>");
					          
					          
					           
							}
						
						out.println("</body>");
						out.println("</html>");
						
						if(j==0) {
							
							
							c1.setValue(null);
							c2.setValue(null);
							
							c1.setMaxAge(0);
							c2.setMaxAge(0);
							
							res.addCookie(c1);
							res.addCookie(c2);
						}
						
						out.close();
						stm.close();
						con.close();
					

			            
			           
			           
			        }
			        catch(Exception e) {
			            e.printStackTrace();
			        }
			                       
			    }
				
	
				
				
		        
				
	}
			
			