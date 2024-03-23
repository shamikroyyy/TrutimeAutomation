package trutime.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import trutime.baseclass.BaseClass;
import trutime.pageobjects.BeCognizant;

public class BeCognizantTests extends BaseClass {
    private BeCognizant beCognizantObj;


    @BeforeClass
    void createBeCognizant()
    {
        beCognizantObj = new BeCognizant(BaseClass.driver);
    }

    @Test(priority = 0 )
    void launchBeCognizant()
    {
        Assert.assertEquals(beCognizantObj.launchBeCognizant(),true);
    }

    @Test(priority = 1)
    void validateDetails()
    {
        String userDetails[] = beCognizantObj.validateDetailsPO();
        Assert.assertEquals(userDetails[0],"Roy, Shamik (Contractor)");
        Assert.assertEquals(userDetails[1],"2318178@cognizant.com");
    }
}
