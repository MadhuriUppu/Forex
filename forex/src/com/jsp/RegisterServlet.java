package com.jsp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     
     String username = request.getParameter("userName");
     String password = request.getParameter("password");
     String email=request.getParameter("emailId");
     int phoneNo=Integer.parseInt(request.getParameter("phoneNo"));
     int govtId=Integer.parseInt(request.getParameter("govtId"));
     int bankNo=Integer.parseInt(request.getParameter("bankNo"));
     
     Date d=new Date();
     
     String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    
     
     
     User user = new User(govtId,username,password,email,phoneNo,bankNo);
             
     try { 
         RegisterService registerService = new RegisterService();
         
         boolean result = registerService.register(user);      
         out.println("<html>");
         out.println("<head>");      
         out.println("<title>Registration Successful</title>");    
         out.println("</head>");
         out.println("<body>");
         out.println("<center>");
         if(result){
             out.println("<h1>Thanks for Registering with us :</h1>");
             out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
         }
         else{
             out.println("<h1>Registration Failed</h1>");
             out.println("To try again<a href=register.jsp>Click here</a>");
         }
         out.println("</center>");
         out.println("</body>");
         out.println("</html>");
     } finally {       
         out.close();
     }
}
 
}