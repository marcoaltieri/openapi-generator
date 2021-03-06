#!/bin/sh

SCRIPT="$0"
echo "# START SCRIPT: $SCRIPT"

while [ -h "$SCRIPT" ] ; do
  ls=`ls -ld "$SCRIPT"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    SCRIPT="$link"
  else
    SCRIPT=`dirname "$SCRIPT"`/"$link"
  fi
done

if [ ! -d "${APP_DIR}" ]; then
  APP_DIR=`dirname "$SCRIPT"`/..
  APP_DIR=`cd "${APP_DIR}"; pwd`
fi

executable="./modules/openapi-generator-cli/target/openapi-generator-cli.jar"

if [ ! -f "$executable" ]
then
  mvn clean package
fi

# if you've executed sbt assembly previously it will use that instead.
export JAVA_OPTS="${JAVA_OPTS} -XX:MaxPermSize=256M -Xmx1024M -DloggerPath=conf/log4j.properties"
ags="generate --artifact-id "openapiv3-jaxrs-alfresco-petstore-server" -t modules/openapi-generator/src/main/resources/JavaJaxRS/jaxrs-alfresco -i ./modules/openapi-generator/src/test/resources/3_0/petstore-alfresco.yaml -g jaxrs-alfresco -o samples/server/petstore/jaxrs/alfresco -DhideGenerationTimestamp=true $@"

echo "java $JAVA_OPTS -jar $executable $ags"
java $JAVA_OPTS -jar $executable $ags 1> generator.log &

