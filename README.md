# Pollution_Service

To run :
mvn clean install
docker build . -t pollution
docker run -p 9000:9000 pollution

Check for health
GET http://localhost:9000/actuator/health

Get pollution detail for your city
GET http://localhost:9000/pollution
