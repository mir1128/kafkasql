#!/usr/bin/env bash

java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8087 build/libs/kafkasql-0.0.1-SNAPSHOT.jar
