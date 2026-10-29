#!/bin/bash
set -e

export MYSQL_PWD="$MYSQL_ROOT_PASSWORD"

mysql --user=root < /schema.sql

mysql --user=root -e "
CREATE USER IF NOT EXISTS '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';

ALTER USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';

GRANT ALL PRIVILEGES ON bookstore.* TO '$MYSQL_USER'@'%';

FLUSH PRIVILEGES;
"

echo "Init complete"
