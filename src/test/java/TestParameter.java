import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {

    @Parameters({"username", "password", "address"})
    @Test
    public void testMe(String username, String password, String address) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(address);
    }
}
