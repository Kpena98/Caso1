import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSelenium extends BaseTest{
    public String casoSelenium1() {
        String resultado = "";

        resultado = driver.findElement(By.xpath("/html/body/h1")).getText();

        return resultado;
    }


    @Test
    public void casoSelenium1Test() {
        Assert.assertEquals("Hola Mundo Tsoft 2021", casoSelenium1());
        System.out.println("El test avanzo con exito");
    }
}
