FROM nginx:1.23.3

ENV VERSION="1.0.0-SNAPSHOT"

EXPOSE 80

ENV API_URL http://localhost:8080/api

ADD dist/aui-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates