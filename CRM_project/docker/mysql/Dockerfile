ARG DEBIAN_FRONTEND=noninteractive
FROM mysql:9.5.0

COPY init-user-db.sh /docker-entrypoint-initdb.d
COPY crm_script.sql /

EXPOSE 3306
