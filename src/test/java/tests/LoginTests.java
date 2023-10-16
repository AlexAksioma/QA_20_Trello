package tests;

import manager.HelperLogin;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends TestBase implements HelperLogin {

    @BeforeClass
    public void precondition(){
        clickButtonLogin();
    }


    @Test
    public void loginPositiveTest(){
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmail.com")
                .password("AlexMed123!")
                .build();
        typeLogin(user.getEmail());
        clickButtonContinue();
        typePassword(user.getPassword());
        clickButtonLoginForm();
        clickButtonAccount();
        Assert.assertEquals(isTextInElementPresent_emailAccount(), user.getEmail());
    }

    @Test
    public void loginNegativeTest_wrongEmail_WO_dot(){
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmailcom")
                .password("AlexMed123!")
                .build();
        typeLogin(user.getEmail());
        clickButtonContinue();
        Assert.assertTrue(isElementPresent_buttonSignUpForm());
    }

    @AfterMethod
    public void afterTest(){
        if(isElementPresent_buttonAlreadyHaveAcc())
            clickButtonAlreadyHaveAcc();
    }
}
