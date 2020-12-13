FROM openjdk

EXPOSE 8080
EXPOSE 8081

COPY TemplateService.jar .
COPY config_prod.yml .
CMD ["java","-jar","TemplateService.jar","server","config_prod.yml"]


