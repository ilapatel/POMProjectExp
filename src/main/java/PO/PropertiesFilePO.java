package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFilePO {

    public WebDriver driver;
    public Properties obj;

    public PropertiesFilePO(WebDriver driver) {
        this.driver=driver;
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

    public boolean clickOnLoginTab() throws IOException, InterruptedException {
        try{
            String filename="data";
            propertiesFileRead(filename);

            driver.findElement(By.xpath(obj.getProperty("LoginTab"))).click();

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean enterUsername() throws IOException, InterruptedException {
        try{
            String filename="credential";
            propertiesFileRead(filename);

            String username = obj.getProperty("username");

            String filename2="data";
            propertiesFileRead(filename2);

            // Enter email
            WebElement emailEl = driver.findElement(By.name(obj.getProperty("EmailTextBox")));
            emailEl.sendKeys(username);

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean enterPassword() throws IOException, InterruptedException {
        try{
            String filename="credential";
            propertiesFileRead(filename);

            String password = obj.getProperty("password");

            String filename2="data";
            propertiesFileRead(filename2);

            WebElement passwordEl = driver.findElement(By.name(obj.getProperty("PasswordTextBox")));
            passwordEl.sendKeys(password);

            return true;

        }catch (Exception e){
            throw e;
        }
    }

    public boolean clickOnSubmitButton() throws IOException, InterruptedException {
        try{
            String filename="data";
            propertiesFileRead(filename);

            driver.findElement(By.name(obj.getProperty("LoginButton"))).click();

            return true;

        }catch (Exception e){
            throw e;
        }
    }
}
