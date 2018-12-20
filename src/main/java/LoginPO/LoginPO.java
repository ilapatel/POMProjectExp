package LoginPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO {
    public WebDriver driver;

    public LoginPO(WebDriver driver) {

        this.driver=driver;

        //This initElements method will create all WebElements
  /*      AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory, this);*/
        PageFactory.initElements(driver, this);
    }

    /********************** Start Locators **********************/

    @FindBy(xpath="//a[contains(.,'4. Login')]")
    WebElement loginLink;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='button']")
    public WebElement loginButton;

    @FindBy(xpath = "//b[contains(.,'**Successful Login**')]")
    public WebElement successMsg;

    /********************** End Locators **********************/

    /********************** Start Methods **********************/

    //Click on element
    public  boolean clickOnElem() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);

            wait.until(ExpectedConditions.elementToBeClickable(loginLink));

            wait.until(ExpectedConditions.elementToBeClickable(loginLink));

            loginLink.click();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //Click on element
    public  boolean clickOnElement(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            WebElement generic_WebL = webElement;
            generic_WebL.click();
            return true;

        } catch (Exception e) {
            return false;
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

    public boolean verifyFileds(WebElement fieldxpath) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.elementToBeClickable(fieldxpath));

            WebElement filds = fieldxpath;
            if (filds.isDisplayed()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    /********************** End Methods **********************/
}
