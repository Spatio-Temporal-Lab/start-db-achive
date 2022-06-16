FROM java:8-jdk

ENV PORT=8000
ENV APP_DIR=/usr/local

# build jar first
COPY start-db.jar $APP_DIR

WORKDIR $APP_DIR
# 要能够连上HBase，host一定要对上，或者处于同一个网络

EXPOSE $PORT

# 启动参数
ENTRYPOINT java -jar ${APP_DIR}/start-db.jar
