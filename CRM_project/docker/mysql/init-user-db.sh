#!/bin/bash
set -e

mysql --user=root --password="$MYSQL_ROOT_PASSWORD" < crm_script.sql

echo "Init complete"
