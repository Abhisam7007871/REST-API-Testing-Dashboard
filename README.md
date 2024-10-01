# REST API Test Dashboard Application

This REST API Test Dashboard application allows users to easily test and manage RESTful APIs. It offers a user-friendly interface similar to tools like Postman, enabling users to configure various HTTP methods, set headers, input request bodies, and manage authentication.

## Features

- **HTTP Methods Supported:** 
  - GET
  - POST
  - PUT
  - DELETE
  
- **Customizable Headers and Body:** 
  - Dynamically add headers and body content for API requests.

- **Authentication:**
  - Support for Basic Authentication (username/password) for API calls.

- **Response Preview:**
  - Displays server responses clearly in an expanded textarea for easy reading.

- **MySQL Integration:**
  - Every API request made (POST, PUT, DELETE, GET) is logged and saved into a MySQL database for future reference.

- **User-Friendly Interface:**
  - Designed for ease of use, allowing users to switch between request types and view results effortlessly.

## Technologies Used

- **Backend:** Java (Spring Boot)
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Dependencies:** Maven

## Installation and Setup

### Prerequisites

- Java 17 or higher
- MySQL installed and running
- Maven installed
- A working internet connection for dependency downloads

### Steps to Run the Project

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
