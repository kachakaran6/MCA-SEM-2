const querystring = require("querystring");

const query = "name=JohnDoe&age=30&city=NewYork";
const parsed = querystring.parse(query);

console.log(parsed);
// Output: { name: 'JohnDoe', age: '30', city: 'NewYork' }
