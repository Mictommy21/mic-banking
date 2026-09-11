\# MIC Banking API



A secure RESTful banking backend application built with \*\*Spring Boot\*\*, \*\*Spring Security\*\*, \*\*JWT\*\*, \*\*PostgreSQL\*\*, and \*\*Java\*\*.



The project provides APIs for customer account management, authentication, banking transactions, money transfers, balance enquiries, and bank statement generation.



\## Technologies Used



\* Java

\* Spring Boot

\* Spring Security

\* JWT Authentication

\* Spring Data JPA

\* Hibernate

\* PostgreSQL

\* Maven

\* Lombok

\* OpenAPI / Swagger

\* iText PDF

\* Java Mail



\## Features



\* Customer account creation

\* JWT-based authentication

\* Secure password encryption

\* Balance enquiry

\* Name enquiry

\* Credit account

\* Debit account

\* Money transfer

\* Transaction history

\* Bank statement PDF generation

\* Email notifications

\* PostgreSQL database integration

\* RESTful API architecture

\* Swagger/OpenAPI documentation



\## Project Structure



```text

src/main/java/com/baraka/mic\\\_banking

│

├── config

│   ├── JwtAuthenticationEntryPoint

│   ├── JwtAuthenticationFilter

│   ├── JwtTokenProvider

│   └── SecurityConfig

│

├── controller

│   ├── TransactionController

│   └── UserController

│

├── dto

│   ├── AccountInfo

│   ├── BankResponse

│   ├── CreditDebitRequest

│   ├── EmailDetails

│   ├── EnquiryRequest

│   ├── LoginDto

│   ├── TransactionDto

│   ├── TransferRequest

│   └── UserRequest

│

├── entity

│   ├── Role

│   ├── Transaction

│   └── User

│

├── repository

│   ├── TransactionRepository

│   └── UserRepository

│

├── service

│   ├── BankStatement

│   ├── CustomerUserDetailsService

│   ├── EmailService

│   ├── EmailServiceImpl

│   ├── TransactionImp

│   ├── TransactionService

│   ├── UserService

│   └── UserServiceImpl

│

└── utils

\&#x20;   ├── AccountUtils

\&#x20;   └── SecurityProcess

```



\## Authentication



The application uses \*\*Spring Security and JWT\*\* for authentication.



The authentication flow is:



```text

Client

\&#x20;  ↓

Login

\&#x20;  ↓

Authentication

\&#x20;  ↓

JWT Token Generated

\&#x20;  ↓

Client Sends JWT

\&#x20;  ↓

JwtAuthenticationFilter

\&#x20;  ↓

SecurityContext

\&#x20;  ↓

Protected API

```



Protected endpoints require a valid JWT token:



```http

Authorization: Bearer <your-token>

```



\## Database



The application uses PostgreSQL.



Create a database:



```sql

CREATE DATABASE micbanking;

```



Then configure your local database credentials in:



```text

application.properties

```



\*\*Do not upload your real `application.properties` to GitHub.\*\*



\## Configuration



Create:



```text

src/main/resources/application.properties

```



and configure your local environment.



Example:



```properties

spring.application.name=mic\\\_banking

server.port=8086



spring.datasource.url=jdbc:postgresql://localhost:5432/micbanking

spring.datasource.username=postgres

spring.datasource.password=${DB\\\_PASSWORD}



app.jwt-secret=${JWT\\\_SECRET}

app.jwt-expiration=86400000

```



For email configuration, provide your own SMTP credentials using environment variables.



\## Running the Application



Clone the repository:



```bash

git clone https://github.com/Mictommy21/mic-banking.git

```



Navigate into the project:



```bash

cd mic-banking

```



Run using Maven Wrapper:



\### Windows



```powershell

.\\\\mvnw.cmd spring-boot:run

```



\### Linux / macOS



```bash

./mvnw spring-boot:run

```



The application runs on:



```text

http://localhost:8086

```



\## API Documentation



The project uses OpenAPI / Swagger for API documentation.



After starting the application, open:



```text

http://localhost:8086/swagger-ui/index.html

```



Swagger allows you to explore and test the available REST APIs.



\## Main API Endpoints



\### User / Account



```http

POST /api/user/createAccount

POST /api/user/balanceEnquiry

POST /api/user/nameEnquiry

POST /api/user/credit

POST /api/user/debit

POST /api/user/transfer

```



\### Authentication



Authentication endpoints generate JWT tokens that are then used to access protected resources.



\## Banking Operations



The application supports:



\### Credit



Adds money to a customer's account.



\### Debit



Withdraws money from a customer's account.



\### Transfer



Transfers money from one account to another.



```text

Source Account

\&#x20;     ↓

\&#x20;  Transfer

\&#x20;     ↓

Destination Account

```



\### Balance Enquiry



Returns the current account balance.



\### Name Enquiry



Retrieves customer information using the account number.



\## Bank Statement



The application can generate customer bank statements as PDF documents using iText.



The statement contains transaction information such as:



\* Transaction ID

\* Account number

\* Transaction type

\* Amount

\* Status

\* Transaction date



\## Security



Sensitive information such as:



\* Database passwords

\* JWT secrets

\* Email passwords

\* SMTP credentials



must never be committed to GitHub.



The project uses environment variables for sensitive configuration.



\## Testing



Run tests using:



```powershell

.\\\\mvnw.cmd test

```



\## Future Improvements



Possible future improvements include:



\* Refresh token implementation

\* Role-based authorization

\* Admin dashboard

\* Transaction pagination

\* Improved exception handling

\* Docker support

\* Automated CI/CD

\* Unit and integration test expansion

\* Frontend/mobile application

\* Production deployment



\## Author



\*\*BARAKA S KANDORE\*\*



GitHub:



https://github.com/Mictommy21



\## License



This project is developed for educational and portfolio purposes.



