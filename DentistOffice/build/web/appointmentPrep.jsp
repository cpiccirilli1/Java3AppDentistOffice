<%-- 
    Document   : appointmentPrep
    Created on : Nov 13, 2019, 3:05:03 PM
    Author     : Chelsea
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.*"  %>
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
            <a href="updateDentistInfo.jsp">Update your information.</a>
        </nav> 
        <div>
            <h2>Upcoming appointments:</h2>
           
            <%
                String id = (String)request.getSession().getAttribute("id");
                appointment app = new appointment();
                app.selectAppts(id);
                ArrayList<appointment> aList = app.getApptList();
                
                for (int i=0; i<aList.size(); i++){
                    appointment a1;
                    a1 = aList.get(i);
                    String pcode = a1.getProc();
                    String time = a1.getAppt();
                    String pat = a1.getPat();
                    String dent = a1.getDent();
                    
                    if (id.equals(dent)){
                        
                        //name
                        loginDB ldb = new loginDB();
                        ldb.selectDB(pat);
                        String name = ldb.getLn()+", "+ldb.getFn();
                    
                        //procedure
                        procedure proc = new procedure();
                        proc.selectDB(pcode);
                        String pname = proc.getProcName();
                %>
                <table>
                    
                    <tr>
                        <td colspan="2"><%= time %></td>
                    </tr>
                    <tr>
                        <td><%= name %></td><td><%= pname %></td>
                    </tr>
                </table>
                 <br/>
                 <br/>
                
                <% } 
            
            }%>
            
            
        </div>
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>

