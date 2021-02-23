# Library

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Setup](#setup)
* [Documentation](#Documentation)
* [Endpoints](#endpoints)

## Introduction
Library for a data management application containing the books that are in the library. Additionally, the application includes a user database. The combination of these two databases makes it possible to manage the borrowings of books.

#### The application is under development.

## Technologies 
* Java 13
* Spring Boot version 2.4.2
* Lombok 
* H2 database
* Swagger 2

## Setup
Go to http=//localhost:8080/h2-console to see database

## Documentation

Go to http://localhost:8080/swagger-ui.html#/ to see API documentation 

## Endpoints
* GET - get all books "http=//localhost:8080/api/books"
* GET - get book by id "http=//localhost:8080/api/books/{id}"
* POST - add new book "http=//localhost:8080/api/book/newbook"
* PUT - update book "http=//localhost:8080/api/books/{id}"
* DELETE - delete book "http=//localhost:8080/api/books/{id}"


