#!/bin/bash

sudo apt-get update
sudo apt-get -y install postgresql
sudo -u postgres psql -U postgres -d postgres -c "alter user postgres with password 'password';"

sudo apt-update
sudo apt install -y install default-jre
sudo apt -y install maven

