function decodeString(s) {
  let stack = [];
  for (let char of s) {
    if (char !== "]") {
      stack.push(char);
    } else {
      let decodedString = "";
      while (stack[stack.length - 1] !== "[") {
        decodedString = stack.pop() + decodedString;
      }
      stack.pop(); // remove '['
      let k = "";
      while (stack.length && !isNaN(stack[stack.length - 1])) {
        k = stack.pop() + k;
      }
      stack.push(decodedString.repeat(parseInt(k)));
    }
  }
  return stack.join("");
}

// Example
console.log(decodeString("3[a2[b]]")); // Output: abbabbabb
