package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class LoginAfterDeletedCookies {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement login;

    public LoginAfterDeletedCookies(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("userName"));
    }
    public void enterUsername(String username){
        getUsername().sendKeys(username);
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }
    public void enterPassword (String password) throws InterruptedException {
        getPassword().sendKeys(password);
    }

    public List<WebElement> getLogin() {
        return driver.findElements(By.cssSelector(".text-right.button"));
    }
    public void clickOnLogin(){
        for(int i=0; i<getLogin().size(); i++){
            if(getLogin().get(i).getText().equalsIgnoreCase("Login")){
                getLogin().get(i).click();
            }
        }
    }
}
