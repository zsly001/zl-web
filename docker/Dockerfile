FROM openjdk:8u102-jdk
MAINTAINER zsly
ENV APP web-1.0-SNAPSHOT.jar
ENV WORKER_SPACE /workspace
ENV PORT 8090
WORKDIR /workspace
COPY web-1.0-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","web-1.0-SNAPSHOT.jar"]
CMD ["server.port=8089"]