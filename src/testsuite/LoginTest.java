package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 * Created by Sandip Patel
 */

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    // Individual open and close
    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }
    // 1. userShouldLoginSuccessfullyWithValidCredentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //  Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // * Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the text “Secure Area”
        String expectedText = "";
        String actualText = driver.findElement(By.xpath("//i[@class='icon-lock']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }
    // 2. verifyTheUsernameErrorMessage
    @Test
    public void verifyTheUsernameErrorMessage(){
       // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // * Verify the error message “Your username is invalid!”
        String expectedErrorMessage = "Your username is invalid!\n×";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }
    // 3. verifyThePasswordErrorMessage
    @Test
    public void verifyThePasswordErrorMessage(){
        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the error message “Your password is invalid!”
        String expectedErrorMessage = "Your password is invalid!\n×";
        String actualErrorMessage = driver.findElement(By.id("flash-messages")).getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);






    }

    // Individual open and close
   // @After
   // public void tearDown(){
       // closeBrowser();
    }


