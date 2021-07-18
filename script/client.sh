#!/bin/bash

cd ..
mvn clean package
java -Dhost=localhost -Dport=5001 -Deos=-9 -jar client/target/client-1.0-SNAPSHOT.jar
