<%-- 
    Document   : updateInformation
    Created on : Nov 13, 2019, 1:57:46 PM
    Author     : Chelsea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Chatt Dental Group</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <header>
            <h1>Chatt Dental Group</h1>
        </header>
        <nav>
            <a href="index.jsp">Home</a> <a href="login.jsp">Patient Login</a> 
            <a href="dentistLogin.jsp">Dentist Login</a>
        </nav> 
        <div>
            <%
                
                loginDB pat = (loginDB)request.getSession().getAttribute("pat");
                String patid = pat.getId();
                String pass = pat.getPwd();
                String fn = pat.getFn();
                String ln = pat.getLn();
                String address = pat.getAddress();
                String email = pat.getEmail();
                String ins = pat.getIns();
                
                %>
             
            
            <form method="post" action="http://localhost:8080/DentistOffice/updateInformationServlet">
                <table>
                    <tr>
                        <td>First Name:</td><td><input type="text" name="fn" value="<%= fn %>"></td>
                        
                    </tr>
                    <tr>
                        <td>Last Name:</td><td><input type="text" name="ln" value="<%= ln %>"></td>
                        
                    </tr>
                    
                    <tr>
                        <td>Address:</td><td><input type="text" name="add" value="<%= address %>"></td>
                        
                    </tr>
                    <tr>
                        <td>Email:</td><td><input type="text" name="email" value="<%= email %>"></td>
                    </tr>
                    <tr>
                        <td>Insurance Co.:</td><td><input type="text" name="ins" value="<%= ins %>"></td>
                    </tr>
                    <tr>
                        <td>Patient Id.:</td><td><input type="text" name="patid" value="<%= patid %>"></td>
                    </tr>
                    
                    <tr>
                        <td>Password:</td><td><input type="text" name="pass" value="<%= pass %>"></td>
                    </tr>
                </table>
                
            </form>
        </div>
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>

