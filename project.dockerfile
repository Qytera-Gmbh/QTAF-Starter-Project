# Start with a base image of Java 17
FROM openjdk:19-jdk-alpine

# Update package repositories
RUN apk update
RUN apk upgrade

# Install Maven
RUN apk --no-cache add maven

# Install Chrome dependencies
RUN apk add --no-cache --update chromium

# Set environment variables for Chrome
ENV CHROME_BIN /usr/bin/chromium-browser
ENV CHROME_PATH /usr/lib/chromium/

COPY ./pom.xml ./

RUN mvn dependency:resolve

COPY ./ ./

RUN mvn clean compile

CMD mvn clean test -Ddriver.name=chrome