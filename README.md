Inventory Management System

A comprehensive inventory management system built using Spring Boot and MongoDB.

This application helps businesses manage their inventory by providing an intuitive interface for tracking products, stock levels, and orders. With the power of Spring Boot and MongoDB, this system is designed to be scalable, efficient, and easy to maintain.
Features:

    Product Management: Add, update, and delete products from the inventory.
    Stock Tracking: Keep track of stock levels and monitor when products are running low.
    Order Management: Create, view, and manage orders.
    MongoDB Integration: Persistent data storage using MongoDB for fast and scalable performance.
    RESTful API: A fully functional REST API to manage inventory data, easily integrable with other systems.

Technologies Used:

    Spring Boot: A framework for building robust and scalable backend applications.
    MongoDB: NoSQL database used to store inventory data.
    Spring Data MongoDB: Used for easy integration of MongoDB with Spring Boot.
    Spring Security (optional): For securing endpoints and managing user roles.

Setup and Installation:

    Clone the repository:

git clone https://github.com/your-username/inventory-management-system.git
cd inventory-management-system

Install Dependencies: This project uses Maven for dependency management. Run the following command to install the dependencies:

mvn clean install

Configure MongoDB:

    Make sure you have MongoDB installed and running locally or use a MongoDB Atlas cloud instance.
    Update the application.properties file to include your MongoDB connection details.

Run the Application: To start the application, run the following command:

    mvn spring-boot:run

    The application will run on http://localhost:8080.

Endpoints:

    GET /api/products: Get all products in the inventory.
    POST /api/products: Add a new product to the inventory.
    PUT /api/products/{id}: Update an existing product's details.
    DELETE /api/products/{id}: Delete a product from the inventory.

Contributing:

Feel free to open issues or submit pull requests if you'd like to contribute to the development of this inventory management system.
License:

This project is licensed under the MIT License - see the LICENSE file for details.



##screenshots

| Register View| LogIn View |
|:-:|:-:|
|![ss2](https://github.com/user-attachments/assets/b5a28a73-be36-4cd3-bb57-99425a91a443)|![ss1](https://github.com/user-attachments/assets/a830ae1c-db24-48c0-82d6-cb3f0819243f)|


| Dashboard | Product List View |
|:-:|:-:|
|![ss3](https://github.com/user-attachments/assets/0b716775-bb51-41b9-ab3e-7bc6477d5772)|![ss4](https://github.com/user-attachments/assets/017ced56-c154-4b5c-acb7-e0a6ab406de5)|

| Add Products View | Edit Products View |
|:-:|:-:|
|![556](https://github.com/user-attachments/assets/cd209a25-8fd1-43f2-addd-4f62e2694951)|![ss5](https://github.com/user-attachments/assets/cc2d1db5-0bfb-496b-8ae4-6ee09fdadd5c)|

 






