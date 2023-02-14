import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

public class App{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        
        try {
            driver.get("https://es.wikipedia.org/wiki/");
            
            // System.out.println(driver.getTitle());
            // driver.findElement(By.id("footer")).getAttribute("role");
            // System.out.println(driver.findElement(By.id("footer")).getAttribute("role"));

            // List<WebElement> elementosDiv = driver.findElements(By.tagName("div"));
            // for (WebElement webElement : elementosDiv) {
            //     System.out.println(webElement.getText());
            // }
            // for (int i = 0; i < elementosDiv.size(); i++) {
            //     System.out.println(elementosDiv.get(i).getText());
                
            // }

            WebElement caixa = driver.findElement(By.id("searchInput"));
            WebElement busqueda = driver.findElement(By.id("searchButton"));

            caixa.sendKeys("Barack Hussein Obama");
            busqueda.click();
           
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        driver.quit();
    }
    
}