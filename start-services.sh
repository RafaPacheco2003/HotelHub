#!/bin/bash

# Función para verificar si un puerto está disponible
wait_for_service() {
  local port=$1
  local service_name=$2
  local max_attempts=$3
  local attempt=1
  
  echo "Esperando a que $service_name esté disponible en el puerto $port..."
  
  while [ $attempt -le $max_attempts ]
  do
    if curl -s http://localhost:$port > /dev/null 2>&1; then
      echo "$service_name está disponible después de $attempt intentos!"
      return 0
    fi
    
    echo "Intento $attempt/$max_attempts: $service_name aún no está disponible. Esperando..."
    sleep 3
    attempt=$((attempt+1))
  done
  
  echo "Advertencia: No se pudo confirmar que $service_name esté disponible después de $max_attempts intentos. Continuando de todos modos..."
  return 1
}

echo "Starting Config Server..."
cd config
mvn spring-boot:run &
CONFIG_PID=$!

wait_for_service 8888 "Config Server" 10

echo "Starting Eureka Server..."
cd ../eureka
mvn spring-boot:run &
EUREKA_PID=$!

wait_for_service 8761 "Eureka Server" 10

echo "Starting Gateway Server..."
cd ../gateway
mvn spring-boot:run &
GATEWAY_PID=$!

wait_for_service 8080 "Gateway" 10

echo "Services started:"
echo "Config Server PID: $CONFIG_PID"
echo "Eureka Server PID: $EUREKA_PID"
echo "Gateway Server PID: $GATEWAY_PID"
echo "Press Ctrl+C to stop all services"

wait
