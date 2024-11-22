Computer Management System - Java JSP Servlet
Overview
This is a simple Computer Management System built using Java, JSP (Java Server Pages), Servlets, and MySQL for database management. The application allows users to Create, Read, Update, and Delete computer records. It also includes features for searching and filtering records based on certain criteria and displays notifications (thông báo) for actions like successful operations or errors.

Features:
CRUD Operations: Manage computer data (Create, Read, Update, Delete)
Search & Filter: Search and filter computer records based on different attributes
Notifications: Display success or error messages after each action
Technologies Used
Java Servlet: For backend logic and handling HTTP requests
JSP (Java Server Pages): For rendering dynamic content on the front-end
MySQL: For storing computer records in a database
HTML/CSS/JS: For front-end design and interactivity
Application Functionality
1. Create Computer (Thêm Máy Tính)
Users can add new computer records to the system by entering details such as:

Computer Name (Tên Máy Tính)
Manufacturer (Hãng Sản Xuất)
Quantity (Số Lượng)
Price (Đơn Giá)
After submitting the form, the system will insert the new record into the database and display a notification confirming the action.

2. Read/View Computers (Danh Sách Máy Tính)
All computer records are displayed in a table format on the main page. Each record shows the following:

Computer Name
Manufacturer
Quantity
Price
There is also a Search & Filter option where users can search for a specific computer by its name or manufacturer.

3. Update Computer (Cập Nhật Máy Tính)
Users can update existing computer records. To update, click on the Edit button next to the desired record. A form will be shown with pre-filled data, allowing the user to modify the values. After updating, the record is saved back to the database, and a success notification is shown.

4. Delete Computer (Xóa Máy Tính)
Users can delete a computer record by clicking the Delete button next to the corresponding record. A confirmation message is displayed, and after deletion, the list is refreshed, showing the updated data.

5. Search and Filter
A search bar is available for users to filter the computer records based on the computer name or manufacturer. When the user types in the search field, the results are dynamically updated to show only the records that match the search query.

6. Notifications (Thông Báo)
Success Notification: After performing actions like adding, updating, or deleting a computer, the user will see a success message.
Error Notification: If there is an error (e.g., invalid input or database issue), an error message will be shown to the user.
Database Schema
The application uses a MySQL database to store computer records. The schema for the MayTinh table is as follows:

sql
Sao chép mã
CREATE TABLE MayTinh (
    MaMayTinh INT AUTO_INCREMENT PRIMARY KEY,
    TenMayTinh VARCHAR(255),
    HangSanXuat VARCHAR(255),
    SoLuong INT,
    DonGia DOUBLE
);
How to Run the Application
Prerequisites:
Java: JDK 8 or above
Apache Tomcat: Servlet container to deploy the application
MySQL Database: Running MySQL instance
IDE: Any IDE that supports Java (E.g., IntelliJ IDEA, Eclipse)
Setup Steps:
Set Up MySQL Database:

Create a database in MySQL:
sql
Sao chép mã
CREATE DATABASE computer_management;
Create the MayTinh table using the provided schema.
Clone the Repository:

Clone or download the project repository to your local machine.
Configure Database Connection:

Update the database connection details in the ComputerDAO class (getConnection method) to match your MySQL database settings.
Deploy the Application:

Deploy the application on an Apache Tomcat server by copying the WAR file to the webapps directory or using an IDE to run it locally.
Access the Application:

Open a browser and navigate to http://localhost:8080/your-app-name to access the application.
Testing the Application:
Add a New Computer: Navigate to the add computer form and submit the details.
View All Computers: The list of computers will be displayed on the homepage.
Search/Filter: Enter a search term and see the filtered results.
Update or Delete: Use the Edit/Delete buttons on each row to modify or remove records.
Example Screenshots
Computer List Page:

Add Computer Form:

Edit Computer Form:

Troubleshooting
Database Connection Error: Ensure that MySQL is running and the connection details in the ComputerDAO are correct.
404 Error: If you encounter a 404 error, make sure the URL path is correct and that the app has been successfully deployed in Tomcat.
Search Not Working: Double-check the filter logic to ensure that the search is properly implemented for the relevant fields.
Contributing
If you would like to contribute to this project, feel free to fork the repository, make improvements, and submit pull requests. Any feedback or suggestions are also welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.
