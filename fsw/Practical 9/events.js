const EventEmitter = require("events");

class MyEmitter extends EventEmitter {}

const myEmitter = new MyEmitter();

myEmitter.on("dataReceived", () => {
  console.log("Data received successfully!");
});

// Emit the event
myEmitter.emit("dataReceived");
