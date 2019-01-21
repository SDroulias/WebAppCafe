package com.webappcafe.servlet.place_order;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "placeOrder", urlPatterns = {"/front/placeOrder"})
public class PlaceOrder extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String order = request.getParameter("order");
        
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(order);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray products = rootObject.getAsJsonArray("products");
        
        
        for(JsonElement product : products) {
            product.getAsJsonObject().get("id").getAsString();
            product.getAsJsonObject().get("quantity").getAsString();
        }
    }
}
