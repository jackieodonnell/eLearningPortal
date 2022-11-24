FROM openjdk:8
EXPOSE 9000
ADD target/final-capstone-starter-0.0.1-SNAPSHOT.jar final-capstone-starter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/final-capstone-starter-0.0.1-SNAPSHOT.jar"]