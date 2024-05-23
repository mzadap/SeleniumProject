import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SkippingTestCase extends Throwable {

    public SkippingTestCase(String skipping_exception) {
    }

    @DataProvider(name = "TestData")
    public Object[][] dataTest(ITestContext context) {
        return new Object[][] {
                {"data1"},
                {"data2"},
                {"data3"},
        };
    }

    @Test(dataProvider = "TestData")
    public void test(String testData) throws SkippingTestCase {
        System.out.println("Test Data " + testData);

        if ("data2".equals(testData)) {
            System.out.println("skiiping test for data2");
            throw new SkippingTestCase("skipping exception");
        }
    }

    @Test(invocationCount = 20)
    public void testMe(ITestContext context) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("hello " + context.getPassedTests());
    }
}
