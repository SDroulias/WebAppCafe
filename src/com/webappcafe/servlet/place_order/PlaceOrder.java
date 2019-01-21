package com.webappcafe.servlet.place_order;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.webappcafe.model.Product;
import com.webappcafe.wrapper.ProductWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "placeOrder", urlPatterns = {"/front/placeOrder"})
public class PlaceOrder extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson jsonParser = new Gson();
//        InputStream RequestRawData = request.getInputStream();
//        Scanner input = new Scanner(RequestRawData).useDelimiter("\\A");
//        String JSONRawData = "";
//        
//        while(input.hasNext())
//            JSONRawData = input.next();
//        
//        System.out.println(JSONRawData);
        
        
        String order = request.getParameter("order");
        System.out.println(order);
        
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(order);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray products = rootObject.getAsJsonArray("products");
        
        products.size();
        
    }

}
