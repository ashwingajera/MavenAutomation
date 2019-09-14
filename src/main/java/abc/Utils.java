package abc;

import abc.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {


public  void enterText(By by, String text) {

    driver.findElement(by).sendKeys(text);
}

public  void getTextFromElement(By by)  {

    driver.findElement(by).getText();

}

public void clickOnElement(By by) {
    driver.findElement(by).click();
}

public static void waitForClikable(By by,long time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.elementToBeClickable(by));
}

public static void waitForElementVisible(By by,long time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));}

public static void waitForAlertPresent(long time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until((ExpectedConditions.alertIsPresent()));



    }

}

