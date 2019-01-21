package com.webappcafe.servlet.place_order;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.webappcafe.model.Product;
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
        
        Gson json = new Gson();
        JsonParser parser = new JsonParser();
//        InputStream RequestRawData = request.getInputStream();
//        Scanner input = new Scanner(RequestRawData).useDelimiter("\\A");
//        String JSONRawData = "";
//        
//        while(input.hasNext())
//            JSONRawData = input.next();
//        
//        System.out.println(JSONRawData);
        
        
        String order = request.getParameter("order");
        JsonElement jsonTree = parser.parse(order);
        System.out.println(order);
        
    }

}
