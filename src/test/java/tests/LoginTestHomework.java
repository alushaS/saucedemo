package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class LoginTestHomework {

        @Test
        public void checkProductInCart(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
            driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//*[@id='login-button']")).click();
            String productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
            String expectedProductName = "Sauce Labs Fleece Jacket";
            driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            String expectedProductPrice = "$49.99";
            String productPrice = driver.findElement(By.className("inventory_item_price")).getText();
            Assert.assertEquals(productName,expectedProductName);
            Assert.assertEquals(productPrice,expectedProductPrice);
            driver.quit();
        }
    }
