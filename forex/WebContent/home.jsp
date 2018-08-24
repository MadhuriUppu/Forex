<%@page import="java.util.List"%>
<%@page import="com.jsp.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.jsp.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="css/style.css"/>
     <title>Result Page</title>
</head>
<body>
<center>
     <div id="container">
         <h1>Result Page</h1>
             <b>This is Sample Result Page</b><br/>
             <%=new Date()%></br>
             <%
                 User user = (User) session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getUsername()%></b>     
             <br/>
             <a href="logout.jsp">Logout</a>
         </p>
 
         <table>
             <thead>
                 <tr>
                     <th>Client ID</th>
                     <th>Client Name</th>
                     <th>Email ID</th>
                     <th>Phone No</th>
                                     
                 </tr>
             </thead>
             <tbody>
                 <%
                     LoginService loginService = new LoginService();
                     List<User> list = loginService.getListOfUsers();
                     for (User u : list) {
                 %>
                 <tr>
                     <td><%=u.getClientId()%></td>
                     <td><%=u.getUsername()%></td>
                     <td><%=u.getEmailId()%></td>
                     <td><%=u.getPhoneNo()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
</body>
</html>