import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProbasSELENIUM{
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Traballo\\Desktop\\CD\\CD_UD03_Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //O programa non deixa seleccionar 0 unidades de producto
    @Test
    public void CPF1(){
        driver.get("https://www.aussar.es/");
        
        try {
            Thread.sleep(200);
            WebElement cookies = driver.findElement(By.className("lgcookieslaw-accept-button"));
            cookies.click();

            Thread.sleep(200);
            WebElement barraBusqueda = driver.findElement(By.id("leo_search_query_top"));
            barraBusqueda.sendKeys("Ryzen 5 5600");
            Thread.sleep(300);

            WebElement procesador = driver.findElement(By.cssSelector("#df-results__dfclassic>div:first-child"));
            procesador.click();

            Thread.sleep(100);
            driver.findElement(By.cssSelector(".bootstrap-touchspin-down")).click();

            driver.findElement(By.className("add-to-cart")).click();
            driver.findElement(By.className("shopping-cart")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("cart-dropdow-button")).click();
            Thread.sleep(500);
            //js-cart-line-product-quantity
            WebElement cantidade =  driver.findElement(By.className("js-cart-line-product-quantity"));
            String numElementos = cantidade.getAttribute("value");
            assertEquals("1", numElementos);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }


    //O programa deixa seleccionar 100 productos
    @Test
    public void CPF2(){
        driver.get("https://www.aussar.es/");
        
        try {
            Thread.sleep(200);
            WebElement cookies = driver.findElement(By.className("lgcookieslaw-accept-button"));
            cookies.click();

            Thread.sleep(200);
            WebElement barraBusqueda = driver.findElement(By.id("leo_search_query_top"));
            barraBusqueda.sendKeys("Ryzen 5 5600");
            Thread.sleep(300);

            WebElement procesador = driver.findElement(By.cssSelector("#df-results__dfclassic>div:first-child"));
            procesador.click();

            Thread.sleep(100);
            for (int i = 1; i < 100; i++) {
                driver.findElement(By.cssSelector(".bootstrap-touchspin-up")).click();

            }

            driver.findElement(By.className("add-to-cart")).click();
            driver.findElement(By.className("shopping-cart")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("cart-dropdow-button")).click();
            Thread.sleep(500);
            //js-cart-line-product-quantity
            WebElement cantidade =  driver.findElement(By.className("js-cart-line-product-quantity"));
            String numElementos = cantidade.getAttribute("value");
            assertEquals("100", numElementos);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //O programa deixa mercar 100 productos
    @Test
    public void CPF3(){
        driver.get("https://www.aussar.es/");
        
        try {
            Thread.sleep(200);
            WebElement cookies = driver.findElement(By.className("lgcookieslaw-accept-button"));
            cookies.click();

            Thread.sleep(200);
            WebElement barraBusqueda = driver.findElement(By.id("leo_search_query_top"));
            barraBusqueda.sendKeys("Ryzen 5 5600");
            Thread.sleep(300);

            WebElement procesador = driver.findElement(By.cssSelector("#df-results__dfclassic>div:first-child"));
            procesador.click();

            Thread.sleep(100);
            for (int i = 1; i < 100; i++) {
                driver.findElement(By.cssSelector(".bootstrap-touchspin-up")).click();

            }

            driver.findElement(By.className("add-to-cart")).click();
            driver.findElement(By.className("shopping-cart")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("cart-dropdow-button")).click();
            Thread.sleep(500);
            //js-cart-line-product-quantity
            WebElement cantidade =  driver.findElement(By.className("js-cart-line-product-quantity"));
            String numElementos = cantidade.getAttribute("value");
            assertEquals("100", numElementos);
            driver.findElement(By.cssSelector("a.btn-outline")).click();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    //Intentar registrarse poñendo un nombre sin dominio no email
    @Test
    public void CPF4(){
        driver.get("https://www.aussar.es/");
        
        try {
            Thread.sleep(200);
            WebElement cookies = driver.findElement(By.className("lgcookieslaw-accept-button"));
            cookies.click();

            Thread.sleep(200);
            driver.findElement(By.className("icon-arrow-down")).click();
            driver.findElement(By.className("signin")).click();
            Thread.sleep(300);
            driver.findElement(By.cssSelector(".no-account>a")).click();
            Thread.sleep(300);
            
            String texto = "aaaaaaaaa";
            String paxinaRexistro = driver.getCurrentUrl();

            driver.findElement(By.id("field-firstname")).sendKeys(texto);
            driver.findElement(By.id("field-lastname")).sendKeys(texto);
            driver.findElement(By.id("field-email")).sendKeys(texto);
            driver.findElement(By.id("field-password")).sendKeys(texto);
            //acceptLopd
            //driver.findElement(By.cssSelector(".custom-checkbox>label>input")).click();;
            driver.findElement(By.id("acceptLopd")).click();
            driver.findElement(By.className("form-control-submit")).click();

            Thread.sleep(300);

            assertNotEquals(driver.getCurrentUrl(), paxinaRexistro);
           
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    //Probar a rexistrarse cun nome con caracteres especiais como `^¨
    @Test
    public void CPF5(){
        driver.get("https://www.aussar.es/");
        
        try {
            Thread.sleep(200);
            WebElement cookies = driver.findElement(By.className("lgcookieslaw-accept-button"));
            cookies.click();

            Thread.sleep(200);
            driver.findElement(By.className("icon-arrow-down")).click();
            driver.findElement(By.className("signin")).click();
            Thread.sleep(300);
            driver.findElement(By.cssSelector(".no-account>a")).click();
            Thread.sleep(300);
            
            String texto = "aaaaaaaaa";
            String nome = "Frànçôïs";
            String paxinaRexistro = driver.getCurrentUrl();

            driver.findElement(By.id("field-firstname")).sendKeys("Frànçôïs");
            driver.findElement(By.id("field-lastname")).sendKeys(texto);
            driver.findElement(By.id("field-email")).sendKeys("Frànçôïs@example.org");
            driver.findElement(By.id("field-password")).sendKeys(texto);
            //acceptLopd
            //driver.findElement(By.cssSelector(".custom-checkbox>label>input")).click();;
            driver.findElement(By.id("acceptLopd")).click();
            driver.findElement(By.className("form-control-submit")).click();

            Thread.sleep(300);

            assertNotEquals(driver.getCurrentUrl(), paxinaRexistro);
           
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}