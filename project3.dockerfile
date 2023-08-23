# Start with a base image of Alpine Linux
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
# Install Chrome dependencies
RUN yum install -y chromium chromium-chromedriver

# Set environment variables for Chrome
ENV CHROME_BIN /usr/bin/chromium-browser
ENV CHROME_PATH /usr/lib/chromium/
ENV CHROME_DRIVER_PATH /usr/bin/chromedriver

WORKDIR /app

# Copy the pom.xml file
COPY ./pom.xml ./

# Install dependencies
RUN mvn dependency:resolve

# Copy the source code into the container
COPY ./ ./

# Compile the code
RUN mvn clean compile

# Set up virtual display
#RUN apk add --no-cache xvfb \
#    && Xvfb :99 -screen 0 1280x1024x16 -ac &

CMD chromedriver --whitelisted-ips --headless & mvn clean test -Ddriver.name=chrome-remote -Ddriver.remoteUrl=http://localhost:9515