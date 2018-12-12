package TS;

import Base.BaseTest;
import ExtendReport.ExtentTestManager;
import PO.XMLfilePO;
import SighUpTS.SighUPTC;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.dom4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlFileEx extends BaseTest {

    public int flag=1;

    public XmlFileEx(){}

    public XmlFileEx(WebDriver passDriver,int flagthis){
        driver = passDriver;
        flag = flagthis;
    }

    //Created by: Ila Patel
    @Test
    public void loginPage() throws IOException, InterruptedException, DocumentException {

        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("Test-2:login Successfully");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }

        //Step 1 :  Pre-Condition : Test-1
        SighUPTC sighUPTC=new SighUPTC(driver,0);
        sighUPTC.createNewUser();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for Test-2");

        XMLfilePO xmLfilePO =new XMLfilePO(driver);

        //Step-2: Click on 'Login' Link
        Assert.assertTrue(xmLfilePO.clickOnLoginTab(), "Unable to Click on 'Login' Link");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Login' Link", "Clicked 'Login' Link");

        //Step-3: Enter Username
        Assert.assertTrue(xmLfilePO.enterUsername(), "Unable to Enter Username");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Username", "Enter Username successfully");

        //Step-4: Enter Password
        Assert.assertTrue(xmLfilePO.enterPassword(), "Unable to Enter Password");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Password", "Enter password successfully");

        //Step-5: Click on 'Test Login' button
        Assert.assertTrue(xmLfilePO.clickOnSubmitButton(), "Unable to Click on 'Test Login' button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Test Login' button", "Clicked 'Test Login' button");
    }

}
