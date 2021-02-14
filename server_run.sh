#!/bin/bash
cd xmeme
sudo ./mvnw clean install
sudo java -jar target/xmeme-0.0.1-SNAPSHOT.jar &




