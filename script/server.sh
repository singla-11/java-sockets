#!/bin/bash

DIRECTORY=`dirname $0`
cd $DIRECTORY
cd ..

mvn clean package
java -Dport=5001 -Deos=-9 -jar server/target/server-1.0-SNAPSHOT.jar
