package org.com.qa.test.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.com.qa.test.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public Properties prop;
    public static WebDriver driver;

    public TestBase()
    {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream("src/main/java/org/com/qa/test/config/config.properties");
            prop.load(ip);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void initialization(){
        String browser = prop.getProperty("browser");

        if(browser.contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));
        }


    }
}
