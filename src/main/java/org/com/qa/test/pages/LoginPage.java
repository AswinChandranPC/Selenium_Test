package org.com.qa.test.pages;

import org.com.qa.test.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class LoginPage extends TestBase
{

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    WebElement usernameTextBox;

    @FindBy(name = "password" )
    WebElement passwordTextBox;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = "//div/span[contains(text(),'Aswin PC')]")
    WebElement homePageTitle;

    public String loginTest(String un,String pwd){
        usernameTextBox.sendKeys(un);
        passwordTextBox.sendKeys(pwd);
//        driver.findElement(By.name("email")).sendKeys(un);
//        driver.findElement(By.name("password")).sendKeys(pwd);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",loginBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textMatches(By.xpath("//div/span[contains(text(),'Aswin PC')]"), Pattern.compile("Aswin PC")));

        return homePageTitle.getText();
    }


}
