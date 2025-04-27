package ga.test;
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Username");
        String un = in.next();
        System.out.println("Enter Password");
        String pw = in.next();
        try {
//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "root", "");
            String query = "SELECT * FROM login WHERE user_name = ? AND pass = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, un);
            stmt.setString(2, pw);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getRow()>0) {
                System.out.println("Login Successful ! "+rs.getString("user_name"));
            }
            else
            {
                System.out.println("Login Fail");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}