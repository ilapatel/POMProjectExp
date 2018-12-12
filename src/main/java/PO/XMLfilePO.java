package PO;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XMLfilePO {

    public WebDriver driver;
    public Document document;
    public Properties obj;

    public XMLfilePO(WebDriver driver) {
        this.driver=driver;
    }

    public boolean xmlFileRead(String xmlfilename) throws IOException, InterruptedException, DocumentException {
        try {
            Thread.sleep(2000);

            // Reading XML File
            File inputFile = new File(System.getProperty("user.dir") +"\\"+xmlfilename+".xml");
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(inputFile);

            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean propertiesFileRead(String propertiesfilename) throws IOException, InterruptedException {
        try {
            Thread.sleep(2000);

            // Load the properties File
            obj = new Properties();
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\"+propertiesfilename+".properties");
            obj.load(objfile);

            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean clickOnLoginTab() throws IOException, InterruptedException, DocumentException {
        try{
            String filename="data";
            xmlFileRead(filename);

            String loginTab = document.selectSingleNode("//menu/logintab").getText();

            driver.findElement(By.xpath(loginTab)).click();

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean enterUsername() throws IOException, InterruptedException, DocumentException {
        try{
            String filename="credential";
            propertiesFileRead(filename);

            String username = obj.getProperty("username");

            String filename2="data";
            xmlFileRead(filename2);

            String email = document.selectSingleNode("//menu/email").getText();

            // Enter email
            WebElement emailEl = driver.findElement(By.name(email));
            emailEl.sendKeys(username);

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean enterPassword() throws IOException, InterruptedException, DocumentException {
        try{
            String filename="credential";
            propertiesFileRead(filename);

            String passwordtxt = obj.getProperty("password");

            String filename2="data";
            xmlFileRead(filename2);

            String password = document.selectSingleNode("//menu/password").getText();

            WebElement passwordEl = driver.findElement(By.name(password));
            passwordEl.sendKeys(passwordtxt);

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean clickOnSubmitButton() throws IOException, InterruptedException, DocumentException {
        try{
            String filename="data";
            xmlFileRead(filename);

            String loginBtn = document.selectSingleNode("//menu/loginbtn").getText();
            driver.findElement(By.name(loginBtn)).click();

            return true;

        }catch (Exception e){
            throw e;
        }
    }
}
