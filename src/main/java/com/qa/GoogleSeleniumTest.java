package com.qa;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\seleniumtesting\\src\\main\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }




    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void searchTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures");
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement linkToBiggerPicture = driver.findElementByLinkText("Images for funny cat");
        linkToBiggerPicture.click();
        Thread.sleep(5000);
//        WebElement element = driver.findElement(By.id("smb"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
//        actions.click();
//        actions.perform();
    }

    @Test
    public void seleniumeasyTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        WebElement inputField = driver.findElement(By.id("user-message"));
        while(!inputField.isDisplayed()){
            Thread.sleep(100);
        }
        inputField.sendKeys("message");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        Thread.sleep(1000);
        submitButton.click();
        WebElement firstNum = driver.findElementById("sum1");
        WebElement secondNum = driver.findElementById("sum2");

        firstNum.sendKeys("4");
        secondNum.sendKeys("4");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        Thread.sleep(1000);
    }



}




