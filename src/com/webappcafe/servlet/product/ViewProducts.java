package com.webappcafe.servlet.product;

import com.webappcafe.dao.ProductDAO;
import com.webappcafe.dao.ProductDAOImpl;
import com.webappcafe.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewProducts", urlPatterns = {"/viewProducts"})
public class ViewProducts extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAOImpl();

        List<Product> products = productDAO.getAllProducts();

        request.setAttribute("products", products);
//        response.sendRedirect("viewProducts.jsp");
        request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

