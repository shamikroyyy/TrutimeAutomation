package trutime.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import trutime.pageobjects.OneCognizant;
import trutime.baseclass.BaseClass;
import trutime.utility.Utility;

import java.util.List;
import java.util.Set;

public class OneCognizantTests extends BaseClass{
    private OneCognizant oneCognizantObj;

    @BeforeClass
    void createOneCognizant()
    {
        oneCognizantObj = new OneCognizant(super.driver);
    }

    @Test(priority = 0 )
    void launchOneCognizantT()
    {
        Set<String> windowHandles = oneCognizantObj.launchOneCognizant() ;
        if(windowHandles.size() == 1 )
        {
            Assert.assertFalse(true);
        }
        else
        {
            Assert.assertTrue(true);
        }
    }

    @Test(priority = 1)
    void populateSearchBarT()
    {
        Assert.assertEquals(oneCognizantObj.populateSearchBar(),true);
    }

    @Test(priority = 2)
    void weekValidationT()
    {
        List<WebElement> weekList = oneCognizantObj.weekValidation();
        Utility uObj = new Utility();
        List<String> systemWeek = uObj.systemWeek();
        for(int i = 0 ; i < 7 ; i++ )
        {
            String str = weekList.get(i).getText();
            Assert.assertEquals(systemWeek.get(i),str);
        }
    }

    @Test(priority = 4 )
    void currentDateValidationT()
    {
        Utility uObj = new Utility();
        String systemDate = uObj.getCurrentDate();
        String currentDate = oneCognizantObj.currentDateValidation();

        Assert.assertEquals(systemDate,currentDate);
    }

    @Test(priority = 5)
    void currentMonthYearValidationT()
    {
        Utility uObj = new Utility();
        String systemMonth = uObj.getCurrentMonth();
        String systemYear = uObj.getCurrentYear();

        String currentMonth = oneCognizantObj.currentMonth();
        String currentYear = oneCognizantObj.currentYear();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(systemMonth,currentMonth);
        sa.assertEquals(systemYear,currentYear);
    }

    @Test(priority = 6)
    void topUpsAvailableDateT()
    {
        Utility uobj = new Utility();
        String systemBackDate15 = uobj.getBackDated15();
        String topupBackDate15 = oneCognizantObj.topUpsAvailableDate();

        Assert.assertEquals(systemBackDate15,topupBackDate15);
    }

    @Test(priority = 7)
    void validateLegendsT()
    {
        SoftAssert sa = new SoftAssert();
        for(WebElement legend : oneCognizantObj.validateLegends()){

            sa.assertTrue(legend.isDisplayed());
        }
    }
}
