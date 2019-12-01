<%-- 
    Document   : newAppointment
    Created on : Nov 11, 2019, 2:20:39 PM
    Author     : Chelsea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ChattBank - One stop shop for a blank login.</title>
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
                doctorLogin dl = (doctorLogin)request.getSession().getAttribute("dl");
                String id = dl.getId();
                String fn = dl.getFn();
                String ln = dl.getLn();
                String email = dl.getEmail();
                String office = dl.getOffice();
                String pass = dl.getPwd();
                %>
            
            <h2>Update Dentist Information:</h2>
            <form method="post" action="http://localhost:8080/DentistOffice/doctorInfoUpdate">
            <table>
                <tr>
                    <td>Dentist Id:</td><td><input type="text" name="patid" value="<%= id %>"></td>
                        
                </tr>
              
                <tr>
                    <td>First Name:</td><td><input type="text" name="fn" value="<%= fn %>"></td>
                    
                </tr>
                <tr>
                    <td>Last Name:</td><td><input type="text" name="ln" value="<%= ln %>"></td>
                </tr>
                <tr>
                    <td>E-Mail:</td><td><input type="text" name="email" value="<%= email %>"></td>
                </tr>
                <tr>
                    <td>Office:</td><td><input type="text" name="office" value="<%= office %>">
                    </td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="text" name="pass" value="<%= pass %>">
                    </td>
                </tr>
                <tr>
                        <td></td>
                        <td><input type="submit" name="submitbtn" value="Update" /> 
                        <input type="reset" value="clear" /></td>
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
