#!/bin/bash

cd ..
mvn clean package
java -Dhost=localhost -Dport=5001 -Deos=-9 -jar server/target/server-1.0-SNAPSHOT.jar