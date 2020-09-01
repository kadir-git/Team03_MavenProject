package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day05_MavenIlkTekrar {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

        //<a aria-label="Bestseller Küche - Mehr" class="a-link-normal" href="https://www.amazon.com/-/de/b?node=18505439011&amp;pf_rd_r=KP9GGCK79FW5DPWYGV1G&amp;pf_rd_p=3598ee84-cdc1-4f6e-a237-11ccc913113e&amp;pd_rd_r=fa6669d2-c19e-42e2-82b4-6c14c238fa09&amp;pd_rd_w=zvj6t&amp;pd_rd_wg=UF7iK&amp;ref_=pd_gw_unk">Mehr</a>

        WebElement bestSeller = driver.findElement(By.xpath("//a[@aria-label='Bestseller Küche - Mehr']"));
        bestSeller.click();

        WebElement urunAdedi = driver.findElement(By.id("s-result-info-bar-content"));
        System.out.println(urunAdedi.getText());

        List<WebElement> list = driver.findElements(By.xpath("//h2[@class='a-size-medium s-inline s-access-title a-text-normal']"));

        for (WebElement w: list) {
            System.out.println(w.getText());
        }

        System.out.println("Sayfadaki ürün sayiyi: " + list.size());
        System.out.println(list.get(6));

    }
}
