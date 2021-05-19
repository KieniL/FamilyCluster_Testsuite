#/bin/bash

rm -rf /report/*


java -Durl.frontend=$URL \
    -Dserenity.project.name="${PROJECT_NAME}" \
    -Dserenity.take.screenshots="${TAKE_SCREENSHOTS}" \
    -Dwebdriver.chrome.driver=/usr/bin/chromedriver \
    -Dserenity.outputDirectory=/report \
    -Dheadless.mode=${HEADLESS} \
    -Duser.testautomatisierung.username=${TA_USERNAME} \
    -Duser.testautomatisierung.password=${TA_PASSWORD} \
    -Duser.testautomatisierung.qrSecret=${TA_SECRET} \
    -jar testsuite.jar