package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Book1 {
    WebDriver driver;
    JavascriptExecutor js2;
    WebElement addBook;

    public Book1(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptExecutor getJs2() {
        return (JavascriptExecutor) driver;
    }

    public void scrollDown(){
        getJs2().executeScript("window.scrollBy(0, 300);");
    }

    public List<WebElement> getAddBook() {
        return driver.findElements(By.cssSelector(".text-right.fullButton"));
    }
    public void clickToAddBook (){
        for (int i=0; i<getAddBook().size(); i++){
            if(getAddBook().get(i).getText().equalsIgnoreCase("add to your collection")){
                getAddBook().get(i).click();
            }
        }
    }
    /*List<WebElement> addBook = driver.findElements(By.cssSelector(".text-right.fullButton"));
        for (int i=0; i< addBook.size(); i++){
            if(addBook.get(i).getText().equalsIgnoreCase("add to your collection")){
                addBook.get(i).click();
            }
        }

     */
}
