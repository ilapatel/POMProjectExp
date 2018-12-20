package LoginTS;

import Base.BaseTest;
import ExtendReport.ExtentTestManager;
import LoginPO.LoginPO;
import SighUpTS.SighUPTC;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTC extends BaseTest {

    public int flag=1;

    public LoginTC() {
    }


    public LoginTC(WebDriver passDriver, int Flag) {
        driver=passDriver;
        flag=Flag;
    }


    //Created by: Ila Patel
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void loginSuccessfully() throws InterruptedException {

        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("Test-2:login Successfully");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }

        //Step 1 :  Pre-Condition : Test-1
        SighUPTC sighUPTC=new SighUPTC(driver,0);
        sighUPTC.createNewUser();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for Test-2");

        LoginPO loginPO=new LoginPO(driver);

        String userName="IlaPatel";
        String password="IlaPatel";

        //Step-2: Click on 'Login' Link
        Assert.assertTrue(loginPO.clickOnElem(), "Unable to Click on 'Login' Link");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Login' Link", "Clicked 'Login' Link");

        //Step-3: Enter Username
        Assert.assertTrue(loginPO.inputText(loginPO.username,userName), "Unable to Enter Username");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Username", "Test data :"+userName);

        //Step-4: Enter Password
        Assert.assertTrue(loginPO.inputText(loginPO.password,password), "Unable to Enter Password");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Password", "Test data :"+password);

        //Step-5: Click on 'Test Login' button
        Assert.assertTrue(loginPO.clickOnElement(loginPO.loginButton), "Unable to Click on 'Test Login' button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Test Login' button", "Clicked 'Test Login' button");
    }


    //Created by: Ila Patel
    @Test
    public void verifyLoginSuccessfullyMsg() throws InterruptedException {

        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("Test-3:Verify Login Successfully Msg display");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }

        //Step 1 :  Pre-Condition : Test-2
        LoginTC loginTC=new LoginTC(driver,0);
        loginTC.loginSuccessfully();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for Test-2");

        LoginPO loginPO=new LoginPO(driver);

        //Step-2: Verify login successfully Msg display
        Assert.assertFalse(loginPO.verifyFileds(loginPO.successMsg), "Unable to display successfully Msg");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify login successfully Msg display", "login successfully Msg is display");

    }
}
