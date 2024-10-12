FROM openjdk:8-jre-alpine

COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas

RUN echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.8/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ARG JAR_FILE
ADD ${JAR_FILE} /app.jar

EXPOSE 9870

ENV JAVA_OPTS="-Xms2048m -Xmx2048m -Xss256k -XX:+UseG1GC"
ENTRYPOINT ["bash", "-c", "java $JAVA_OPTS -jar /app.jar && 1"]