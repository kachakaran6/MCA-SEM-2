<!DOCTYPE html>
<html>
  <head>
    <title>Request Redirection</title>
  </head>
  <body>
    <h2>Enter the URL to redirect to:</h2>
    <!-- Use POST method for submitting form data -->
    <form action="RedirectServlet" method="POST">
      <label for="location">URL: </label>
      <input
        type="text"
        id="location"
        name="location"
        placeholder="Enter the URL"
        required
      />
      <input type="submit" value="Go" />
    </form>
  </body>
</html>
