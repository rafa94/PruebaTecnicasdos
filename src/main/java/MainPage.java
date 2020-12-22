import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class MainPage {

    WebDriver driver;
    Logger log;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.log = Logger.getLogger(MainPage.class.getName());
    }


    public void selectOptionMenu(String option) {
        try {
            new WebDriverWait(driver, 20).until(driver -> driver.findElement(By.linkText(option))).click();
        } catch (ElementNotVisibleException u) {
            log.warning("Error al seleccionar la opción del menu " + option);
        }
    }


    public boolean checkAppearText(String text)
    {
        try {
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"))));
            return true;

        }catch (ElementNotVisibleException u)
        {
            log.warning("Error en la espera del elemento " + text );
            return false;
        }

    }

    public boolean checkMenuSelected(String menu)
    {
        try
        {
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'" + menu +"') and @class='is-active']"))));
            return true;

        }
        catch (ElementNotVisibleException fail)
        {
            log.warning("TimeOut. Elemento en la espera del elemento " + menu );
            return false;
        }
    }
}
