package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserCounterListener implements HttpSessionListener {

    private static final int MAX_USERS = 3; // Maximum allowed users
    private static AtomicInteger activeUsers = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int count = activeUsers.incrementAndGet();
        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeUsers", count);
        System.out.println("Session Created. Active Users: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int count = activeUsers.decrementAndGet();
        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeUsers", count);
        System.out.println("Session Destroyed. Active Users: " + count);
    }
}
