package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStore {

    WebDriver driver;
    WebElement login;

    public BookStore(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() {
        return login = driver.findElement(By.id("login"));
    }
    public void clickOnlogin (){
        getLogin().click();
    }
}
