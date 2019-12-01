<%-- 
    Document   : appointmentDisplay
    Created on : Nov 11, 2019, 1:42:58 PM
    Author     : Chelsea
--%>


<%@page import="Business.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <a href="index.html">Home</a> <a href="login.html">Patient Login</a> 
            <a href="dentistLogin.jsp">Dentist Login</a>
        </nav> 
        <div>
            <%
                
            appointment app = (appointment)request.getSession().getAttribute("app");
            String appt = app.getAppt();
            String id = app.getPat();
            String dent = app.getDent();
            String proc = app.getProc();
            
            if (appt == null){
                appt = "No appointment scheduled!";
            }
            %>
           
            <table>
                <tr> <th>Current Appointment: </th></tr>
                <tr><th><%= appt %></th></tr>
            </table>
            <br/>
            <br/>
            <table>
                <tr><td><a href="newAppointment.jsp">Create a new appointment.</a></td></tr>
                <tr><td><a href="changeAppointment.jsp">Change your appointment.</a></td></tr>
                <tr><td><a href="updateData.jsp">Update Patient Information.</a></td></tr>
            </table>
        </div>
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>


