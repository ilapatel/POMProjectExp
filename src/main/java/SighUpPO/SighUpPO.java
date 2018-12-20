package SighUpPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SighUpPO {

    public WebDriver driver;

    public SighUpPO(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    /********************** Start Locators **********************/

    @FindBy(xpath="//a[contains(.,'3. Add a User')]")
    public WebElement addUserLink;

    @FindBy(xpath="//input[@name='username']")
    public WebElement sighnUpUser;

    @FindBy(xpath="//input[@name='password']")
    public WebElement sighnUpPassword;

    @FindBy(xpath="//input[@type='button']")
    public WebElement saveButton;

    /********************** End Locators **********************/




    /********************** Start Methods **********************/

    //Click on element
    public  boolean clickOnElement(WebElement webElement) throws InterruptedException {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            WebElement generic_WebL = webElement;
            generic_WebL.click();
            return true;

        } catch (Exception e) {
            throw e;
        }
    }

    //Enter data
    public boolean inputText(WebElement webElement, String inputTextData){
        try{

           WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            WebElement input= webElement;

            input.click();
            input.clear();
            input.sendKeys(inputTextData);

            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    /********************** End Methods **********************/
}
