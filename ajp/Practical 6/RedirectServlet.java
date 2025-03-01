import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.regex.*;

public class RedirectServlet extends HttpServlet {

    // Handle both GET and POST requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Same logic as POST method for handling GET requests
        handleRedirect(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle the POST method (which will be used when form is submitted)
        handleRedirect(request, response);
    }

    // Common logic to handle redirect for both GET and POST requests
    private void handleRedirect(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the URL entered by the user
        String location = request.getParameter("location");

        // Validate if the URL is empty or not
        if (location == null || location.isEmpty()) {
            response.getWriter().println("URL cannot be empty!");
            return;
        }

        // Basic URL validation using regex (ensure it starts with http:// or https://)
        String regex = "^(https?|ftp)://.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(location);

        if (matcher.matches()) {
            // If the URL is valid, perform the redirection
            response.sendRedirect(location);
        } else {
            // If the URL is invalid, show an error message
            response.getWriter().println("Invalid URL! Please enter a valid URL starting with http:// or https://");
        }
    }
}
