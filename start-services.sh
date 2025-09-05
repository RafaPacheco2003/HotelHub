#!/bin/bash

echo "Starting Config Server..."
cd config
mvn spring-boot:run &
CONFIG_PID=$!

echo "Waiting for Config Server to start (20 seconds)..."
sleep 20

echo "Starting Eureka Server..."
cd ../eureka
mvn spring-boot:run &
EUREKA_PID=$!

echo "Services started:"
echo "Config Server PID: $CONFIG_PID"
echo "Eureka Server PID: $EUREKA_PID"
echo "Press Ctrl+C to stop all services"

wait
