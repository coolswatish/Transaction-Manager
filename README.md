# Transaction manager

Here I have implemented a REST API based in-memory transaction manager.

Technologies used:
- Java 8
- Springboot framework

## How do I run it?
From the root directory you can issue maven install command
> mvn clean install

This will download required dependencies and generate a file **transaction-manager.jar** in **target** directory. 
We can then simply run it using
> java jar target/transaction-manager.jar

This will start the server on port 3000 and now we can issue our queries.

## Sample queries
- Insert a new transaction
> PUT http://localhost:3000/transactionservice/transaction/1 
> Request body:
> {
> 	"type": "bikes",
> 	 "amount": 2000
> }

- Get transaction details
>GET http://localhost:3000/transactionservice/transaction/1 
> Response
> {
>     "data": {
> "type": "bikes",
> "amount": 2000.0
> }
> }

Get transactions of a particular type
> GET http://localhost:3000/transactionservice/types/bikes
> {
> "data": [
> 1
> ]
> }

Get sum of transactions
> GET http://localhost:3000/transactionservice/sum/1
> Response
> {
> "data": 3000.0
> }

