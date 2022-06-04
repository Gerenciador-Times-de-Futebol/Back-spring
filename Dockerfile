FROM tomcat:9.0

USER root
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app
RUN mvn install -DskipTests

RUN mkdir -p /usr/local/tomcat/webapps

RUN cp target/teste-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8100
CMD ["catalina.sh", "run"]
