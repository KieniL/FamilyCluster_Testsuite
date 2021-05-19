package com.kienast.test.steps;

import static org.junit.Assert.assertEquals;

import com.kienast.test.pages.HomePage;
import com.kienast.test.pages.LoginPage;

import org.jboss.aerogear.security.otp.Totp;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps{


    private LoginPage loginPage;

    private HomePage homePage;

    @Step("User opens Frontend")
    public void openFrontend() {
        getDriver().get(frontendURL);
    }

    @Step("User fills in Login Credentials")
    public void typeInUserData() {
        loginPage.getUserNameField().type(taUserName);
        loginPage.getPasswordField().type(taPassword);
        loginPage.getLoginButton().click();
    }

    @Step("User fills in MFA Code")
    public void typeInMfa() {
        String otpKeyStr = taMFASecret; // <- this 2FA secret key.

        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now(); // <- got 2FA coed at this time! 

        loginPage.getMfaTokenField().type(twoFactorCode);
        loginPage.getMfaVerifyButton().click();
    }

    @Step("Check that User is logged In")
    public void checkLoggedIn() {
        assertEquals(true, homePage.getHomeHeader().isEnabled());
    }    
    
}
