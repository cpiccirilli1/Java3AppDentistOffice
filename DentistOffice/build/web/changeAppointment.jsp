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
                appointment app = (appointment)request.getSession().getAttribute("app");
                String appt = app.getAppt();
                String id = app.getPat();
                String dent = app.getDent();
                String proc = app.getProc();
                
                String proc_name = "";
                String fn_ln = "";
                String err = "Update Appointment:";
                
                String Day = "";
                String Year = "";
                String Time = "";
                
                String D1="";
                String D2="";
                String D3="";
                String D4="";
                
                String p1 = "";
                String p2 = "";
                String p3 = "";
                String p4 = "";
                String p5 = "";
                String p6 = "";
                String p7 = "";
                String p8 = "";
                
                if (id != null){
                    String[] apptArr = appt.split(", ");
                    Day = apptArr[0];
                    Year = apptArr[1];
                    Time = apptArr[2];


                    //retreives dentist name because no one knows the Dentists code
                    doctorLogin dl = new doctorLogin();
                    dl.selectDB(dent);
                    fn_ln = dl.getFn() + " "+ dl.getLn();
                    String dcode = dl.getId();
                    
                    

                    //retreives procedure name because no one knows procedure code
                    procedure p = new procedure();
                    p.selectDB(proc);
                    proc_name = p.getProcName();
                    
                    if (dcode.equals("D201")){
                        D1 = "Selected";
                      
                    }
                    else if (dcode.equals("D202"))
                    {
                        D2 = "Selected";
                    }
                    else if (dcode.equals("D203"))
                    {
                        D3 = "Selected";
                    }
                    
                    else if (dcode.equals("D204"))
                    {
                        D4 = "Selected";
                    }
                    
                    
                    if(proc.equals("P114")){
                        p1 = "Selected";
                    }
                    else if(proc.equals("P119")){
                        p2 = "Selected";
                    }
                    else if(proc.equals("P122")){
                        p3 = "Selected";
                    }
                    else if(proc.equals("P321")){
                        p4 = "Selected";
                    }
                    else if(proc.equals("P650")){
                        p5 = "Selected";
                    }
                    else if(proc.equals("P660")){
                        p6 = "Selected";
                    }
                    else if(proc.equals("P780")){
                        p7 = "Selected";
                    }
                    else if(proc.equals("P790")){
                        p8 = "Selected";
                    }
                    
                }
                
                else{
                    err = "Error: No appointment scheduled! \n Please go back and Click \"Create a New Appointment.\"";
                    id = "";
                }
                %>
            
            <h2><%= err %></h2>
            
            <form method="post" action="http://localhost:8080/DentistOffice/changeAppointmentServlet">
            <table>
                <tr>
                    <td>Patient Id:</td><td><input type="text" name="patid" value="<%= id %>"></td>
                </tr>
              
                <tr>
                    <td>Day:</td><td><input type="text" name="day" value="<%= Day %>"></td>
                    
                </tr>
                <tr>
                    <td>Year:</td><td><input type="text" name="year" value="<%= Year %>"></td>
                </tr>
                <tr>
                    <td>Time:</td><td><input type="text" name="time" value="<%= Time %>"></td>
                </tr>
                <tr>
                    <td>Dentist:</td><td><select name="dentist">
                            <option value="D201" <%= D1 %>>Frank Martin</option>
                            <option value="D202" <%= D2 %>>Susan Cassidy</option>
                            <option value="D203" <%= D3 %>>Jerry York</option>
                            <option value="D204" <%= D4 %>>Wayne Pattersen</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Procedure:</td><td><select name="procedure">
                            <option value="P114" <%= p1 %>>Cleaning/Exam</option>
                            <option value="P119" <%= p2 %>>X-Rays</option>
                            <option value="P122" <%= p3 %>>Whitening</option>
                            <option value="P321" <%= p4 %>>Cavity</option>
                            <option value="P650" <%= p5 %>>Top Dentures</option>
                            <option value="P660" <%= p6 %>>Bottom Dentures</option>
                            <option value="P780" <%= p7 %>>Crown</option>
                            <option value="P790" <%= p8 %>>Root Canal</option>
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

