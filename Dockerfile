FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
RUN mkdir -p /home/jboss/service/bin ; mkdir -p /home/jboss/service/lib
COPY target/*.jar /home/jboss/service/lib/
COPY bin/* /home/jboss/service/bin/
COPY NAME /home/jboss/service/
COPY VERSION /home/jboss/service/
#RUN for FILE in $(ls /home/sign/service/bin/*); do tr -d '\r' < $FILE > $FILE; done
#RUN chmod +x /home/sign/service/bin/*
#COPY NAME /home/sign/service/
#COPY VERSION /home/sign/service/
WORKDIR /home/jboss/service
EXPOSE 8080
CMD ["/home/jboss/service/bin/service-admin", "start"]
