package com.kienast.test.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class AbstractBaseTest {

    @Managed(driver = "chrome")
    WebDriver driver;


    
}
