package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Prop;
import utility.Utility;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base extends Prop{
    public WebDriver d;
//    Properties prop = new Properties();

    String driverPath = prop.getProperty("chrome");

    String url = prop.getProperty("url");
    public WebDriverWait  wait;

    public Base() throws IOException {
    }

    public void ChromeInit() throws IOException {
//        Prop prop = new Prop();
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window.size=1200*600");
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        d.navigate().to(url);

    }

    public WebDriverWait callWait(WebElement getJsonLocation, WebDriver d){
        wait= new WebDriverWait(d,30);
        WebElement waitForJson = wait.until(ExpectedConditions.visibilityOf(getJsonLocation));
        return wait;
    }

//    public void callWait(WebElement x,WebDriver d){
//
//    }


}
