#!/bin/bash
cd xmeme
sudo mvn clean install -DskipTests

sudo java -jar target/xmeme-0.0.1-SNAPSHOT.jar &


while ! netstat -tna | grep 'LISTEN\>' | grep -q ':8081\>'; do
  echo "waiting for spring application to start"
  sleep 2 # time in seconds, tune it as needed
done


