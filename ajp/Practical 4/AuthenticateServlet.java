package in.ga.backend;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Authenticate")
public class AuthenticateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAuthenticated = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "");
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            isAuthenticated = rs.next();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isAuthenticated) {
            out.println("<h1>Welcome, " + username + "!</h1>");
        } else {
            out.println("<h1>Invalid username or password!</h1>");
        }
        out.println("<h2>Request Headers:</h2>");
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            out.println(headerName + ": " + request.getHeader(headerName) + "<br>");
        });
        response.addHeader("Custom-Header", "This is gaurav and i am your header");
        out.println("<h2>Response Headers:</h2>");
        response.getHeaderNames().forEach(headerName -> {
            out.println(headerName + ": " + response.getHeader(headerName) + "<br>");
        });
        out.close();
    }
}
