package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public BookStore bookStore;
    public LogIn logIn;
    public LoggedIn loggedIn;
    public BookStoreAfterLogIn bookStoreAfterLogIn;
    public Book1 book1;
    public Book2 book2;
    public LoginAfterDeletedCookies loginAfterDeletedCookies;
    public ExcelReader excelReader;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);

        homePage = new HomePage(driver);
        bookStore = new BookStore(driver);
        logIn = new LogIn(driver);
        loggedIn = new LoggedIn(driver);
        bookStoreAfterLogIn = new BookStoreAfterLogIn(driver);
        book1 = new Book1(driver);
        book2 = new Book2(driver);
        loginAfterDeletedCookies = new LoginAfterDeletedCookies(driver);
        excelReader = new ExcelReader("/Users/stefang/Desktop/loginTestQA.xlsx");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }



}

