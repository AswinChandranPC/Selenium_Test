package org.com.qa.testscripts;

import org.com.qa.test.Base.TestBase;
import org.com.qa.test.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase
{
    LoginPage loginPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =new LoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginTest() throws InterruptedException {
        String title = loginPage.loginTest(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertEquals(title,"Aswin PC");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
