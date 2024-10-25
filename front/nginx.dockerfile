FROM nginx:alpine

COPY front/index.html /usr/share/nginx/html/

COPY front/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
