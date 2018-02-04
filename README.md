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

#### JSON input sample for checkout cart
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

### Checkout price cart API
To calculate the price without DB. The price details need to passed as input with special price for individual item.
Special price calculation logic applied within the service.
######
POST http://localhost:8082/checkout/pricedcart
#### JSON input sample for pricecart
[
    {
        "upcCode": "M1232424232322",
        "quantity": 10,
        "unitPrice":10,
       "specialPriceList": [
            {
                "quantity": 3,
                "price": 20
            },
            {
                "quantity": 4,
                "price": 25
            },
            {
                "quantity": 6,
                "price": 30
            }
        ]
    },
    {
        "upcCode": "F1232424232322",
        "quantity": 5,
         "unitPrice":10,
         "specialPriceList": []
    }
 ]
 
