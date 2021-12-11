package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.ejb.CarBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@DeclareRoles({"AdminRole", "ClientRole"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"AdminRole"})
)

@WebServlet(name = "Cars", urlPatterns = {"/Cars"})
public class Cars extends HttpServlet {

    @Inject
    private CarBean carBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cars</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cars at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.setAttribute("activePage", "Cars");
        request.setAttribute("numberOfFreeParkingSpots", 10);
        List<CarDetails> cars = carBean.getAllCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request, response);
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

        String[] carIdsString = request.getParameterValues("car_ids");
        if (carIdsString != null) {
            List<Integer> carIds = new ArrayList<>();
            for (String id : carIdsString) {
                carIds.add(Integer.parseInt(id));
            }
            carBean.deleteCarsByIds(carIds);
        }
        response.sendRedirect(request.getContextPath() + "/Cars");
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