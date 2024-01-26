package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BaseTest {
    WebDriver driver;
    WebElement bookApp;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getBookApp() {
        return driver.findElements(By.cssSelector(".card.mt-4.top-card"));
    }
    public void pageSetUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }
    public void clickOnBookApp(){
        for (int i=0; i<getBookApp().size(); i++){
            if (getBookApp().get(i).getText().equalsIgnoreCase("book store application")) {
                getBookApp().get(i).click();
            }
        }
    }

}


