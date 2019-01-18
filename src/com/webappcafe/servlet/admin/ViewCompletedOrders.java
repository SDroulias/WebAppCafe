package com.webappcafe.servlet.admin;

import com.webappcafe.dao.OrderDAO;
import com.webappcafe.dao.OrderDAOImpl;
import com.webappcafe.dao.ProductOrderDAO;
import com.webappcafe.dao.ProductOrderDAOImpl;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Order;
import com.webappcafe.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "viewCompletedOrders", value = {"/viewCompletedOrders"})
public class ViewCompletedOrders extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        ProductDAO productDAO = new ProductDAOImpl();
//
//        List<Product> products = productDAO.getAllProducts();
//
//        request.setAttribute("products", products);
//        request.getRequestDispatcher("viewProducts.jsp").forward(request, response);

        OrderDAO orderDAO = new OrderDAOImpl();

        ProductOrderDAO productOrderDAO = new ProductOrderDAOImpl();

        Map<Order, Customer> completedOrders = orderDAO.getCompletedOrders("complete");

//        List<Product> productList = new ArrayList<>();

        for (Map.Entry<Order, Customer> entry : completedOrders.entrySet()) {

            List<Product> productList = productOrderDAO.getProductsOfOrder(entry.getKey().getId());

            StringBuilder productsOfOrderSB = new StringBuilder();

            List<String> productsOfOrder = new ArrayList<>();
            for (Product product : productList) {

//                productsOfOrderSB.append(product.getName()).append("\n");
                productsOfOrder.add(product.getName());
            }

            entry.getKey().setProductsOfOrder(productsOfOrder);

//            productsOfOrder.add(productsOfOrderSB);

//            System.out.println(entry.getKey() + " / " + entry.getValue());

//            System.out.println(entry.getKey()entry.getValue());
//            System.out.println(entry.getKey().getCustomerId() entry.getValue());
        }

        request.setAttribute("completedOrders", completedOrders);
        request.getRequestDispatcher("viewCompletedProducts.jsp").forward(request, response);



    }
}
