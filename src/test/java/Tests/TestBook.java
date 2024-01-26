package Tests;

import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBook extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        //Thread.sleep(2000);
    }

    @Test(priority = 10)
    public void loginUsingCookies() throws InterruptedException {
        homePage.pageSetUp();
        homePage.clickOnBookApp();
        bookStore.clickOnlogin();
        //Thread.sleep(2000);
        logIn.addCookie();
        logIn.addCookie2();
        logIn.addCookie3();
        logIn.addCookie4();
        driver.navigate().refresh();
        //Verify that the user is logged in
        //locate the logout button (make sure that it's present)
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn-primary")).isDisplayed());
        // check the logged in URL
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        Thread.sleep(1000);

        loggedIn.scrollDown();
        loggedIn.clickOnBookApp();
        // Verify that we are on the Book Store page
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");

        bookStoreAfterLogIn.clickOnBook1();
        Thread.sleep(1000);

        book1.scrollDown();
        book1.clickToAddBook();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e){

        }

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        book2.clickToAdd2Book();
        book2.scrollDown();
        book2.clickToAddSecondBook();
        Thread.sleep(2000);

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e){

        }
        driver.navigate().refresh();
        driver.navigate().back();

        Thread.sleep(2000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        //Verify that the user is logged out
        //Login button is displayed
        Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed());
        // Verify the matching username
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");

    }


    @Test(priority = 20)
    public void logInAfterDeletingCookies() throws InterruptedException {
        String username = excelReader.getStringData("Sheet1", 0, 0);
        String password = excelReader.getStringData("Sheet1", 1, 0);
        bookStore.clickOnlogin();
        loginAfterDeletedCookies.enterUsername(username);
        loginAfterDeletedCookies.enterPassword(password);
        Thread.sleep(3000);
        loginAfterDeletedCookies.clickOnLogin();
        // Verify that the user is logged in after entering the username and password
        // Verify the matching username
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
        // Verify that the logout button is present
        Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());

    }

    @Test (priority = 30)
    public void checkIfTheBookIsAdded() throws InterruptedException {
        bookStoreAfterLogIn.clickOnBook1();
        book1.scrollDown();
        book1.clickToAddBook();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        // Verify that the book is already added by checking the text on the popup message
        Assert.assertEquals(alert.getText(), "Book already present in the your collection!");
        try {
            alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e){

        }
        driver.navigate().refresh();
        driver.navigate().back();

        book2.clickToAdd2Book();
        book2.scrollDown();
        book2.clickToAddSecondBook();
        Thread.sleep(2000);
        Alert alert1 = driver.switchTo().alert();
        //Verify that the second book is added also by checking the popup message
        Assert.assertEquals(alert1.getText(), "Book already present in the your collection!");
        try {
            alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (Exception e){

        }



    }

}
