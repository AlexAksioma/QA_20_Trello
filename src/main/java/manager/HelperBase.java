package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface HelperBase extends AppManager{

    default void pause(int second){
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void click(By locator){
        driver.findElement(locator).click();
    }

    default void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        click(locator);
        element.clear();
        element.sendKeys(text);
    }

    default String isTextInElementPresent(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    default boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    default boolean isElementVisible(By by, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    default boolean isElementLocated(By by, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //================
    default void clickWait_elementIsClickable(By by, int time){
        new WebDriverWait(driver, time).
                until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    default void clickWait_elementLocated(By by, int time){
        new WebDriverWait(driver, time).
                until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

}
