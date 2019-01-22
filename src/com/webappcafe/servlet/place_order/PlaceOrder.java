package com.webappcafe.servlet.place_order;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Order;
import com.webappcafe.service.OrderService;
import com.webappcafe.service.ProductOrderService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "placeOrder", urlPatterns = {"/placeOrder"})
public class PlaceOrder extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInCustomer");
        long orderId, productId;
        int productQuantity;
        OrderService orderService;
        ProductOrderService prodOrderService;
        
        // Security...
        
        // If customer exists
        
        orderService = new OrderService();
        orderId = orderService.createOrder(customer.getId()); // Gets the last inserted orderId 
        
        // Getting the JSON request in a parameter
        String order = request.getParameter("order");
        
        // Initializing a JSON parser
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(order);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray products = rootObject.getAsJsonArray("products"); // Gets the array "products" as an JSON array
        
        prodOrderService = new ProductOrderService();
        // Traversing through "products" array, getting every "id" and "quantity" value from the JSON string
        for(JsonElement product : products) {
            productId = Long.parseLong(product.getAsJsonObject().get("id").getAsString());
            productQuantity = Integer.parseInt(product.getAsJsonObject().get("quantity").getAsString());
            
            // Creates and inserts the ProductOrder objects
            prodOrderService.createProductOrder(orderId, productId, productQuantity);
        }
    }
}
