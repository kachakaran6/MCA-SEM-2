const { Builder, By, Key, until } = require("selenium-webdriver");

(async function example() {
  let driver = await new Builder().forBrowser("firefox").build();

  try {
    await driver.get("http://www.google.com");
    await driver.findElement(By.name("q")).sendKeys("Selenium", Key.RETURN);
    await driver.wait(until.titleContains("Selenium"), 1000);
    const title = await driver.getTitle();
    console.log("Page title is:", title);
  } finally {
    await driver.quit();
  }
})();
