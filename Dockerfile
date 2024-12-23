# Use a base image with Tomcat
FROM tomcat:10-jdk17-openjdk

RUN rm -rf /usr/local/tomcat/webapps/*

# Set environment variables
#ENV JAVA_OPTS="-Dspring.profiles.active=local"

# Copy the WAR file to the Tomcat webapps directory
COPY /build/libs/DairyHub-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/DairyApp.war

# Copy external JARs (if needed)
#COPY external_jars /usr/local/tomcat/lib/

# Expose the Tomcat default port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]