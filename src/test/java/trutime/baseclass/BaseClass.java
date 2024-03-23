package trutime.baseclass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait ;

    @Parameters("browser")
    @BeforeTest
    public void createDriver(String browser)
    {
        if(browser.equals("chrome"))
        {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        }
        else if(browser.equals("edge"))
        {
            driver = new EdgeDriver();
            wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        }
        else
        {
            System.out.println("Invalid Browser name provided");
            System.exit(0);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
    }

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }
   public String captureScreen(String tname) throws IOException {
	   
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}

}

