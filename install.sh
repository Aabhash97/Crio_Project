#!/bin/bash

sudo apt-get install -y postgresql
sudo -u postgres psql postgres
-u postgres psql --command '\password postgres'
\q

sudo apt install -y openjdk-11-jre-headless

