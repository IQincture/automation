
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import organized.chaos.webdriver.ActiveNodeDeterminer;
 
import java.net.URL;
 
public class SampleTest1 {
    private static final String IP = "192.168.5.36";
    private static final int PORT = 4444;
 
    private RemoteWebDriver driver;
    private ActiveNodeDeterminer determiner = new ActiveNodeDeterminer(IP, PORT);
 
    @BeforeClass
    public void setup() throws Exception {
        URL url = new URL("http://" + IP + ":" + PORT + "/wd/hub");
        driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
    }
 
    @Test
    public void test() {
        Reporter.log("Node : " + determiner.getNodeInfoForSession(driver.getSessionId()), true);
        
        System.out.println(determiner.getNodeInfoForSession(driver.getSessionId()));
    }
 
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
