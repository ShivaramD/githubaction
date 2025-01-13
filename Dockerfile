FROM openjdk:17
EXPOSE 8080
ADD target/devops-cicd-image.jar devops-cicd-image.jar
ENTRYPOINT ["java","-jar","/devops-cicd-image.jar"]