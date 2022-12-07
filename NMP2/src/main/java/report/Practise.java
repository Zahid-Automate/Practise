package report;


import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class Practise {

    //program to print the factorial of a number
    public static void main(String[] args) {
        int n = 5;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("The factorial of a number is " + fact);
    }
    @Test
    public void test1() {
        System.out.println("test1");
    }
   
    @Test
    public void openHyperLinkInNewTabUsingActions() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C://Users//mzahi//eclipse-workspace//SinceraSeleniumTest//chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.get("https://google.com");

        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("Google Play mobile games now on PC"))).contextClick().sendKeys(Keys.ENTER).build().perform();
        
         ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(0));
        
        Thread.sleep(5000);
        driver.quit();
        // Does not open the tab right next to the parent window
    }
    
    @Test
    public void openHyperlinkUsingKeys() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C://Users//mzahi//eclipse-workspace//SinceraSeleniumTest//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Title of first page "+driver.getTitle());
        // Store the keys CTRL+ENTER in a string
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
        // open the link in new tab, Keys.Chord string passed to sendKeys
        driver.findElement(By.linkText("Google Play mobile games now on PC")).sendKeys(clicklnk);
        // to switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Title of Second page "+driver.getTitle());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
        driver.quit();
    }
    
    @Test
    public void openHyperlinkInNewTabUsingJS() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mzahi/eclipse-workspace/SinceraSeleniumTest/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.get("https://google.com");
        WebElement link = driver.findElement(By.linkText("Google Play mobile games now on PC"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return arguments[0].target='_blank'";
        Object result = js.executeScript(script, link);
        link.click();
        Thread.sleep(5000);
        driver.quit();
    }
    
    @Test
    public void grammarly() throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:/Users//mzahi/eclipse-workspace/SinceraSeleniumTest/chromedriver.exe");
        //WebDriver driver  = new ChromeDriver();
        
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/path/to/extension.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver();
        
        options.addExtensions(new File("C://Users//mzahi//Downloads//Grammarly_ Grammar Checker and Writing App.crx"));
        //DesiredCapabilities desiredCapabalities = DesiredCapabilities.chrome();
        //desiredCapabalities.setCapability(ChromeOptions.CAPABILITY, options);
        
    

        driver = new ChromeDriver(options);
        driver.get("https://www.memonotepad.com/");
        driver.findElement(By.id("notes")).sendKeys("i received a lot of qquestions about");
        
       
        
        Thread.sleep(1000);
        driver.quit();
    }
    }
 
