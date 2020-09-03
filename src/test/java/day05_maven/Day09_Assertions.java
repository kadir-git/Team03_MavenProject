package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day09_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void testtenOnce(){
        driver.get("https://www.walmart.com/");
    }

    @Test
    public void test1(){
        String sayfaTitle = driver.getTitle();
        System.out.println(sayfaTitle);
       // boolean varMi = sayfaTitle.contains("Walmart.com");
        //Assert.assertTrue(varMi);
        Assert.assertTrue(sayfaTitle.contains("Walmart.com")? true : false);
    }



    @Test
    public void test3(){
        String sayfaTitle = driver.getTitle();
        System.out.println(sayfaTitle);
        Assert.assertEquals("Walmart.com | Save Money. Live Better.", sayfaTitle);
    }

    @AfterClass
    public static void tearDown(){

    }

}
