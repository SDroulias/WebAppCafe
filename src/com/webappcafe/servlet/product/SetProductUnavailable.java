/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappcafe.servlet.product;

import com.webappcafe.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "setProductUnavailable", urlPatterns = {"/setProductUnavailable"})
public class SetProductUnavailable extends HttpServlet {

   
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
            response.sendRedirect("landingPage.html");
        } else {
            ProductService service = new ProductService();

            service.updateProductAvailability(Long.parseLong(request.getParameter("id")), false);
        }


    }
}
