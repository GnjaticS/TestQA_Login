package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreAfterLogIn {
    WebDriver driver;
    WebElement book1;

    public BookStoreAfterLogIn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBook1() {
        return driver.findElement(By.linkText("Git Pocket Guide"));
    }
    public void clickOnBook1 (){
        getBook1().click();
    }

}
