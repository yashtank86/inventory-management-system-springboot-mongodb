# 🧩 Inventory Management System (Spring Boot + MongoDB + JWT)

A comprehensive **Inventory Management System** built using **Java Spring Boot**, **MongoDB**, and **JWT Authentication**.  
This project helps businesses efficiently manage **products, stock levels, and orders** through a secure and scalable backend.

### 🚀 Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** MongoDB
- **Security:** JWT Authentication
- **API Type:** RESTful APIs

### 🔑 Features
- Add, update, and delete products
- Track stock quantity and orders
- User authentication with JWT
- Scalable and easily customizable architecture

Setup and Installation:

    Clone the repository:
    git clone https://github.com/yashtank86/inventory-management-software.git

Install Dependencies:

    This project uses Maven for dependency management. Run the following command to install the dependencies:
    mvn clean install

Configure MongoDB:

    Make sure you have MongoDB installed and running locally or use a MongoDB Atlas cloud instance.
    Update the application.properties file to include your MongoDB connection details.
    
Configure JWT Secret:

    Add your JWT secret key in the application.properties or application.yml file for secure token generation.
    Example:
    jwt.secret=your-secret-key
    jwt.expiration=3600    

Run the Application: To start the application, run the following command:

    mvn spring-boot:run

    The application will run on http://localhost:8086

Endpoints:

    GET /user/productList: Get all products in the inventory.
    POST /user/addProduct: Add a new product to the inventory.
    PUT /user/editProduct/{productId}: Update an existing product's details.
    [pending] DELETE /api/products/{id}: Delete a product from the inventory.

Contributing:

Feel free to open issues or submit pull requests if you'd like to contribute to the development of this inventory management software.
License:

This project is licensed under the MIT License - see the LICENSE file for details.



##screenshots:

| Register View| LogIn View |
|:-:|:-:|
|![ss2](https://github.com/user-attachments/assets/b5a28a73-be36-4cd3-bb57-99425a91a443)|![ss1](https://github.com/user-attachments/assets/a830ae1c-db24-48c0-82d6-cb3f0819243f)|


| Dashboard | Product List View |
|:-:|:-:|
|![ss3](https://github.com/user-attachments/assets/0b716775-bb51-41b9-ab3e-7bc6477d5772)|![ss4](https://github.com/user-attachments/assets/017ced56-c154-4b5c-acb7-e0a6ab406de5)|

| Add Products View | Edit Products View |
|:-:|:-:|
|![556](https://github.com/user-attachments/assets/cd209a25-8fd1-43f2-addd-4f62e2694951)|![ss5](https://github.com/user-attachments/assets/cc2d1db5-0bfb-496b-8ae4-6ee09fdadd5c)|

 






