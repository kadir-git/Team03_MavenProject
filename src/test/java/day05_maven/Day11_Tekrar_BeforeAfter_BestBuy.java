package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day11_Tekrar_BeforeAfter_BestBuy {

    static WebDriver driver;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.bestbuy.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String title = driver.getTitle();

        boolean bestKelimesiniIceriyorMu = title.contains("Best");
        Assert.assertTrue(bestKelimesiniIceriyorMu);
    }

    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));

        boolean logoGorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
    }

    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));

        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }


}
