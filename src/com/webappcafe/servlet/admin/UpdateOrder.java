package com.webappcafe.servlet.admin;

import com.webappcafe.dao.OrderDAO;
import com.webappcafe.dao.OrderDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "UpdateOrder", urlPatterns = {"/UpdateOrder"})
public class UpdateOrder extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("./");
        } else {

            OrderDAO orderDAO = new OrderDAOImpl();

            orderDAO.updateOrderStatus(Long.parseLong(request.getParameter("id")), "complete");
        }


    }
}
