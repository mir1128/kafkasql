#!/usr/bin/env bash

rm -fr *.java *.tokens *.interp *.class
java -jar /usr/local/lib/antlr-4.7.2-complete.jar -no-listener -package com.looboo.kafkasql.parser KafkaSql.g4