# Wager API Rest Services 

## Contents

- [Introduction](#Introduction)
  * [Overview](#Overview)
- [Architecture](#Architecture)
- [Database schema](#Database-schema)
- [Usage](#usage)
  * [API Endpoints](#API)
    + [`resource/transaction/createbet`](#createbet)
    + [`resource/bet/investment/bettypes`](#bettypes)
    + [`resource/bet/investment/customer`](#customer)
    + [`resource/bet/countbettype`](#countbettype)
    + [`resource/bet/countbetperhour`](#countbetperhour)
    + [`resource/bet/types`](#types)
- [Authentication & Authorization](#Authentication)
- [Installation](#Installation)
- [Setup and Build](#Setup)
- [Testing](#testing)
  * [Unit Tests](#unit-tests)
  * [End-to-end Tests](#end-to-end-tests)
- [Troubleshooting](#troubleshooting)
  * [Logging](#Logging)
  * [Exception Handling](#Exception)
  * [Environment Variables](#environment-variables)


## Introduction

Wager API is the restful web services that is built with Jersey, Restassured, Log4J, JUnit to deliver endpoints to carryout betting.

### Overview

Wager API gives endpoints that let clients to bet on their choice of horses. There are different types of bets available – WIN, PLACE, TRIFECTA.

* `WIN` - Client can bet on a horse who could possibly win.
* `PLACE` - Client choose the place of a horse and bet on it.
* `TRIFECTA` - Client needs to choose 3 places in a race for 3 different horses.

Also provides end points that generate reports on,
 
*   Total investment per bet type
*   Total investment per Client
*   Total bets sold per bet type
*   Total number of bets sold per hour

## Architecture

![alt text](https://github.com/dixitgangaiah/wagerapi/blob/master/architecture.PNG)

## Database schema

```
 _______________
|               |
| Customer (ID) |
|_______________|
                        _________________
 _______________       |    Bet (ID)     |
|               |      |    Customer ID  |     
| Bet Type (ID) |      |    Bet Type ID  |
|_______________|      |    Prop ID      |
                       |_________________|
 _______________  
|               |
| Prop (ID)     |
|_______________|

```

## Authentication & Authorization

Authenticated user provided with authorization token. This token can be used for further API calls.

## Installation

### Dependencies

Before you get started, it's expected that your local development environment has been set up correctly. This includes

* PostgreSQL Version 9.4
* Apache Tomcat 8.x and above
* Eclipse
* Postman

## Setup and Build

To install, simply do the following

* Clone git repository
```
git clone https://github.com/dixitgangaiah/wagerapi.git
```
* Go to Eclipse -> import -> existing Maven project -> select wagerapi.
* Run the database script in PostgreSQL console - `DatabaseTablesCreation.sql`
* In Eclipse, right click on project -> choose Run As -> Run on Server -> select Tomcat -> select wagerapi -> Finish

The app will open in the browser at `http://localhost:8080`

## Usage

URI path                                                 | HTTP methods | Allowed values
-------------------------------------------------------- | ------------ | ----------------------------------
**_/resource/transaction/createbet_**                    | POST         | Bet transaction JSON Payload
**_/resource/bet/investment/bettypes_**                  | GET          | 
**_/resource/bet/investment/customer_**                  | GET          | 
**_/resource/bet/countbettype_**                         | GET          | 
**_/resource/bet/countbetperhour_**                      | GET          | 
**_/resource/bet/types_**                                | GET          | 

Sample user credentials following,
```
Username: user
Password: password
```

### Sample Response

Request - `curl -X GET http://localhost:8080/wagerapi/resource/bet/investment/bettypes -H 'authorization: Basic dXNlcjpwYXNzd29yZA==' -H 'cache-control: no-cache'`
Response - `[{"betId":1,"betName":"WIN","betInvestment":125},{"betId":3,"betName":"TRIFECTA","betInvestment":135},{"betId":2,"betName":"PLACE","betInvestment":125}]`

Request - `curl -X GET http://localhost:8080/wagerapi/resource/bet/countbettype -H 'authorization: Basic dXNlcjpwYXNzd29yZA==' -H 'cache-control: no-cache'`
Response - `[{"betId":1,"betName":"WIN","numberofbetsold":3},{"betId":2,"betName":"PLACE","numberofbetsold":3},{"betId":3,"betName":"TRIFECTA","numberofbetsold":4}]`

## Testing

In Eclipse, navigate to `src/main/java/org/com/au/wagerapi/test/`, right click -> run JUnit tests.

Test cases,

* Authentication
  * testbasicAuthValidPassword_200
  * testbasicAuthInValidusername_401
  * testbasicAuthInValidPassword_401
  * testValidToken_200
  * testInValidToken_401
  * testInvalidContentType_500
* resource/bet/investment/bettypes
  * testAllInvestmentByBettypes
  
