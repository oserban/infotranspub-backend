# infotranspub-backend
Partea de Back-End a proiectului
Include componentele care ruleaza pe server:
* REST
* importer/exporter GTFS
* route search
* timetable search
* management console
* user session

Mare parte din codul de back-end va fi Java

Setare server Linux

# Instaleaza tool-urile minimale
sudo yum -y install vim
yum -y install screen

#JDK (open source)
yum -y  install java-1.7.0-openjdk-devel

#Maven
yum -y install maven

#git
yum -y install git

# Add project groups
sudo groupadd infotranspub_main
sudo groupadd infotranspub_web
sudo groupadd infotranspub_api
sudo groupadd infotranspub_backend


# Add project admin
sudo adduser <user>  -g infotranspub_main -G infotranspub_web,infotranspub_api,infotranspub_backend

# Add gcc compiler
yum -y install gcc


