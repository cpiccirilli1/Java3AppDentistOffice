/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Business.*;
/**
 *
 * @author Chelsea
 */
@WebServlet(name = "doctorInfoUpdate", urlPatterns = {"/doctorInfoUpdate"})
public class doctorInfoUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Servlet that Updates the dentists database using the doctorLogin class
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Gets the parameters
            String id = request.getParameter("id");
            String fn = request.getParameter("fn");
            String ln = request.getParameter("ln");
            String pass = request.getParameter("pass");
            String office = request.getParameter("office");
            String email = request.getParameter("email");
            
            if(!office.equals("") && !pass.equals("") && !ln.equals("")
                    && !fn.equals("") && !email.equals("")){
                
                doctorLogin dl = new doctorLogin();
                dl.selectDB(id);
                dl.setId(id);
                dl.setFn(fn);
                dl.setLn(ln);
                dl.setPwd(pass);
                dl.setOffice(office);
                dl.setEmail(email);
                dl.display();
                dl.updateDB(id);
                
                
                System.out.println("doctorInfoUpdate - Update Successful.");
                RequestDispatcher rd = request.getRequestDispatcher("/updateSuccess.jsp"); //Forwards to accountlookup.html
                rd.forward(request, response);
            }
            else{
                System.out.println("doctorInfoUpdate - Update Unsuccessful.");
                RequestDispatcher rd = request.getRequestDispatcher("/updateErr.jsp"); //Forwards to accountlookup.html
                rd.forward(request, response);
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
