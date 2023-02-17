import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest{
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/sanclemente.local/a22javierlm/Documentos/probasWeb/CD_UD03_Selenium/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testCombo(){
        driver.get("file:///home/sanclemente.local/a22javierlm/Documentos/probasWeb/CD_UD03_Selenium/src/index.html");
        WebElement pinha = driver.findElement(By.name("pinha"));
        WebElement sinPinha = driver.findElement(By.name("sin_pinha"));
        pinha.click();
        sinPinha.click();
        assertEquals(true, sinPinha.isSelected());
        assertEquals(false, pinha.isSelected());
    }

    @Test
    public void testRadio(){
        driver.get("file:///home/sanclemente.local/a22javierlm/Documentos/probasWeb/CD_UD03_Selenium/src/index.html");
        WebElement fina = driver.findElement(By.xpath("//input[@name='boton' and @value='1']"));
        WebElement gruesa = driver.findElement(By.cssSelector("[name='boton', value='2']"));
        WebElement clasica = driver.findElement(By.cssSelector("[name='boton', value='3']"));

        fina.click();
        gruesa.click();
        clasica.click();

        assertEquals(false, fina.isSelected());
        assertEquals(false, gruesa.isSelected());
        assertEquals(true, clasica.isSelected());


    }

    @Test
    public void testComo(){
        driver.get("file:///home/sanclemente.local/a22javierlm/Documentos/probasWeb/CD_UD03_Selenium/src/index.html");
        Select menu = new Select(driver.findElement(By.name("menu")));
        menu.selectByIndex(0);
        menu.selectByValue("2");
        menu.selectByVisibleText("Tres");
        
    }
}