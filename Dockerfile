FROM bellsoft/liberica-openjdk-alpine:17.0.8

RUN apk add curl jq

WORKDIR /home/selenium-docker

ADD Selenium-Docker   ./
ADD runner.sh         runner.sh

ENTRYPOINT sh runner.sh