import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropDown {

    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement countryDropDown = driver.findElement(By.id("country"));
        Select select = new Select(countryDropDown);
        List<WebElement> list = select.getOptions();
        System.out.println(list);
        List org = new ArrayList();
        for (WebElement value : list) {
            org.add(value.getText());
        }
        System.out.println("org " + org);
        List temp = new ArrayList(org);
        Collections.sort(temp);
        System.out.println(temp);

        Assert.assertTrue(temp.equals(org));

        driver.close();
    }

    @Test(dependsOnMethods = "test")
    public void test1() {
        System.out.println("hello");
    }

}
