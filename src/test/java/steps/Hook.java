package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Karthik on 10/17/2016.
 */
public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : Chrome");

        /*System.setProperty("webdriver.firefox.marionette", "D:\\Libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/


        //Chrome driver
        //System.setProperty("webdriver.chrome.driver", "D:\\Libs\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //base.Driver = new ChromeDriver();
         
        //WebDriver driver = new RemoteWebDriver(new URL("http://dbg-trp-jenkins.swg-devops.com:4444/wd/hub"), capability);
        base.Driver = new RemoteWebDriver(new URL("http://dbg-trp-jenkins.swg-devops.com:4444/wd/hub"), capability);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
    }

}
