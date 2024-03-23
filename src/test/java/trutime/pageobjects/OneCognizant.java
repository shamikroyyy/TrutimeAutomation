package trutime.pageobjects;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trutime.baseclass.BaseClass;

import java.util.List;
import java.util.Set;

public class OneCognizant extends BaseClass {

    @FindBy(xpath = "//a[contains(@href,'GlobalAppId=926')]")
    WebElement oneCognizantURL;

    @FindBy(xpath = "//input[@id=\"oneC_searchAutoComplete\"]")
    WebElement searchBar;

    @FindBy(xpath = "//div[contains(@aria-label,'TruTime' ) and @class='appsSearchResult']")
    WebElement truTimeIcon;

    @FindBy(xpath ="//div[@class='weekContainer']/div/div[contains(@class,'dayHeadr')]")
    WebElement weekList;

    @FindBy(xpath = "//div[contains(@ng-if,'item.Date==activeDate')]")
    WebElement currentActiveDate;

    @FindBy(xpath ="//div[@class='ui-datepicker-title']/span[1]")
    WebElement currentActiveMonth;

    @FindBy(xpath ="//div[@class='ui-datepicker-title']/span[2]")
    WebElement currentActiveYear;

    @FindBy(xpath = "//div[@class='topupavailablefrom']//span")
    WebElement topUpAvailableDate;

    @FindBy(xpath = "//div[@id='legendListID']//ul/li")
    List<WebElement> legends;

    public OneCognizant(WebDriver driver)
    {
        PageFactory.initElements(this.driver, this);
    }
    public Set<String> launchOneCognizant()
    {
        System.out.println("Parent Window: "+BeCognizant.mainWindowId);
        try
        {
            Thread.sleep(10000);
            if(oneCognizantURL.isDisplayed())
            {
                oneCognizantURL.click();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return driver.getWindowHandles();
    }

    public boolean populateSearchBar() {
        Set<String> windowId = driver.getWindowHandles();

        for (String wid : windowId) {
            if (!(wid.equals(BeCognizant.mainWindowId))) {
                driver.switchTo().window(wid);
            }
        }

        try
        {
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[@class='searchTopBar']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oneC_searchAutoComplete']")));
            searchBar.click();
            searchBar.sendKeys("Trutime");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'TruTime' ) and @class='appsSearchResult']")));
            truTimeIcon.click();
            driver.switchTo().frame("appFrame");
            return true ;
        }
        catch(Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public List<WebElement> weekValidation()
    {
        List<WebElement> currentWeek = driver.findElements(By.xpath("//div[@class='weekContainer']/div/div[contains(@class,'dayHeadr')]"));

        return currentWeek;
    }

    public String currentDateValidation()
    {
        String currentDate = currentActiveDate.getText();
        return currentDate;
    }
    public String currentYear()
    {

        return currentActiveMonth.getText();
    }

    public String currentMonth()
    {
        return currentActiveYear.getText();
    }

    public String topUpsAvailableDate()
    {
        return topUpAvailableDate.getText();
    }

    public List<WebElement> validateLegends(){
        return legends;
    }
}
