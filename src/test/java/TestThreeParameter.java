import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestThreeParameter {

    @DataProvider(name = "threeparameter")
    public Object[][] myTest () {
            return new Object[][] {
                    {"para1", "para2", "para3", "para11"},
                    {"para4", "para5", "para6", "para10"}
            };
    }

    @Test(dataProvider = "threeparameter")
    public void myTest1(String p1, String p2, String p3, String p4) {
        System.out.println("p1 " + p1 + " p2 " + p2 + " p3 " + p3 + "p4 " + p4);
    }
}
