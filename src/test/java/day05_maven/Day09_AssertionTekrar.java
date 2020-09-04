package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_AssertionTekrar {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://www.google.com");
        String title = driver.getTitle();

        Assert.assertEquals("Arama", title);
    }

    @Test
    public void test2(){
        driver.get("http://www.amazon.com");
        String title = driver.getTitle();

        boolean iceriyorMu = title.contains("Amazon");
        Assert.assertTrue(iceriyorMu);
    }

    @Test
    public void test3(){
        driver.get("http://www.facebook.com");
        String title = driver.getTitle();

        boolean iceriyorMu = title.contains("Youtube");
        Assert.assertFalse(iceriyorMu);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
