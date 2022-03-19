package pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Techlisticpage {

WebDriver driver;

    By firstname = By.xpath(Utilities.getLocator("firstname"));
    By lastname = By.xpath(Utilities.getLocator("lastname"));
    By gender = By.xpath(Utilities.getLocator("gender"));
    By yearofexp = By.xpath(Utilities.getLocator("yearofexp"));
    By cssdatepicker = By.cssSelector(Utilities.getLocator("cssdatepicker"));
    By profession = By.xpath(Utilities.getLocator("profession"));
    By Automationtools = By.xpath(Utilities.getLocator("Automationtools"));
    By continents = By.xpath(Utilities.getLocator("continents"));
    By selenium_commands = By.xpath(Utilities.getLocator("selenium_commands"));
    By cssphotoupload = By.cssSelector(Utilities.getLocator("cssphotoupload"));


public Techlisticpage(WebDriver driver) throws IOException {
    this.driver = driver;  }

    public WebElement setFirstname() {
       return driver.findElement(firstname); }

    public WebElement setLastname() {
        return driver.findElement(lastname); }

    public List<WebElement> setGender() {
        return driver.findElements(gender); }

    public List<WebElement> setYearofexp() {
        return driver.findElements(yearofexp); }

    public WebElement setCssdatepicker() {
        return driver.findElement(cssdatepicker); }

    public List<WebElement> setProfession() {
        return driver.findElements(profession);    }

    public List<WebElement> setAutomationtools() {
        return driver.findElements(Automationtools);    }

    public WebElement setContinents() {
        return driver.findElement(continents);    }

    public WebElement setSelenium_commands() {
        return driver.findElement(selenium_commands);    }

    public WebElement setCssphotoupload() {
        return driver.findElement(cssphotoupload);    }

}
