import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author karan
 */
@WebServlet(urlPatterns = { "/Convert" })
public class Convert extends HttpServlet {

    String jdbcURL = "jdbc:mysql://localhost:3306/currency_converter";
    String jdbcUser = "root";
    String jdbcPassword = "";
    List<String> currencies = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
            String sql = "SELECT currency_code FROM currencies";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                currencies.add(rs.getString("currency_code"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set currencies as request attribute
        request.setAttribute("currencies", currencies);

        // Forward to the JSP page
        request.getRequestDispatcher("converter.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Map<String, Double> currencyRates = getCurrencyRates();
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency, currencyRates);

        // Database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);

            String sql = "INSERT INTO conversions (from_currency, to_currency, amount, converted_amount, conversion_rate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fromCurrency);
            stmt.setString(2, toCurrency);
            stmt.setDouble(3, amount);
            stmt.setDouble(4, convertedAmount);
            stmt.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("fromCurrency", fromCurrency);
        request.setAttribute("toCurrency", toCurrency);
        request.setAttribute("amount", amount);
        request.setAttribute("convertedAmount", convertedAmount);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private Map<String, Double> getCurrencyRates() {
        Map<String, Double> rates = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
            String sql = "SELECT currency_code, rate_per_usd FROM currencies";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rates.put(rs.getString("currency_code"), rs.getDouble("rate_per_usd"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rates;
    }

    private double convertCurrency(double amount, String from, String to, Map<String, Double> rates) {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            return amount; // If currency not found, return same amount
        }

        double fromRate = rates.get(from); // Rate per USD
        double toRate = rates.get(to); // Rate per USD

        // Convert to USD first, then to the target currency
        return (amount / fromRate) * toRate;
    }

    private double getConversionRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) {
            return 83.0;
        }
        if (from.equals("INR") && to.equals("USD")) {
            return 0.012;
        }
        if (from.equals("EUR") && to.equals("USD")) {
            return 1.08;
        }
        if (from.equals("USD") && to.equals("EUR")) {
            return 0.92;
        }
        return 1.0; // Default case (same currency)
    }

}
