package com.webappcafe.servlet.admin;

import com.webappcafe.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "viewProducts", value = {"/admin/viewProducts"})
public class ViewProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("./");
        } else {
            ProductService service = new ProductService();

            request.setAttribute("products", service.getAvailableProducts());
            request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
