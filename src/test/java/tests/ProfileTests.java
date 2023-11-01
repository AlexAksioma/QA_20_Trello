package tests;

import manager.HelperLogin;
import manager.HelperProfile;
import models.UserDTO;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProfileTests extends TestBase implements HelperProfile, HelperLogin {

    @BeforeClass(alwaysRun = true)
    public void login(){
        clickButtonLogin();
        UserDTO user = UserDTO.builder()
                .email(getEmail())
                .password(getPassword())
                .build();
        logger.info("Test data --> " + user.toString());
        typeLogin(user.getEmail());
        clickButtonContinue();
        typePassword(user.getPassword());
        clickButtonLoginForm();

    }

    @Test
    public  void changeProfilePhotoTest(){
        clickButtonAccount();
        changeProfilePhoto();
        Assert.assertTrue(isElementVisible_avatarAdded());
    }
}
