# Discount Calculator
## Overview

This project implements a discount system for a retail store, as specified in Exercise 1 of the technical assessment for a technical lead role. It focuses on an object-oriented approach to calculate the net payable amount on a bill with various discounts applied based on user criteria. The project emphasizes clean, maintainable code and demonstrates best practices in software development.

## Features
- Calculation of percentage-based discounts for employees, affiliates, and loyal customers.
- Additional discounts for bulk purchases.
- Exclusion of groceries from percentage-based discounts.
- Implementation of a flexible discount policy system to easily extend or modify rules.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
- Java JDK 17 or later
- Maven 3.8.1 or later

### Installing
1. Clone the repository

`git clone git@github.com:appiersign/discount-calculator.git`

2. Navigate to the project directory:

`cd discount-calculator`

3. Install dependencies and compile the code

`mvn install clean package`

4. The above step runs the unit tests, however, you can run the test by executing:

`mvn test`

5. To run the build, execute 

`java -jar target/app.jar`

## Usage

The main functionality is encapsulated in the `DiscountService` class, which calculates the net payable amount after 
applying relevant discounts. See the `Main` class for the usage.

## Design
The application is designed with an object-oriented approach, adhering to principles of clean architecture and SOLID principles. 
For a detailed overview of the system's design, refer to the [UML Diagram](https://ibb.co/V2NGKPY).