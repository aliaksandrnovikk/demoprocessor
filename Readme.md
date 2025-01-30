# Service Shuffle & Logger Project

This project consists of two microservices:
1. **Service Shuffle**: Generates a shuffled array from numbers 1 to a specified integer (`n`).
2. **Service Log**: Logs the requests made to the shuffle service.

### Features:
- **Service Shuffle**:
    - Generates a shuffled array of integers from 1 to the provided number (`n`).
    - Provides a **POST API** to get the shuffled array.

- **Service Log**:
    - Logs each request received by the shuffle service.
    - Logs the shuffle result for monitoring purposes.

---

## Technologies Used:
- **Spring Boot** (for building microservices)
- **Java 17** (minimum)
- **Maven** (for dependency management)
- **Spring Web** (for REST APIs)

---

## Setup

### Prerequisites:
- **Java 17** or later.
- **Maven** for dependency management.
- **Postman** or any other API testing tool for making requests.

### Clone the repository:

```bash
git clone https://github.com/aliaksandrnovikk/demoprocessor.git
```

### Build project:
```bash

cd demo-processor
mvn clean install
```

### Run services:
```bash

cd service-log
mvn spring-boot:run 

cd service-shuffle
mvn spring-boot:run 

```
### Execute curl request for testing purposes:
```bash

curl -X POST http://localhost:8080/api/shuffle -H "Content-Type: application/json" -d '{"n": 15}'

```
