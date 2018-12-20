package Base;

import ExtendReport.ExtentManager;
import ExtendReport.ExtentTestManager;
import ExtendReport.listner.AnnotationTransformer;
import ExtendReport.listner.TestListener;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({AnnotationTransformer.class, TestListener.class})
public class BaseTest {

    public WebDriver driver;

    public BaseTest() {
    }


    @Parameters({"selGrid","nodeURL","browserName", "url"})
    @BeforeMethod
    public void beforeSuite(@Optional("false") boolean selGrid,String nodeURL,String browserName, @Optional("http://www.google.co.in") String url, Method method) throws Exception {
        getDriver(selGrid,nodeURL,browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ExtentTestManager.startTest("" + method.getName());
        ExtentTestManager.getTest().log(LogStatus.INFO, "Open Browser and navigate to " + url, "Browser Name: " + browserName);
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }

        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
        this.driver.quit();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Closed");
    }


    public WebDriver getDriver(boolean selGrid,String nodeURL,String browserName)throws Exception{
        try {
            if(selGrid){
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName(browserName);
                capabilities.setPlatform(Platform.WIN10);
                this.driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
                this.driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
            }else if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
                this.driver=new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
                this.driver=new FirefoxDriver();
            }else if(browserName.equalsIgnoreCase("ie")){
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Driver\\MicrosoftWebDriver.exe");
                this.driver=new InternetExplorerDriver();
            }else {
                System.out.println("Kindly Provide Proper Browser Name: It's supports only chrome,firefox and IE");
            }
            return driver;
        }catch (Exception e){
            throw e;
        }
    }
}
