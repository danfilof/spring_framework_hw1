package com.geekbrains.app.Servlets;

import com.geekbrains.app.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        int upperbound = 250;
        int lowerbound = 1;
        String[] arr = {"Volvo", "Kinder", "the Beatles vinyl", "Gold", "Pickle", "Flash", "Tent", "Detector", "Lada", "Spider", "Button", "Pie", "Cherry", "Java for chainiki", "Tree"};
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int int_random = (int)Math.floor(Math.random()*(upperbound - lowerbound + 1) + lowerbound);
            int randomProductName = r.nextInt(arr.length);
            String prName = arr[randomProductName];
            Product pr = new Product(int_random, prName, int_random);
            resp.getWriter().printf("<h1>"+ "ID of the product: " + pr.getId() + " || " + "Name of the product: " + pr.getTitle() + " || " + "Price of the product: "+ pr.getCost() +"</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }
}
