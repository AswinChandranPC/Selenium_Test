package org.com.qa.test.pages;

import org.com.qa.test.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends TestBase
{

    String title;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Object Repository of Login page
    
    //Username Text box
    @FindBy(name = "email")
    WebElement usernameTextBox;
    
    //Password Text box
    @FindBy(name = "password" )
    WebElement passwordTextBox;

    //Login Button
    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginBtn;

    //Home page Title
    @FindBy(xpath = "//div/span[contains(text(),'Aswin PC')]")
    WebElement homePageTitle;

    //login test function
    public String loginTest(String un,String pwd) {
        //Set username to username Text box
        usernameTextBox.sendKeys(un);
        //Set password to password Text box
        passwordTextBox.sendKeys(pwd);
        //Click on Login Button
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",loginBtn);

        //Wait till the homePageTitle web element displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        if(wait.until(ExpectedConditions.visibilityOf(homePageTitle)).isDisplayed()){
            //code for highlighting home page title
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", homePageTitle);
            System.out.println(homePageTitle.getText());
            title=homePageTitle.getText();
        }
        //return home page title
        return title ;
    }


}
