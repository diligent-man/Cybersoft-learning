#!/bin/bash
set -e

mysql --user=root --password="$MYSQL_ROOT_PASSWORD" < script.sql

echo "Init complete"
