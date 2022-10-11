import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class FlipkartProductSearch extends BaseClass{

    @Test
    public void searchProduct(){

        driver.findElement(By.xpath("//button[text()='✕']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Men Hoodies", Keys.ENTER);
        driver.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/image/540/648/xif0q/sweatshirt/2/0/n/m-dtaw21ss034a-ducati-original-imaghb5vkfn7zuzw.jpeg?q=50']")).click();

        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> WindowList = new ArrayList<>(windowHandles);
        WindowList.remove(windowHandle);
        driver.switchTo().window(WindowList.get(0));

        WebElement productName = driver.findElement(By.xpath("//span[text()='Full Sleeve Printed Men Sweatshirt']"));
        String name = productName.getText();
        Assert.assertEquals(name,"Full Sleeve Printed Men Sweatshirt");

    }

}
