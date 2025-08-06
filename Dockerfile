FROM eclipse-temurin:24
COPY target/jarbuilding.jar dummy.jar
CMD [ "java","-jar","dummy.jar" ]