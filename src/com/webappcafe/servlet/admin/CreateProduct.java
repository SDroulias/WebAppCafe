package com.webappcafe.servlet.admin;

import com.webappcafe.dao.ProductDAO;
import com.webappcafe.dao.ProductDAOImpl;
import com.webappcafe.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "createProduct", value = {"/admin/createProduct"})
public class CreateProduct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("./");
        } else {
            ProductDAO productDAO = new ProductDAOImpl();

            Product product = Product.createProduct(request.getParameter("productName"),
                    request.getParameter("description"),
                    Double.parseDouble(request.getParameter("price")));

            productDAO.saveProduct(product);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
