package edu.csueb.mediatracker.servlet;

import edu.csueb.mediatracker.bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.UserUtil;


public class UserServlet extends HttpServlet {

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
        String type = request.getParameter("formtype");
        String email, password, firstname, lastname;
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String url ="/login.jsp";
        
        if(type.equals("login")){
            email = request.getParameter("email");
            password = request.getParameter("password");
            user = UserUtil.authUser(email, password);
            if(user == null){
                url = "/login.jsp";
                request.setAttribute("invalid", "Wrong password or email");
            }
            else{
                url = "/welcome.jsp";
                session.setAttribute("user", user);
            }
        }
        else if(type.equals("signup")){
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            email = request.getParameter("email");
            password = request.getParameter("password");
            user = new User(firstname, lastname, email, password);
            request.setAttribute("user", user);
            String error = UserUtil.validateUser(user);
            if(!error.equals("")){
                url = "/signup.jsp";
                request.setAttribute("error", error);
            }
            else{
                UserUtil.addUser(user);
                url = "/login.jsp";
            }
            
            
        }
        session.setAttribute("user", user);
        request.getServletContext().getRequestDispatcher(url).forward(request, response);
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
