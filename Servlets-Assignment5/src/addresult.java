
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;





public class addresult extends HttpServlet {
	
	
	
	Connection con1;
	Statement stm1;
	
	
	public void init(ServletConfig config) throws ServletException {
		try {
			
			String url="jdbc:mysql://localhost:3306/server5";
			String user1="root";
			String pass1="Novakdjokovic77@";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con1=DriverManager.getConnection(url,user1,pass1);
			stm1=con1.createStatement();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}  
		
		
	}
	
	
	public void destroy() {
		try {
			
			stm1.close();
			con1.close();
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
			
			
		
				
				
				
				
				
				
				
				
				
			    
			       
			       
					
					
			        try {
			        	
			        	res.setContentType("text/html");
			    		PrintWriter out=res.getWriter();
			    		out.println("<html>");
			    		out.println("<body>");
			    			
			    			
			    			
			    			
			    				String id=req.getParameter("id");
			    				String name=req.getParameter("name");
			    				String start=req.getParameter("start");
			    				String end=req.getParameter("end");
			    				String mode=req.getParameter("mode");
			        	
			        	
						PreparedStatement stm2=(PreparedStatement) con1.prepareStatement("insert into training(id,name,start,end,mode)" + "values(?,?,?,?,?)");
						
						
						
						stm2.setString(1,id);
						stm2.setString(2,name);
						stm2.setString(3,start);
						stm2.setString(4,end);
						stm2.setString(5,mode);
						
						stm2.executeUpdate();
						
						
						
						
						
								
								
						out.println("<h1 align='center'><b>Training Details added</b></h1>");
						out.println("</body>");
						out.println("</html>");
						
						out.close();
						
			        }
			        
			        
			        catch(Exception e) {
			            e.printStackTrace();
			        }
			                       
			    }
	
	
				
				
	
				

		        
				
	}


