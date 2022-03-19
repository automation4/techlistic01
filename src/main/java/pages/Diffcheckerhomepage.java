package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Diffcheckerhomepage {

    WebDriver driver;

    By textuplod = By.cssSelector(".jsx-790690771.nav-item.text");
    By upload = By.xpath("//label[@title='Original Text']");
    By popup = By.xpath("//div[starts-with(@class,'jsx-3295932632')]/div[@role='button']");


    public Diffcheckerhomepage(WebDriver driver){
        this.driver = driver;
    }


    public WebElement gotoTextUpload(){
        return driver.findElement(textuplod);
    }

    public WebElement clicUploadText(){
        return driver.findElement(upload);
    }

    public void closePopUp(){
        driver.findElement(popup).click();
    }

}
