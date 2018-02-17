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

    //variable that stores alphabet and 0-9
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    //method that will generate a 15 character alphanumeric string from alphabet variable
    public String genAlphaNum() {
        String returnStr = "";

        for (int i = 0; i < 15; i++) {
            int randomChar = ThreadLocalRandom.current().nextInt(0, alphabet.length());
            returnStr += alphabet.charAt(randomChar);
        }

        return returnStr;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting session
        HttpSession session = request.getSession();

        //take the counter variable, add it by one and set it back in session
        int count = (int) session.getAttribute("counter");
        count = count + 1;
        session.setAttribute("counter", count);

        //generate our string and a date for the string creation
        String alphaNum = genAlphaNum();
        Date currDate = new Date();

        //check if the session is null, if not, then set it to request to be displayed on index
        if (session.getAttribute("prevDate") != null) {
            Date pDate = (Date) session.getAttribute("prevDate");
            request.setAttribute("prevDate", pDate);
        }

        //afterwards, set prevDate to to the date when current string was created in session
        session.setAttribute("prevDate", currDate);

        //lastly, show created string to index
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
