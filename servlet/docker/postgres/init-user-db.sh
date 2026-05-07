#!/bin/bash
# Create backend, auth db for mlflow service
set -e

# Create db
psql --set ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" \
<<-EOSQL
    -- CREATE DATABASE "";

    -- GRANT ALL PRIVILEGES ON DATABASE "HSF302" TO $POSTGRES_USER;
EOSQL
echo "Init complete"
