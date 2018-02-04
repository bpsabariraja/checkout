# checkout
Checkout is a supermarket checkout component which act as a independent service which calculates the price of item. 

## Build
mvn clean install

## Tools/Frame work Used 
- Java 8
- Spring Boot
- H2 database,JDBC Template
- JUnit

## API

### checkout cart API
To calculate the check out price based on value in DB.

POST http://localhost:8082/checkout/cart

#### JSON for checkout cart
[
    {
        "upcCode": "M1232424232322",
        "quantity": 10
    },
    {
        "upcCode": "F1232424232322",
        "quantity": 5
    }
]
#####

### product API
To fetch all item available in DB

GET http://localhost:8082/product/itemdetails
