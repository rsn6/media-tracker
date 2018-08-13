package edu.csueb.mediatracker.servlet;

import edu.csueb.mediatracker.bean.Title;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.TitleUtil;
import util.UserUtil;


public class TitleServlet extends HttpServlet {

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
        String url = "/index.jsp";
        if(null != request.getParameter("method")){
            String method = request.getParameter("method");
            
            if(method.equals("deleteTVTitle")){
                TitleUtil.removeTVTitle(request.getParameter("name"));
            }
            else if(method.equals("addTVTitle")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                TitleUtil.addTVTitle(t);
                url = "/index.jsp";
            }
            else if(method.equals("addMovieTitle")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                TitleUtil.addMovieTitle(t);
                url = "/index.jsp";
            }
            else if(method.equals("deleteMovieTitle")){
                TitleUtil.removeMovieTitle(request.getParameter("name"));
            }
            else if(method.equals("editTV")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                TitleUtil.updateTVTitle(t);
                url = "/index.jsp";
            }
            else if(method.equals("showEditTVForm")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                request.setAttribute("tvtoedit", t);
                url = "/editTV.jsp";
            }
            else if(method.equals("editMovie")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                TitleUtil.updateMovieTitle(t);
                url = "/index.jsp";
            }
            else if(method.equals("showEditMovieForm")){
                Title t = new Title(request.getParameter("name"), request.getParameter("genre"), request.getParameter("year"));
                request.setAttribute("movietoedit", t);
                url = "/editMovie.jsp";
            }
        }     
        request.setAttribute("tvtitles", TitleUtil.getTVTitles());
        request.setAttribute("movietitles", TitleUtil.getMovieTitles());
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
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
