package Pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LogIn {
    WebDriver driver;
    Cookie kuki;
    Cookie kuki2;
    Cookie kuki3;
    Cookie kuki4;

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public Cookie getKuki() {
        return new Cookie("userName", "golmanbrani%C4%87");
    }
    public void addCookie(){
        driver.manage().addCookie(getKuki());
    }

    public Cookie getKuki2() {
        return new Cookie("userID", "f319ed0c-8185-4370-8295-3fb09fc8fe34");
    }
    public void addCookie2(){
        driver.manage().addCookie(getKuki2());
    }

    public Cookie getKuki3() {
        return new Cookie("expires", "2024-01-30T08%3A01%3A00.628Z");
    }
    public void addCookie3(){
        driver.manage().addCookie(getKuki3());
    }

    public Cookie getKuki4() {
        return new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImdvbG1hbmJyYW5pxIciLCJwYXNzd29yZCI6IkFhMTIzNDU2NzhAIiwiaWF0IjoxNzA2MTAzODUzfQ.tHZKP_RIbOcxXUf45UVBSZPnsR0ssnWOktt8N1Flej4");
    }
    public void addCookie4(){
        driver.manage().addCookie(getKuki4());
    }
}
