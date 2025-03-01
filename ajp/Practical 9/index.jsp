<%@ taglib prefix="c" uri="/WEB-INF/tlds/sortNumbers.tld" %>
<html>
  <head>
    <title>Sort Numbers Custom Tag</title>
  </head>
  <body>
    <h2>Enter 10 Numbers (comma-separated)</h2>
    <form method="post">
      <input type="text" name="numbers" required />
      <select name="order">
        <option value="asc">Ascending</option>
        <option value="desc">Descending</option>
      </select>
      <input type="submit" value="Sort" />
    </form>
    <% String numbers = request.getParameter("numbers"); String order =
    request.getParameter("order"); if (numbers != null && !numbers.isEmpty()) {
    %>
    <h3>Sorted Numbers:</h3>
    <c:sortNumbers numbers="<%= numbers%>" order="<%= order%>" />
    <% }%>
  </body>
</html>
