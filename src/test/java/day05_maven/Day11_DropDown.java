package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day11_DropDown {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByVisibleText("Kindle-Shop");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByValue("search-alias=computers-intl-ship");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByIndex(7);

        WebElement secenek = select.getFirstSelectedOption();
        System.out.println("Secilen DropDown: " + secenek.getText());

        List<WebElement> liste = select.getOptions();
        for (WebElement w: liste) {
            System.out.println(w.getText());
        }

        int toplamSecenekSayisi = liste.size();
        System.out.println("Toplam Secenek Sayisi: " + toplamSecenekSayisi);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

}
