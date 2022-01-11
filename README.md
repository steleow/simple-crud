# Getting Started

### Please follow the steps:

Start the mockup API server
```sh  
npm install -g json-server
json-server --watch db.json
```  

Start springboot application
```sh
./mvnw spring-boot:run
```

### Available APIs
- get all students
```bash
curl --request GET 'http://localhost:8080/students'
```
- get student by id
```bash
curl --request GET 'http://localhost:8080/students/1'
```
- create new student
```bash
curl --request POST 'http://localhost:8080/students'
--header 'Content-Type: application/json'
-d '{
      "id": 6,
      "name": "Leon Leong",
      "age": 17,
      "address": {
        "street": "Taman Bukit Bendera",
        "city": "Mentakab",
        "postcode": "28400"
      },
      "course": "Accountant"
    }'
```
- update existing student by id
```bash
curl --request PUT 'http://localhost:8080/students/6'
--header 'Content-Type: application/json'
-d '{
      "id": 6,
      "name": "Leon Leong cin cin",
      "age": 17,
      "address": {
        "street": "Taman Bukit Bendera",
        "city": "Mentakab",
        "postcode": "28400"
      },
      "course": "Accountant"
    }'
```
- delete student by id
```bash
curl --request DELETE 'http://localhost:8080/students/6'
```
