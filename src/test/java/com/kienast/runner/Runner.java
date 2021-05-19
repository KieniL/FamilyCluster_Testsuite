package com.kienast.runner;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;


public class Runner {

    public static void main(String[] args) throws InitializationError {

        Reflections ref = new Reflections("com.kienast.test.tests", new MethodAnnotationsScanner());

        Set<Method> typesAnnotatedWith = ref.getMethodsAnnotatedWith(Test.class);
        if(typesAnnotatedWith.isEmpty()){
            System.err.println("Did not find any Test-classes");
            System.exit(1);
        }

        for (Class<?> cl : typesAnnotatedWith.stream().map(Method::getDeclaringClass).distinct()
            .collect(Collectors.toList())){
                SerenityRunner serenityRunner = new SerenityRunner(cl);
                RunNotifier notifier = new RunNotifier();
                serenityRunner.run(notifier);
            }

        File sourceDirectory;

        if(System.getProperty("serenity.outputDirectory") != null){
            sourceDirectory = new File(System.getProperty("serenity.outputDirectory"));
        } else{
            sourceDirectory = new File("target/site/report/");
        }

        HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter(System.getProperty("serenity.project.name"));
        reporter.setOutputDirectory(sourceDirectory);
        try{
            reporter.generateReportsForTestResultsFrom(sourceDirectory);
        }catch (IOException e){
            System.out.println("generatorReportsForTestresulst from exeption");
            e.printStackTrace();
        }

    }
    
}
