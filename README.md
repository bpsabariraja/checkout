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
To checkout the cart need to call the following service. It will calculate the price based on Database.
### checkout cart API
POST localhost:8082/checkout/cart
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
