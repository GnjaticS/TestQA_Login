package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Book2 {
    WebDriver driver;
    WebElement addBook2;
    JavascriptExecutor js3;
    WebElement add2book;

    public Book2(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddBook2() {
        return driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
    }
    public void clickToAdd2Book(){
        getAddBook2().click();
    }

    public JavascriptExecutor getJs3() {
        return (JavascriptExecutor) driver;
    }
    public void scrollDown(){
        getJs3().executeScript("window.scrollBy(0, 300);");
    }

    public List<WebElement> getAdd2book() {
        return driver.findElements(By.cssSelector(".text-right.fullButton"));
    }
    public void clickToAddSecondBook(){
        for (int i=0; i<getAdd2book().size(); i++) {
            if(getAdd2book().get(i).getText().equalsIgnoreCase("add to your collection")){
                getAdd2book().get(i).click();
            }
        }
    }
    /*
   List<WebElement> addBooks = driver.findElements(By.cssSelector(".text-right.fullButton"));
        for (int i=0; i< addBooks.size(); i++){
            if(addBooks.get(i).getText().equalsIgnoreCase("add to your collection")){
                addBooks.get(i).click();
            }
        }
     */
}
