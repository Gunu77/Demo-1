
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;





public class delresult extends HttpServlet {
	
	
	
	Connection con1;
	Statement stm1;
	ResultSet rs1;
	
	
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
			
			
		
				
				
				
				
				
				
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 align='center'><b>Select the training to be deleted</b></h1>");
		out.println("<br/><br/>");
		out.println("<form action='delresult2' method='get'>");
				
				
			    
			       
			       
					
		try {
			rs1=stm1.executeQuery("select name from training");
			while(rs1.next())
			{
				out.println("<input type='radio' name='name' value="+ rs1.getString(1)+">"+rs1.getString(1));
			
				out.println("<br>");
			}
		}
			        
			        
			        catch(SQLException e) {
			            e.printStackTrace();
			        }
			        
			        out.println("<br/><br/>");
			        out.println("<input type='submit' value='submit'>");
					out.println("</form>");
			       
					out.println("</body>");
					out.println("</html>");
					
					out.close();
			                       
			    }
	
	
				
				
	
				

		        
				
	}



