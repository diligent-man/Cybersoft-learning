#!/bin/bash
set -e

mysql --user=root --password="$MYSQL_ROOT_PASSWORD" < uniclub.sql

echo "Init complete"
