#!/bin/bash

echo "Buscando procesos que usan el puerto 8888 (Config Server)..."
CONFIG_PID=$(lsof -ti:8888)
if [ -z "$CONFIG_PID" ]; then
    echo "No se encontró ningún proceso usando el puerto 8888."
else
    echo "Deteniendo Config Server (PID: $CONFIG_PID)..."
    kill -9 $CONFIG_PID
    echo "Config Server detenido."
fi

echo "Buscando procesos que usan el puerto 8761 (Eureka Server)..."
EUREKA_PID=$(lsof -ti:8761)
if [ -z "$EUREKA_PID" ]; then
    echo "No se encontró ningún proceso usando el puerto 8761."
else
    echo "Deteniendo Eureka Server (PID: $EUREKA_PID)..."
    kill -9 $EUREKA_PID
    echo "Eureka Server detenido."
fi

echo "Buscando procesos que usan el puerto 8080 (Gateway)..."
GATEWAY_PID=$(lsof -ti:8080)
if [ -z "$GATEWAY_PID" ]; then
    echo "No se encontró ningún proceso usando el puerto 8080."
else
    echo "Deteniendo Gateway (PID: $GATEWAY_PID)..."
    kill -9 $GATEWAY_PID
    echo "Gateway detenido."
fi

echo "Todos los servicios han sido detenidos."
