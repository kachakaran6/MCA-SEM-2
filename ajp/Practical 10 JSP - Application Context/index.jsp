<%@ page import="jakarta.servlet.ServletContext" %> <% ServletContext context =
request.getServletContext(); Integer activeUsers = (Integer)
context.getAttribute("activeUsers"); if (activeUsers == null) { activeUsers = 0;
} if (activeUsers > 3) { response.sendRedirect("error.jsp"); return; } %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <h2>Welcome to the Application</h2>
    <p>Active Users: <%= activeUsers%></p>
    <p><a href="logout.jsp">Logout</a></p>
  </body>
</html>
