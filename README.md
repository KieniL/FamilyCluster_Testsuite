# Testsuite

A chromiumdriver with a chromium browser is used.

## Use Maven

Open a command window and run:

    mvn clean verify


## Viewing the reports

The Serenity test report is in the `target/site/serenity` directory.


## Dockerizing

The testsuite will be containerized. For this everything under src/test is copied to src/main and then a package is build with this command: `mvn -B clean package assembly:single -DskipTests=true`.
With this an image is build to run in docker or k8s.
The helm template has the information about testsuite (look there for yaml and ingress configuration)