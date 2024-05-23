import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class AutomationPractice {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

    }

    @Test
    public void automationPractice() {

        WebElement webElement  = driver.findElement(By.xpath("//input[contains(@id, 'shub')]"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys("mzadap@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='element-companyId']//input[@placeholder='Enter your company']")).sendKeys("abc");
        driver.findElement(By.xpath("//div[@class='element-companyId']//input[@placeholder='Enter your mobile number']")).sendKeys("1234");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        WebElement fristName = driver.findElement(By.xpath("//div[@class = 'elementor-widget-container']//input[@placeholder='First Enter name']"));
        //webDriverWait.until(ExpectedConditions.visibilityOf(fristName));
        //fristName.sendKeys("Nach");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value', ' + abc +')", fristName);
        ////div[@class = 'elementor-widget-container']//input[@placeholder='First Enter name']

        WebElement lastName = driver.findElement(By.xpath("//div[@class = 'elementor-widget-container']//input[@placeholder='Enter Last name']"));
        if (lastName.isEnabled()) {
            lastName.sendKeys("hello");
        } else {
            executor.executeScript("arguments[0].removeAttribute('disabled')", lastName);
            lastName.sendKeys("hello");
        }

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='cars']"));
        Select select = new Select(dropDown);
        List<WebElement> values = select.getOptions();
        System.out.println(values);
        for (WebElement val : values) {
            if (val.getText().equals("Audi")) {
                val.click();
                //select.selectByVisibleText("Audi");
            }
        }
        WebElement buttons = driver.findElement(By.xpath("//button[text()='Checkout here']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttons).perform();
        driver.findElement(By.xpath("//a[contains(text(),'SHub Youtube Channel')]")).click();
        String parent = driver.getWindowHandle();
        Set<String> allWindows= driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parent.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getCurrentUrl());
                driver.close();
                System.out.println("closing child window");
            }
        }
        driver.switchTo().window(parent);
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("31-07-1996");
        List<WebElement> tables = driver.findElements(By.xpath("//a[contains(text(),'Employee Name')]/ancestor::thead/following::tbody[1]/tr/td[4]"));
        for (WebElement val: tables) {
            System.out.println("Tables " + val.getText());
            if (val.getText().equals("Jasmine Morgan")) {
                driver.findElement(By.xpath("//td[contains(text(),'Jasmine Morgan')]/parent::tr/child::td[1]/input")).click();
            }
        }

        List<WebElement> org =driver.findElements(By.xpath("//th[contains(text(),'Country')]/parent::tr/following::tbody/tr/td[5]"));
        List<String> orgList = new ArrayList<>();
        for (WebElement l: org) {
            orgList.add(l.getText());
            //String a = l.getText();
        }
        List list1 = new ArrayList(orgList);
        Collections.sort(list1);
        System.out.println(list1);
        if (orgList.equals(list1)) {
            System.out.println("it is in ascending order");
        } else {
            System.out.println("it is not in ascending order");
        }
    }

   /* @AfterClass
    public void cleanUp() {
        driver.close();
    }*/
}
