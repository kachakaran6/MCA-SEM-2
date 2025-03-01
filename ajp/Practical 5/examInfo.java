/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/examInfo" })
public class examInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nm, id, department;
        try (PrintWriter out = response.getWriter()) {

            nm = request.getParameter("name");
            id = request.getParameter("id");
            department = request.getParameter("department");
            Cookie c1, c2, c3;
            c1 = new Cookie("nm", nm);

            c2 = new Cookie("id", id);
            c3 = new Cookie("dept", department);

            response.addCookie(c1);
            response.addCookie(c2);
            response.addCookie(c3);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ExamInfo</title>");
            out.println("</head>");
            out.println("<body><form action=\"examResult\">");
            out.println("<h1>Student : " + nm + "</h1><br><hr>");
            out.println("<center><b>Enter ,marks for six subjects [out of 100]</b></center><br>");
            out.println("Enter marks for subject1 <input type=\"text\" name=\"subj1\"><br><br>");
            out.println("Enter marks for subject2 <input type=\"text\" name=\"subj2\"><br><br>");
            out.println("Enter marks for subject3 <input type=\"text\" name=\"subj3\" ><br><br>");
            out.println("Enter marks for subject4 <input type=\"text\" name=\"subj4\" ><br><br>");
            out.println("Enter marks for subject5 <input type=\"text\" name=\"subj5\" ><br><br>");
            out.println("Enter marks for subject6 <input type=\"text\" name=\"subj6\" ><br><br>");
            out.println("<input type=\"Submit\" value=\"Generate Result\">");
            out.println("</form></body>");
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