package TS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class XmlFileEx {

    public static void main(String args[]) throws InterruptedException, IOException, DocumentException {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://thedemosite.co.uk/login.php");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Reading XML File
        File inputFile = new File(System.getProperty("user.dir") +"\\data.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputFile);

        String loginTab = document.selectSingleNode("//menu/logintab").getText();

        driver.findElement(By.xpath(loginTab)).click();

        String email = document.selectSingleNode("//menu/email").getText();
        String password = document.selectSingleNode("//menu/password").getText();
        String loginBtn = document.selectSingleNode("//menu/loginbtn").getText();

        Thread.sleep(2000);
        // Enter Data into Form
        driver.findElement(By.name(email)).sendKeys("test@gmail.com");
        driver.findElement(By.name(password)).sendKeys("testdata");
        driver.findElement(By.name(loginBtn)).click();

        driver.quit();
    }
}
