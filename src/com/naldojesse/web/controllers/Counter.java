package com.naldojesse.web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet("")
public class Counter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("counter") == null) {
            int counter = 0;
            session.setAttribute("counter", counter);
        } else {
            int count = (int) session.getAttribute("counter");
            count = count + 1;
            session.setAttribute("counter", count);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int counter = (int) session.getAttribute("counter");

        request.setAttribute("counter", counter);


        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }
}
