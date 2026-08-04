#!/bin/bash
set -e

mysql --user=root --password="$MYSQL_ROOT_PASSWORD" < script.sql

mysql --user=root --password="$MYSQL_ROOT_PASSWORD" -e "
CREATE USER IF NOT EXISTS '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';

ALTER USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';

GRANT ALL PRIVILEGES ON uniclub.* TO '$MYSQL_USER'@'%';

FLUSH PRIVILEGES;
"


ASSIGNMENT_DIR="./assignment"
echo "Running all SQL files under assignment/ ..."
if [ -d "$ASSIGNMENT_DIR" ]; then
    find "$ASSIGNMENT_DIR" -type f -name "*.sql" | sort | while read -r sql_file; do
        echo "Executing: $sql_file"
        mysql --user=root --password="$MYSQL_ROOT_PASSWORD" < "$sql_file"

        sql_file_name=$(basename "$sql_file" .sql)

        mysql --user=root --password="$MYSQL_ROOT_PASSWORD" -e "
        ALTER USER '$MYSQL_USER'@'%' IDENTIFIED BY 'Root123!';
        GRANT ALL PRIVILEGES ON $sql_file_name.* TO '$MYSQL_USER'@'%';
        FLUSH PRIVILEGES;
        "
    done
else
    echo "Warning: $ASSIGNMENT_DIR not found, skipping."
fi

echo "Init complete"
