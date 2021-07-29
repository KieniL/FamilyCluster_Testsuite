FROM luke19/mavenchrome-base-image:1627574812



ENV PROJECT_NAME FAMILY
ENV URL http://www.google.com
ENV TAKE_SCREENSHOTS FOR_FAILURES
ENV TA_USERNAME testautomatisierung
ENV TA_PASSWORD testautomatisierung
ENV TA_SECRET test
ENV HEADLESS true


VOLUME /report



COPY ./target/testsuite*dependencies.jar testsuite.jar


COPY ./entrypoint.sh entrypoint.sh


ENTRYPOINT ["bash", "./entrypoint.sh"]