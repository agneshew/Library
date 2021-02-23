# Library

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Setup](#setup)
* [Endpoints](#endpoints)

## Introduction
Library for a data management application containing the books that are in the library. Additionally, the application includes a user database. The combination of these two databases makes it possible to manage the borrowings of books.

#### The application is under development.

## Technologies
Backend: 
* Java 13
* Spring Boot version 2.4.2
* Lombok 
* H2 database

## Setup
When you run project, go to http=//localhost:8080/h2-console

## Endpoints
* get all books "http=//localhost:8080/api/books"
* get book by id "http=//localhost:8080/api/books/{id}"
* add new book "http=//localhost:8080/api/book/newbook"
* update book "http=//localhost:8080/api/books/{id}"
* delete book "http=//localhost:8080/api/books/{id}"


