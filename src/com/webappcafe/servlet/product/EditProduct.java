package com.webappcafe.servlet.product;

import com.webappcafe.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {

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
//        Customer customer = (Customer) session.getAttribute("admin");

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("./");
        } else {
            ProductService service = new ProductService();
            service.editProduct(Long.parseLong(request.getParameter("id")),
                    request.getParameter("name"),
                    Double.parseDouble(request.getParameter("price")),
                    request.getParameter("description"));
        }
    }
    
}
