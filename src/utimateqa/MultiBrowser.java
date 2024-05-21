package utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MultiBrowser {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static String browser = "Firefox";
    static WebDriver driver;

    public static void main(String[] args) {
        //1. Setup Multi browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver =new SafariDriver();
        }else {
            System.out.println("Wrong browser name");
        }

        //2. Open url
        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print the title of the page.
        System.out.println("This is the main title of the page: " + driver.getTitle());

        //4.Print the current url.
        System.out.println("This is the page source: " + driver.getCurrentUrl());

        //5.Print the page source.
        System.out.println("This is the page source: " + driver.getPageSource());

        //6.Click on ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign In")).click();;

        //7. Print the current url
        System.out.println("This is the current URL: " +driver.getCurrentUrl());

        //8. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Admin");

        //9. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("Admin@123");

        //10. Click on Login Button.
        driver.findElement(By.className("button-primary")).click();

        //11. Navigate to baseUrl.
        driver.navigate().back();

        //12. Navigate forward to Homepage.
        driver.navigate().forward();

        //13. Navigate back to baseUrl.
        driver.navigate().back();

        //14. Refresh the page.
        driver.navigate().refresh();

        //15. CLose the browser
        driver.quit();

    }
}
