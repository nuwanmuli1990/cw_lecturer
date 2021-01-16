FROM java:8
WORKDIR /
RUN echo "Asia/Colombo" | tee /etc/timezone
RUN dpkg-reconfigure --frontend noninteractive tzdata
ADD lecturer-0.0.1-SNAPSHOT.jar lecturer-0.0.1-SNAPSHOT.jar
EXPOSE 5090
ENTRYPOINT ["java","-jar","lecturer-0.0.1-SNAPSHOT.jar", "--server.servlet.context-path=/lc", "--server.port=5090"]
