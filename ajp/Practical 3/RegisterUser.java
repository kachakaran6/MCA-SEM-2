
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        String email = request.getParameter("email");
        String phone_no = request.getParameter("phone_no");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "");
            String sql = "INSERT INTO users (name, birthdate, email, phone_no) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, birthdate);
            statement.setString(3, email);
            statement.setString(4, phone_no);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }

            // Use contextPath to handle correct redirection
            response.sendRedirect(request.getContextPath() + "/DisplayUsers");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
