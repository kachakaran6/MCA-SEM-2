
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DisplayUsers")
public class DisplayUsers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "");
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            out.println("<h1>Registered Users</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Birthdate</th><th>Email</th><th>Phone Number</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthdate = resultSet.getDate("birthdate");
                String email = resultSet.getString("email");
                String phone_no = resultSet.getString("phone_no");
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + birthdate + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + phone_no + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
