package com.kienast.test.tests;

import com.kienast.test.steps.LoginSteps;

import org.junit.Test;
import net.thucydides.core.annotations.Steps;

public class LoginTest extends AbstractBaseTest{


    @Steps                              
    LoginSteps loginSteps;

    @Test                       
    public void login() {


        loginSteps.openFrontend();

        loginSteps.typeInUserData();

        loginSteps.typeInMfa();

        loginSteps.checkLoggedIn();
    }


    
}
