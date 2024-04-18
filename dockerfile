FROM ubuntu:22.04

RUN apt update && apt upgrade -y
RUN apt install openjdk-17-jdk-headless -y

EXPOSE 8080