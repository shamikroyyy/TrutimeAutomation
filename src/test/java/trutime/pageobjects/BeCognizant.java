package trutime.pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import trutime.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trutime.utility.Utility;
// Page Object :
// >> consists of :
// >> 1: Element Locator
// >> 2: Actions to be performed on the locators

public class BeCognizant extends BaseClass {
    public static String mainWindowId;

    @FindBy(xpath = "//div[text()= \"Roy, Shamik (Contractor)\"]")
    WebElement name;

    @FindBy(xpath = "//button[contains(@title,'Account manager for Roy, Shamik (Contractor)')]")
    WebElement headerPicture;

    @FindBy(xpath = "//div[contains(@id,'currentAccount_primary')]")
    WebElement UserName;

    @FindBy(xpath = "//div[contains(@id,'currentAccount_secondary')]")
    WebElement Email ;

    public BeCognizant(WebDriver driver)
    {
        PageFactory.initElements(this.driver, this);
    }

    public boolean launchBeCognizant()
    {
        try {
            driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
            mainWindowId = driver.getWindowHandle();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public String[] validateDetailsPO()
    {
        String userDetails[] =  new String[2];

        while(true)
        {
            try
            {
                headerPicture.click();
                Utility uObj = new Utility();

                userDetails[0] = UserName.getText();
                userDetails[1] = Email.getText();
                uObj.getScreenshot(driver,"UserDetails");
                break ;
            }
            catch(Exception e)
            {}
        }
        return userDetails;
    }
}
