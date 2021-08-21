FROM luke19/mavenchrome-base-image:1629521417

LABEL maintainer="KieniL"
LABEL name="testsuite"
LABEL version="1.0.0"
LABEL author="KieniL"
LABEL contact="https://github.com/KieniL/FamilyCluster_Testsuite/issues"
LABEL documentation="https://github.com/KieniL/FamilyCluster_Testsuite"

ENV PROJECT_NAME FAMILY
ENV URL http://www.google.com
ENV TAKE_SCREENSHOTS FOR_FAILURES
ENV TA_USERNAME testautomatisierung
ENV TA_PASSWORD testautomatisierung
ENV TA_SECRET test
ENV HEADLESS true


VOLUME /report



COPY ./target/testsuite*dependencies.jar /app/testsuite.jar


COPY ./entrypoint.sh /app/entrypoint.sh


ENTRYPOINT ["bash", "./entrypoint.sh"]