#!/bin/bash
# This is (should be) an executable script (bash script)
# to test some database functionality

# (Re)create database 
#curl -v http://localhost:8080/ws4/rest/db

# Options (used by CORS preflight)
curl -v -X OPTIONS http://localhost:8080/

# Get all Authors 
curl -v -H "Accept: application/json" http://localhost:8080/ws4/rest/author 

# Get single Author
curl -v -H "Accept: application/json" http://localhost:8080/ws4/rest/author/FF

# Get primitive type (number of authors)
curl -v -H "Accept: application/json" http://localhost:8080/ws4/rest/author/count

# Create new (NOTE: exception if run more times ... use delete) Using form parameters
curl -v POST  http://localhost:8080/ws4/rest/author --data "id=QQ&firstName=Qbert&lastName=Qson&email=qson@mail"

# Create new (NOTE: exception if run more times ... use delete) Using JSON
curl -v -H "Content-Type: application/json" POST http://localhost:8080/ws4/rest/author --data '{"id":"XX", "firstName": "Xbert", "lastName": "Xson", "email":"xson@mail", "address" : null}'

# Update an Author
curl -v PUT http://localhost:8080/ws4/rest/author/XX --data '{"id":"YY", "firstName": "NEWbert", "lastName": "NEWson", "email":"NEW@mail, "address" : null}'

# Delete (last part of URL is id)
curl -v -X DELETE http://localhost:8080/ws4/rest/author/XX 

# Testing CORS use other origin 
curl -v -H "Origin: http://www.example.com" -H "Accept: application/json" http://localhost:8080/ws4/rest/author

# Create new (NOTE: exception if run more times ... use delete) Using JSON
curl -v -H "Content-Type: application/json" POST http://localhost:8080/ws4/rest/book --data '{"isbn":"TT567", "title":"FressiasSambalife", "genre":null, "price":5.50}'

#Update a book
curl -v -H "Content-Type: application/json" -X PUT http://localhost:8080/ws4/rest/book/TT567 --data '{"isbn":"TT567", "title":"FressiasReallyHardSambaLife", "genre":null, "price":6.50}'


# Delete
curl -v -X DELETE http://localhost:8080/ws4/rest/book/TT567