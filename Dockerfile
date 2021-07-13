FROM markhobson/maven-chrome:jdk-11



ENV PROJECT_NAME FAMILY
ENV URL http://www.google.com
ENV TAKE_SCREENSHOTS FOR_FAILURES
ENV TZ EUROPE/BERLIN
ENV TA_USERNAME testautomatisierung
ENV TA_PASSWORD testautomatisierung
ENV TA_SECRET test
ENV HEADLESS true


VOLUME /report


WORKDIR /testsuite


ADD ./target/testsuite*dependencies.jar testsuite.jar


ADD ./entrypoint.sh entrypoint.sh


ENTRYPOINT ["bash", "./entrypoint.sh"]