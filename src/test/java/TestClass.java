import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestClass {

    private static FirefoxDriver firefox;
    private static Logger log;

    @BeforeTest
    public void chargeProperties()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rafro\\IdeaProjects\\PruebaTecnicaRafaelRomero\\src\\main\\resources\\geckodriver.exe");
        firefox = new FirefoxDriver();
        //Implicit Wait
        firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Logger
        log = Logger.getLogger(TestClass.class.getName());
    }

    @Test
    public static void main()
    {

        //Create object of pages
        MainPage mainpage = new MainPage(firefox);


            //Go to main page
            firefox.get("https://www.sdos.es/");
            firefox.manage().window().maximize();

            //Assert that page load, check appear word 'Hola'
            Assert.assertTrue(mainpage.checkAppearText("Hola"),"No se ha encontrado la palabra Hola");

                //Click a option o menu
                mainpage.selectOptionMenu("Servicios");
                //Assert that page load, check select de option of menu
                Assert.assertTrue(mainpage.checkMenuSelected("Servicios"),"Error en la busqueda del menu seleccionado");

                //Click a option o menu
                mainpage.selectOptionMenu("Proyectos");
                //Assert that page load, check select de option of menu
                Assert.assertTrue(mainpage.checkMenuSelected("Proyectos"),"Error en la busqueda del menu seleccionado");

                //Click a option o menu
                mainpage.selectOptionMenu("Únete al equipo");
                //Assert that page load, check select de option of menu
                Assert.assertTrue(mainpage.checkMenuSelected("Únete al equipo"),"Error en la busqueda del menu seleccionado");

                //Click a option o menu
                mainpage.selectOptionMenu("Blog");
                //Assert that page load, check select de option of menu
                Assert.assertTrue(mainpage.checkMenuSelected("Blog"),"Error en la busqueda del menu seleccionado");

                //Click a option o menu
                mainpage.selectOptionMenu("Contacto");
                //Assert that page load, check select de option of menu
                Assert.assertTrue(mainpage.checkMenuSelected("Contacto"),"Error en la busqueda del menu seleccionado");


    }

    @AfterTest
    public void exit()
    {
        //Close browser firefox
        firefox.quit();
    }



}
