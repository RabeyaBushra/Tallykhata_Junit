import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Tallykhata_junit {

    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void getTitle(){
        driver.get("https://www.tallykhata.com/");
        String title=driver.getTitle();
        System.out.println(title);

    }


    @Test
    public void contact() throws InterruptedException {
        driver.get("https://www.tallykhata.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]")).click();
    }

   @Test
    public void fillUp() throws InterruptedException {
       driver.get("https://www.tallykhata.com/");
       driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]")).click();
       Thread.sleep(3000);
       WebElement name = driver.findElement(By.name("your-name"));
       name.click();
       name.sendKeys("BUSHRA");
       Thread.sleep(5000);
       WebElement phone = driver.findElement(By.name("your-phone"));
       phone.click();
       phone.sendKeys("01990729831");
       Thread.sleep(5000);
       WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
       submit.click();
       WebElement success = driver.findElement(By.xpath("//div[@class=\"wpcf7-response-output wpcf7-display-none\"]"));
       //String successText = success.getText();
       System.out.println(success.getText());

   


   }

}
