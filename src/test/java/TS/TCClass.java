package TS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TCClass {

    public static void main(String args[]) throws InterruptedException, IOException {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://thedemosite.co.uk/login.php");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        // Load the properties File
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
        obj.load(objfile);

        // Nagigate to link Mobile Testing and Back
        driver.findElement(By.xpath(obj.getProperty("LoginTab"))).click();

        Thread.sleep(2000);
        // Enter Data into Form
        driver.findElement(By.name(obj.getProperty("EmailTextBox"))).sendKeys("test@gmail.com");
        driver.findElement(By.name(obj.getProperty("PasswordTextBox"))).sendKeys("testdata");
        driver.findElement(By.name(obj.getProperty("LoginButton"))).click();

        driver.quit();
    }
}
