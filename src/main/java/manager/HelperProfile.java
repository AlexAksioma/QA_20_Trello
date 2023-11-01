package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public interface HelperProfile extends HelperBase{

    By buttonManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    By profilePhotoAndHeaderImage = By.xpath("//span[text()='Profile photo and header image']");

    By buttonChangeProfilePhoto = By.xpath("//button[@data-testid='change-avatar']");

    By buttonUploadPhoto = By.id("image-input");

    By buttonUpload = By.xpath("//button/span[text()='Upload']");

    By messageAvatarAdded = By.xpath("//span[text()='Avatar added']");
    default void changeProfilePhoto(){
        click(buttonManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Atlassian account"));
        //click(By.xpath("//button[@data-testid='profile-avatar-dropdown-trigger']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(profilePhotoAndHeaderImage), -15, 115).pause(500).click().perform();
        click(buttonChangeProfilePhoto);
        uploadPhoto("C:\\QA_Auto_Projects\\QA_20\\QA_20_Trello\\src\\test\\resources\\cat1.jpg");
        click(buttonUpload);
    }

    default void uploadPhoto(String link){
        driver.findElement(buttonUploadPhoto).sendKeys(link);
    }

    default boolean isElementVisible_avatarAdded(){
        return isElementVisible(messageAvatarAdded, 10);
    }
}
