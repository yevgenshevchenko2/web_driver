package com.epam.sum_university;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\shevchenko\\IdeaProjects\\web_driver\\src\\test\\resources\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));

        searchField.sendKeys("laptop" + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("//div[@class='sg-col-inner']//span[last()]"));

        Assert.assertTrue(searchResult.isDisplayed(), "Message");


        driver.close();
        driver.quit();
    }
    @Test
    public void githubtest()
    {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\shevchenko\\IdeaProjects\\web_driver\\src\\test\\resources\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys("yevgenshevchenko2");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("6x6z5m1c95");

        WebElement button = driver.findElement(By.name("commit"));
        button.click();

        WebElement login = driver.findElement(By.xpath("//summary[@class=\"Header-link\"]/img"));
        login.click();
        WebElement Result = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()=\"yevgenshevchenko2\"]")));


        Assert.assertTrue(Result.isDisplayed());

        driver.close();
        driver.quit();
    }
    @DataProvider(name = "Wrong credentials")
    public Object[][] wrongCredentials() {
        return new Object[][] {
                {"sdfsf", "6x6z5m1c95"},
                {"yevgenshevchenko2", "23456"},
                {"sdfsf", "23456"},
        };

    }

    @Test(dataProvider = "Wrong credentials")
    public void githubtestnegative(String l, String p)
    {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\shevchenko\\IdeaProjects\\web_driver\\src\\test\\resources\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys(l);


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(p);



        WebElement button = driver.findElement(By.name("commit"));
        button.click();

        WebElement error = driver.findElement(By.id("js-flash-container"));

// dfsfsf



        Assert.assertTrue(error.isDisplayed());

        driver.close();
        driver.quit();
    }
}
