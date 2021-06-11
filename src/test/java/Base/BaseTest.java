package Base;
// import Customer.ZipUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;

public class BaseTest {

    public static WebDriver driver;
    public static ArrayList<String> arrnomPaso = new ArrayList<String>();
    public static String estado;
    public static ExtentTest extent;
    public static ExtentReports extentReports;
    public static String[][][] matrizEvi;
    public static String[][] datosClientes;
    public static int filaM;
    public static ArrayList<String> arrPasos = new ArrayList<String>(), listaPasos, listaResultado;
    //public static ZipUtils appZip = null;
    public static Path pathReport;
    public static String[][] sheetData = null;
    public String baseURL, hub;

    public BaseTest() {
        super();
    }
    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        baseURL = "http://localhost:8082/Prueba_2020/";
        hub = "http://172.20.211.40:4444/wd/hub";
        System.setProperty("webdriver.chrome.driver", "./Prerrequisitos/driver/chromedriver"); // Para Chrome
//		String nodeURL= "http://192.168.239.133:8888/wd/hub";
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.LINUX);
        dc.setCapability("requireWindowsFocus", true);
        dc.setCapability("ignoreZoomSetting", true);
        dc.setCapability("nativeEvents", false);
//							RemoteWebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
//		options.addArguments("disable-infobars");
//		options.addArguments("--disable-extensions");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
//							options.addArguments("--headless");
        dc.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(new URL(hub), dc);
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get(baseURL);
        Thread.sleep(1000);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    public void exitTest() {
        Assert.fail("Expected exit");
    }
}