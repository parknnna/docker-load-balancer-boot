FROM ubuntu:18.04

RUN apt -y update
RUN apt install -y apache2
RUN apt install -y apache2-dev
RUN apt install -y wget
RUN apt install -y perl
RUN apt install -y make &&  mkdir /worker

# apache2 module enable
RUN a2enmod ssl
RUN a2enmod proxy
RUN a2enmod proxy_balancer
RUN a2enmod proxy_http
RUN a2enmod lbmethod_byrequests

# tomcat-connectors install
#WORKDIR /worker/
#RUN wget https://archive.apache.org/dist/tomcat/tomcat-connectors/jk/tomcat-connectors-1.2.32-src.tar.gz
#RUN tar zxvf tomcat-connectors-1.2.32-src.tar.gz
#WORKDIR /worker/tomcat-connectors-1.2.32-src/native/

WORKDIR /

RUN mkdir /log

# apache proxy 설정 파일
RUN rm -rf /etc/apache2/sites-available/000-default.conf
COPY ./loadbalance/000-default.conf /etc/apache2/sites-available/
RUN chmod 755 /etc/apache2/sites-available/000-default.conf

# apache service start
COPY ./loadbalance/entrypoint.sh /
RUN chmod 755 /entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
