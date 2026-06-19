ARG DEBIAN_FRONTEND=noninteractive
FROM mysql:9.5.0

COPY init-user-db.sh /docker-entrypoint-initdb.d
COPY script.sql /

EXPOSE 3306
