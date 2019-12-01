/*
*Chelsea Piccirilli
*Mini Project
*Login Servlet
*/
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Business.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Chelsea
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Takes id and pass parameters and depending on if the code is a 
     * patient or dentist id, attempts to get login information to match against given
     * values. Pushes to the area required.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String id = request.getParameter("idtb");
            String pass = request.getParameter("passtb");
            
            HttpSession ses = request.getSession();
            
            if (id.contains("A")){
                         
                loginDB pat = new loginDB();
                pat.selectDB(id);
                String pwd = pat.getPwd();                
                ses.setAttribute("pat", pat);
                
                if (pass.equals(pwd)){
                    appointment app = new appointment();
                    app.selectDB(id);
                    
                    
                    if (app.getAppt() != null){                        
                        ses.setAttribute("app", app);  //Stores customer object to session

                        System.out.println("Patient appointment added to session.");
                    }
                    else{
                        
                        ses.setAttribute("id", id);
                    }
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/appointmentDisplay.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    System.out.println("login: Patient "+id+" successful log in.");
                }
                
                else{
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/err.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    System.out.println("login: Patient "+id+" UNSUCCESSFUL log in.");
                }
                
                
            }
            
            if(id.contains("D")){
                
                doctorLogin doc = new doctorLogin();
                doc.selectDB(id);
                String pwd = doc.getPwd();
                ses.setAttribute("dl", doc);
                
                if (pass.equals(pwd)){                    
                    
                    ses.setAttribute("id", id);
                    RequestDispatcher rd = request.getRequestDispatcher("/appointmentPrep.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    System.out.println("Dentist "+id+" successful log in.");
                
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("/err.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    
                    System.out.println("Dentist "+id+ " UNSUCCESSFUL log in.");
                    
                }
                
            }            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
