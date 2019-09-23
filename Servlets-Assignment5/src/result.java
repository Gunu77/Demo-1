
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;





public class result extends HttpServlet {
	
	
	Connection con;
	Statement stm;
	ResultSet rs;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			
			String url="jdbc:mysql://localhost:3306/serv4";
			String user1="root";
			String pass1="Novakdjokovic77@";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,user1,pass1);
			stm=con.createStatement();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}  
		
		
	}
	
	public void destroy() {
		try {
			
			stm.close();
			con.close();
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	

	
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
			
			
			
			
			
			
			
				String user=req.getParameter("user");
				String pass=req.getParameter("pass");
				int i=0;
				
				res.setContentType("text/html");
				PrintWriter out=res.getWriter();
				
				
				
				
			    
			       
			        
					String query="select * from users";
			        try {
			        	
			        	
						rs=stm.executeQuery(query);
						
						
						while(rs.next())
						{
						
						
						String first=rs.getString(1);
						String second=rs.getString(2);
						String third=rs.getString(3);
						char c=third.charAt(0);
						
						if(first.equals(user) && second.equals(pass)) {
							
							if(c=='A') {
								
								
								
								out.println("<html>");
								out.println("<body>");
								out.println("<h1 align ='center'><b>Admin Homepage</b></h1>");
								out.println("<br/><br/>");
								out.println("<h3 align='center'><b><a href='addtraining.html'>Add Training</a></b></h3>");
								out.println("<br/><br/>");
								out.println("<h3 align='center'><b><a href='delresult'>Delete Training</a></b></h3>");
								out.println("</body>");
								out.println("</html>");
								i=1;
								break;
						          
							}
							
							else if(c=='E') {

								
								out.println("<html>");
								out.println("<body>");
								out.println("<h1 align ='center'><b>Employee Homepage</b></h1>");
								out.println("</body>");
								out.println("</html>");
								i=1;
								break;
					           
					           
							}
							
							
							
						}
						
						
						
						
						
						
					

			            
			           
			           
			        }
						
						if(i==0) {
						
							out.println("<html>");
							out.println("<body>");
							out.println("<h1 align ='center'><b>Invalid Username or Password</b></h1>");
							out.println("</body>");
							out.println("</html>");
						
						}
						
						out.close();
						
			        }
			        
			        
			        catch(Exception e) {
			            e.printStackTrace();
			        }
			                       
			    }
	

	
				
	
				

		        
				
	}

