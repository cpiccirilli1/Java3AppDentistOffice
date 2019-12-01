/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Business.loginDB;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Chelsea
 */
@WebServlet(name = "updateInformationServlet", urlPatterns = {"/updateInformationServlet"})
public class updateInformationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fn = request.getParameter("fn");
            String ln = request.getParameter("ln");
            String add = request.getParameter("add");
            String email = request.getParameter("email");
            String ins = request.getParameter("ins");
            String patid = request.getParameter("patid");
            String pass = request.getParameter("pass");
            
            if (!fn.equals("") && !ln.equals("") && !add.equals("") && !email.equals("") 
                    && !ins.equals("") && !pass.equals(""))
            { //String id, String fn, String ln, String pwd, String add, String email, String ins
               
                loginDB ldb = new loginDB();
                ldb.loginDB(patid, fn, ln, pass, add, email, ins);
                ldb.updateDB(patid);
                System.out.println("updateInformation - Update Successful.");
                RequestDispatcher rd = request.getRequestDispatcher("/updateSuccess.jsp"); //Forwards to accountlookup.html
                rd.forward(request, response);
            }
            else{
                System.out.println("updateInformation - update Unsuccessful.");
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
