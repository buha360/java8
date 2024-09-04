# Java DRY Example in Docker

This project demonstrates a simple Java 8 application following the DRY (Don't Repeat Yourself) principle (also recreated it with other principles like KISS, YAGNI & SOLID), and it is containerized using Docker.

## Prerequisites

- Docker must be installed on your machine.

## How to Build and Run

1. **Clone the Repository**

   First, clone this repository to your local machine:

   ```bash
   git clone https://github.com/buha360/java8.git

2. **Navigate to *src***
   ```bash
   cd src

3. **Build the Docker Image**
   ```bash
   docker build -t java-dry-app .
   
4. **Run the Docker Container**
   ```bash
   docker run --rm java-dry-app
