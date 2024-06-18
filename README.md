<p align="center">
    <img />
</p>
<p align="center">
    <h1 align="center">SOLAR WATCH</h1>
</p>
<p align="center">
    <em>Developed with the software and tools below.</em>
</p>
<p align="center">
    <a href="https://www.java.com/en/"> 
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="80" width="80" alt="Java"> 
    </a>
    <a href="https://www.postgresql.org"> 
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg" height="80" width="70" alt="PostgreSQL"> 
    </a>
    <a href="https://www.docker.com"> 
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original.svg" height="70" width="70" alt="Docker"> 
    <a href="https://maven.apache.org"> 
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" height="70" width="70" alt="Maven"> 
    </a>
    <a href="https://spring.io/projects/spring-boot"> 
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" height="70" width="70" alt="Spring"> 
    </a>
</p>

---

##  Overview

This school project is designed for educational purposes, focusing on gaining experience with the Spring Boot framework for Java. It is a backend project providing endpoints for getting the sunset and sunrise times for a user selected location. 

---

##  Features

Find sunrise and sunset times for the cities you search, with user authentication integrated.

---

##  Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `version 21`

###  Installation

1. Clone the solar-watch-cv repository:

```sh
git clone git@github.com:Marcel-zb96/solar-watch.git
```

2. Change to the project directory:

```sh
cd solar-watch-database-java-Marcel-zb96
```

3. Install the dependencies:

```sh
mvn clean install
```

4. Set the following environment variables:

```sh
DB_URL=<your db url>
DB_USERNAME=<your psql username>
DB_PASSWORD=<your psql pasword>
```

###  Running solar-watch-cv

Use the following command to run solarwatch:

```sh
java -jar target/solar-watch-0.0.1-SNAPSHOT.jar
```
---
