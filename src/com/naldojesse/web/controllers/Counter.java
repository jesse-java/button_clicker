package com.naldojesse.web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet("")
public class Counter extends HttpServlet {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String genAlphaNum() {
        String returnStr = "";

        for (int i = 0; i < 15; i++) {

            int randomChar = ThreadLocalRandom.current().nextInt(0, alphabet.length());
            returnStr += alphabet.charAt(randomChar);

        }

        return returnStr;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
//
//        if (session.getAttribute("counter") == null) {
//            int counter = 0;
//            session.setAttribute("counter", counter);
//        } else {
            int count = (int) session.getAttribute("counter");
            count = count + 1;
            session.setAttribute("counter", count);
//        }

        String alphaNum = genAlphaNum();
        System.out.println(alphaNum);

        request.setAttribute("currString", alphaNum);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("counter") != null) {
            int counter = (int) session.getAttribute("counter");
            request.setAttribute("counter", counter);
        } else {
            int counter = 0;
            session.setAttribute("counter", counter);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
