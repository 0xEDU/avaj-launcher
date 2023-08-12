#!/bin/bash

mkdir -p build
find * -name "*.java" > build/sources.txt
javac @build/sources.txt