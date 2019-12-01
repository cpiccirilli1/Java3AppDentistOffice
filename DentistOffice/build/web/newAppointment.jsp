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
                String id = (String)request.getSession().getAttribute("id");
                %>
            
            <h2>Creating a new appointment:</h2>
            <form method="post" action="http://localhost:8080/DentistOffice/newAppointmentServlet">
            <table>
                <tr>
                    <td>Patient Id:</td><td><input type="text" name="patid" value="<%= id %>"></td>
                        
                </tr>
              
                <tr>
                    <td>Day:</td><td><input type="text" name="day"></td>
                    
                </tr>
                <tr>
                    <td>Year:</td><td><input type="text" name="year"></td>
                </tr>
                <tr>
                    <td>Time:</td><td><input type="text" name="time"></td>
                </tr>
                <tr>
                    <td>Dentist:</td><td><select name="dentist">
                            <option value="D201">Frank Martin</option>
                            <option value="D202" >Susan Cassidy</option>
                            <option value="D203" >Jerry York</option>
                            <option value="D204" >Wayne Pattersen</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Procedure:</td><td><select name="procedure">
                            <option value="P114" >Cleaning/Exam</option>
                            <option value="P119" >X-Rays</option>
                            <option value="P122" >Whitening</option>
                            <option value="P321" >Cavity</option>
                            <option value="P650" >Top Dentures</option>
                            <option value="P660" >Bottom Dentures</option>
                            <option value="P780" >Crown</option>
                            <option value="P790" >Root Canal</option>
                        </select>
                    
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
