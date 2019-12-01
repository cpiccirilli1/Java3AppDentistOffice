/**
 *Chelsea Piccirilli
 * changeAppointmentServlet
 * MiniProject Fall 2019
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Business.appointment;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Chelsea
 */
@WebServlet(name = "changeAppointmentServlet", urlPatterns = {"/changeAppointmentServlet"})
public class changeAppointmentServlet extends HttpServlet {

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
            
            
            
            String patid = request.getParameter("patid");
            String day = request.getParameter("day");
            String year = request.getParameter("year");
            String time = request.getParameter("time");
            String dentist = request.getParameter("dentist");
            String procedure = request.getParameter("procedure");
            
            if (patid!=null && day!=null && year!=null && time!=null){
                String time_comp = day+", "+year+", "+time;

                appointment app = new appointment();
                app.appointment(time_comp, patid, dentist, procedure);
                app.updateDB(patid);
                 RequestDispatcher rd = request.getRequestDispatcher("/success.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    System.out.println("Change appointment successful!");
            }
            else{
                 RequestDispatcher rd = request.getRequestDispatcher("/err404.jsp"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                    System.out.println("error: Change appointment Unsuccessful!");
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
