// const assert = require("chai").assert;

// function add(a, b) {
//   return a + b;
// }

// describe("Addition function", function () {
//   it("should return 5 when 2 and 3 are added", function () {
//     assert.equal(add(2, 3), 5);
//   });

//   it("should return 0 when -1 and 1 are added", function () {
//     assert.equal(add(-1, 1), 0);
//   });
// });

const assert = require("chai").assert;

function add(a, b) {
  return a + b;
}

describe("Addition function", function () {
  it("should return 5 when 2 and 3 are added", function () {
    assert.equal(add(2, 3), 5);
  });

  it("should return 0 when -1 and 1 are added", function () {
    assert.equal(add(-1, 1), 0);
  });
});
