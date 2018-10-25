package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before; 
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        System.out.println("Opening the browser : Firefox");

        /*System.setProperty("webdriver.firefox.marionette", "D:\\Libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/


        //Chrome driver
        //System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
       // base.Driver = new ChromeDriver();
        
        ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("/var/jenkins_home/tools/chromedriver/chromedriver"))
                    .usingAnyFreePort()
                    .build();
            service.start();
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            base.Driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
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
