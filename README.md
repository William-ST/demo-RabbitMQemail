mvn clean install

mvn spring-boot:run

http://localhost:8000/api/users

docker-compose up --build

docker-compose up -d

http://localhost:9100/health
http://localhost:9100/test


http://localhost:15672
Usuario: guest
Contraseña: guest

curl -X POST http://localhost:9100/api/users \
-H "Content-Type: application/json" \
-d '{"name":"Juan Perez","email":"jfarfan@tecsup.edu.pe","phone":"123456789"}'


curl -X POST http://localhost:9100/api/users \
-H "Content-Type: application/json" \
-d '{"name":"William Sulca","email":"sulca.03.1995@gmail.com","phone":"924242424"}'


curl -X POST http://localhost:9100/api/users \
-H "Content-Type: application/json" \
-d '{"name":"Juan Perez","email":"jfarfan@example.com","phone":"123456789"}'


###########################
curl -X POST http://localhost:9100/api/users -H "Content-Type: application/json" -d '{"name":"William2 Sulca2","email":"sulca.ao04@gmail.com","phone":"924242424"}'

curl -X POST http://localhost:9100/api/orders \
-H "Content-Type: application/json" \
-d '{"userId": 1,"date":"2025-03-26","ruc":"123456789", "address": "Av javier prado 210"}'



## Obtener todos los usuarios
curl -X GET http://localhost:9100/api/users

## Obtener un usuario específico
curl -X GET http://localhost:9100/api/users/1


## pruebas
curl -X GET http://localhost:9100/test
curl -X POST http://localhost:9100/api/users -H "Content-Type: application/json" -d '{"name":"Juan Perez","email":"juan@example.com","phone":"123456789"}'
curl -X POST http://localhost:9100/api/users -H "Content-Type: application/json" -d '{"name":"Ana Torres","email":"ana@example.com","phone":"123456789"}'
curl -X GET http://localhost:9100/api/users

