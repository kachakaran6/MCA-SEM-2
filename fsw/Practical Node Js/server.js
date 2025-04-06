var http = require("http");

var server = http.createServer(function (req, res) {
  res.writeHead(200, { "Content-Type": "text/plain" });
  res.write("Hello, this is a simple Node.js web server!");
  res.end();
});

server.listen(3000, function () {
  console.log("Server is running at http://localhost:3000");
});
