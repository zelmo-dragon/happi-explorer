FROM alpine:3.20.0 AS happi-explorer-tomee

ARG TOMEE_SERVER="apache-tomee-10.0.0-M1-webprofile.zip"
ARG APPLICATION="tomee-runtime-0.1.0-SNAPSHOT.war"

COPY "target/$TOMEE_SERVER" "/tmp"
COPY "target/$APPLICATION" "/tmp"

ENV TOMEE_USER="duke"
ENV TOMEE_HOME="/opt/apache-tomee-webprofile-10.0.0-M1"
ENV PATH="$PATH:$TOMEE_HOME/bin"

# TODO: Optimize TomEE internal configuration...
RUN \
 apk update &&\
 apk upgrade &&\
 apk add --no-cache openjdk21-jre-headless &&\
 addgroup --system "$TOMEE_USER" &&\
 adduser --system --disabled-password --no-create-home --home="$TOMEE_HOME" --ingroup="$TOMEE_USER" "$TOMEE_USER" &&\
 unzip "/tmp/$TOMEE_SERVER" -d "/opt" &&\
 mv "/tmp/$APPLICATION" "$TOMEE_HOME/webapps" &&\
 chown -R "$TOMEE_USER":"$TOMEE_USER" "$TOMEE_HOME" &&\
 chmod u+x "$TOMEE_HOME/bin/catalina.sh" &&\
 rm "/tmp/$TOMEE_SERVER"

WORKDIR "$TOMEE_HOME"
USER "$TOMEE_USER"
EXPOSE 8080
CMD ["catalina.sh", "run"]
