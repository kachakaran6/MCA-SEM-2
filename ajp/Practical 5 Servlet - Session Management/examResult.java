import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/examResult" })
public class examResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int m1, m2, m3, m4, m5, m6;
            float avg;
            m1 = Integer.parseInt(request.getParameter("subj1"));
            m2 = Integer.parseInt(request.getParameter("subj2"));
            m3 = Integer.parseInt(request.getParameter("subj3"));
            m4 = Integer.parseInt(request.getParameter("subj4"));
            m5 = Integer.parseInt(request.getParameter("subj5"));
            m6 = Integer.parseInt(request.getParameter("subj6"));
            avg = (float) (m1 + m2 + m3 + m4 + m5 + m6) / 6;

            char grade;
            if (avg >= 90) {
                grade = 'A';
            } else if (avg >= 70) {
                grade = 'B';
            } else if (avg >= 60) {
                grade = 'C';
            } else {

                grade = 'F';
            }

            Cookie[] c = request.getCookies();

            out.println("<br>Name :" + c[0].getValue());
            out.println("<br>Id :" + c[1].getValue());
            out.println("<br>Department :" + c[2].getValue());

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ExamResult</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exam Result :" + grade + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}