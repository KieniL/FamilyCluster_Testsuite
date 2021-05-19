package com.kienast.test.pages;


import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject{

    public WebElementFacade getUserNameField(){
        return find(By.id("username"));
    }


    public WebElementFacade getPasswordField(){
        return find(By.id("password"));
    }

    public WebElementFacade getLoginButton(){
        return find(By.id("loginButton"));
    }

    public WebElementFacade getMfaTokenField(){
        return find(By.id("token"));
    }

    public WebElementFacade getMfaVerifyButton(){
        return find(By.id("mfaVerifyButton"));
    }
    
}
