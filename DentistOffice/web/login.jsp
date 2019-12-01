<%-- 
    Document   : login
    Created on : Nov 11, 2019, 12:57:53 PM
    Author     : Chelsea
--%>

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
            <a href="index.jsp">Home</a> <a href="login.jsp">Patient Login</a> 
            <a href="dentistLogin.jsp">Dentist Login</a>
        </nav> 
        <div>
            <h2>Patient Login:</h2>
            <form method="post" action="http://localhost:8080/DentistOffice/login">
                <table>
                    <tr>
                        <td>Patient ID:</td><td><input type="text" name="idtb" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td><td><input type="password" name="passtb" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submitbtn" value="login" /> 
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

