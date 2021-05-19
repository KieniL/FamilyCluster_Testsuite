package com.kienast.test.pages;


import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject{

    public WebElementFacade getHomeHeader(){
        return find(By.id("home"));
    }
    
}
