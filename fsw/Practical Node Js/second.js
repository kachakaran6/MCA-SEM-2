console.log("Welcome to my Node.js console app!");

process.stdout.write("Enter your name: ");
process.stdin.on("data", (data) => {
  const name = data.toString().trim();
  console.log(`Hello, ${name}!`);
  process.exit();
});
