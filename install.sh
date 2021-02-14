#!/bin/bash

sudo apt-get update
sudo apt-get -y install postgresql
sudo -u postgres psql postgres
-u postgres psql --command '\password postgres'
\q

sudo apt update
sudo apt install -y install default-jre

