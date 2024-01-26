package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoggedIn {
    WebDriver driver;
    JavascriptExecutor js;
    WebElement bookApp;

    public LoggedIn(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptExecutor getJs() {
        return (JavascriptExecutor) driver;
    }
    public void scrollDown(){
        getJs().executeScript("window.scrollBy(0, 400);");
    }

    public List<WebElement> getBookApp() {
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }
    public void clickOnBookApp(){
        for (int i=0; i<getBookApp().size(); i++){
            if (getBookApp().get(i).getText().equalsIgnoreCase("Book Store")) {
                getBookApp().get(i).click();
                break;
            }
        }
    }

}
