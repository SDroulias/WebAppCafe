package com.webappcafe.servlet.product;

import com.webappcafe.service.ProductService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "viewProducts", value = {"/admin/viewProducts"})
public class ViewProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductService service = new ProductService();
        
        request.setAttribute("products", service.getAvailableProducts());
        request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
