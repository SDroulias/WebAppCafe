package com.webappcafe.servlet.customer;

import com.webappcafe.dao.*;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Order;
import com.webappcafe.model.Product;
import com.webappcafe.model.ProductOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "viewCustomerOrders", value = {"/viewCustomerOrders"})
public class ViewCustomerOrders extends HttpServlet {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(".###");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDAO orderDAO = new OrderDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        ProductOrderDAO productOrderDAO = new ProductOrderDAOImpl();

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            response.sendRedirect("landingPage.html");

        } else {

            List<Order> customerOrders = orderDAO.getOrdersByCustomerId(customer.getId());

            for (Order order : customerOrders) {

                List<Product> productList = productDAO.getProductsOfOrder(order.getId());

                List<ProductOrder> productOrderList = productOrderDAO.getProductsOrdersByOrderId(order.getId());

                Iterator<Product> productIterator = productList.iterator();
                Iterator<ProductOrder> productOrderIterator = productOrderList.iterator();

                List<String> productsOfOrder = new ArrayList<>();

                double totalPrice = 0;
                while (productIterator.hasNext() && productOrderIterator.hasNext()) {

                    Product product = productIterator.next();
                    ProductOrder productOrder = productOrderIterator.next();

                    //creates products list of String with name and quantity
                    String productString = product.getName() + " x " + productOrder.getProductsQuantity();
                    productsOfOrder.add(productString);

                    //calculates the total price of an order
                    totalPrice += (product.getPrice() * productOrder.getProductsQuantity());
                }
                order.setProductsOfOrder(productsOfOrder);
                order.setTotalPrice(totalPrice);
            }

            request.setAttribute("DATE_TIME_FORMATTER", DATE_TIME_FORMATTER);
            request.setAttribute("DECIMAL_FORMAT", DECIMAL_FORMAT);
            request.setAttribute("customerOrders", customerOrders);
            request.getRequestDispatcher("viewCustomerOrders.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
