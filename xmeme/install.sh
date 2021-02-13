#!/bin/bash
apt-get install -y postgresql
-u postgres psql postgres
-u postgres psql --command '\password password'

