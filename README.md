# Library

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Documentation](#Documentation)
* [Endpoints](#endpoints)

## Introduction
Library is a book management application. Currently, the application stores data relating to books and authors. It also allows you to generate a report - a list of books.
Ultimately, the application will also contain the database of library users (members), while the database itself will be MySQL.

#### The application is under development.

## Technologies 
* Java 13
* Spring Boot version 2.4.2
* Lombok 
* MySQL
* Swagger 2
* Spring Security
* Apache POI OOXML

## Documentation

Go to http://localhost:8080/swagger-ui.html#/ to see API documentation 

## Endpoints
* GET - export to excel all books "http=//localhost:8080/api/books/export/excel"
* GET - get all books "http=//localhost:8080/api/books"
* GET - get book by id "http=//localhost:8080/api/books/{id}"
* POST - add new book "http=//localhost:8080/api/book/addNewBook"
* PUT - update book "http=//localhost:8080/api/books/update/{id}"
* DELETE - delete book "http=//localhost:8080/api/books/delete/{id}"


