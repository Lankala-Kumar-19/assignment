\# Assignment - Full Stack Application Backend



\## Project Overview



This is the backend Full Stack Development Task.  

The application provides APIs to manage Projects, Clients, Contact Forms, and Newsletter subscriptions.



It includes features such as creating, updating, retrieving, and deleting data related to projects and clients, handling user contact form submissions, and managing newsletter subscriptions.



---



\## Technologies Used



\- \*\*Java 17\*\* with Spring Boot  

\- \*\*MongoDB Atlas\*\* (Cloud NoSQL database)  

\- \*\*Spring Data MongoDB\*\* for database interaction  

\- \*\*Lombok\*\* for boilerplate code reduction  

\- \*\*Maven\*\* for build and dependency management  

\- \*\*Docker\*\* for containerization  

\- \*\*Render.com\*\* for cloud deployment  

\- \*\*Jakarta Validation\*\* for request validation  



---



\## Approach



\- \*\*Clean Architecture\*\*: Separation of concerns between controllers, services, repositories, and DTOs.  

\- \*\*DTO Pattern\*\*: Use of Request and Response DTOs to control input and output data formats.  

\- \*\*Custom Exception Handling\*\*: Global exception handler to return clean error responses.  

\- \*\*Pagination\*\*: Implemented pageable retrieval for listing Projects, Clients, Contact Forms, and Newsletters.  

\- \*\*Case-insensitive uniqueness checks\*\*: For Project and Client names to avoid duplicates.  

\- \*\*Environment Config\*\*: Externalized MongoDB URI and server port using environment variables for easy deployment flexibility.  

\- \*\*Dockerized Deployment\*\*: Created a Dockerfile to containerize the Spring Boot application for cloud hosting.  



---



\## API Endpoints



\### Projects (`/projects`)



\- `POST /projects` - Create a new project  

\- `GET /projects` - Get paginated list of projects  

\- `GET /projects/id/{id}` - Get project by ID  

\- `GET /projects/name/{name}` - Get project by name  

\- `PUT /projects/update/{id}` - Update project by ID  

\- `DELETE /projects/delete/{id}` - Delete project by ID  

\- `DELETE /projects/delete/{name}` - Delete project by name  



\### Clients (`/clients`)



\- `POST /clients` - Create a new client  

\- `GET /clients` - Get paginated list of clients  

\- `GET /clients/by-id/{id}` - Get client by ID  

\- `GET /clients/by-name/{name}` - Get client by name  

\- `PUT /clients/update/{id}` - Update client by ID  

\- `DELETE /clients/delete/by-id/{id}` - Delete client by ID  

\- `DELETE /clients/delete/by-name/{name}` - Delete client by name  



\### Contact Forms (`/contact-forms`)



\- `POST /contact-forms` - Submit contact form  

\- `GET /contact-forms` - Get paginated list of contact form submissions  

\- `GET /contact-forms/{id}` - Get contact form submission by ID  

\- `DELETE /contact-forms/{id}` - Delete contact form submission by ID  



\### Newsletters (`/newsletters`)



\- `POST /newsletters/subscribe` - Subscribe with email  

\- `GET /newsletters` - Get paginated list of newsletter subscriptions  

\- `DELETE /newsletters?email={email}` - Delete subscription by email  



---



\## Running Locally



\### Prerequisites



\- Java 17+ installed  

\- Maven installed  

\- MongoDB Atlas account (or local MongoDB instance)  

\- Docker (optional, for containerized run)  



\### Steps



1\. Clone the repository:



```bash

git clone https://github.com/Lankala-Kumar-19/assignment.git

cd assignment/assignment


Configure environment variables:

spring.data.mongodb.uri=<your-mongodb-connection-string>

spring.data.mongodb.database=assignment

server.port=8080


Alternatively, set environment variables:



MONGO\_URI=your MongoDB URI

PORT=your desired port (default 8080)

Build the project:



mvn clean package





Run locally:



java -jar target/assignment-0.0.1-SNAPSHOT.jar

Access API:



Open http://localhost:8080 and use the endpoints listed above.


This project is deployed on Render.com using Docker container with environment variables for MongoDB URI and port configuration.



