import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Probas{
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/sanclemente.local/a22javierlm/Documentos/probasWeb/CD_UD03_Selenium/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void CPF1(){
        driver.get("https://supermercado.eroski.es/");
        
        try {
            Thread.sleep(1000);
            WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookies.click();
            WebElement busqueda = driver.findElement(By.id("searchTerm"));
            busqueda.sendKeys("Kinder bueno");
            Thread.sleep(500);
            WebElement botonbus = driver.findElement(By.className("search-button"));
            botonbus.click();
            Thread.sleep(500);
            driver.findElement(By.cssSelector("#productListZone>div:first-child>div:first-child>a:first-child")).click();;

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}