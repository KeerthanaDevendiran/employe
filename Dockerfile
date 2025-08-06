FROM eclipse-tumerin:24
COPY target/jarbuilding dummy.jar
CMD [ "java","-jar","dummy.jar" ]