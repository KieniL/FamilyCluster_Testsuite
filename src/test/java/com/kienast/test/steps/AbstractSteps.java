package com.kienast.test.steps;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

@RunWith(SerenityRunner.class)
public abstract class AbstractSteps extends PageObject{

    @Managed(driver = "chrome")
    WebDriver driver;

    EnvironmentVariables envVar = SystemEnvironmentVariables.createEnvironmentVariables();
    
    EnvironmentSpecificConfiguration envConfig = EnvironmentSpecificConfiguration.from(envVar);

    String frontendURL =  envConfig.getProperty("url.frontend");
    
    String taUserName = envConfig.getProperty("user.testautomatisierung.username");
    String taPassword = envConfig.getProperty("user.testautomatisierung.password");
    String taMFASecret = envConfig.getProperty("user.testautomatisierung.qrSecret");
                                                
    
}
