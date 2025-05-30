# Redis CRUD Demo

This project is a demonstration of CRUD (Create, Read, Update, Delete) operations using Spring Boot and Redis.

## How to Run

### Prerequisites
*   Java Development Kit (JDK) 21 or higher
*   Apache Maven

### Steps
1.  **Clone the repository:**
    ```bash
    git clone https://github.com/kabragaurav/redis.git
    cd redis
    ```
2.  **Build the project:**
    ```bash
    mvn clean install
    ```
3.  **Run the application:**
    ```bash
    java -jar target/redis-0.0.1-SNAPSHOT.jar
    ```
    The application will start on port 8080.

## API Endpoints

The application provides the following RESTful endpoints for managing users:

*   **Create a new user:**
    *   `POST /users`
    *   Request body:
        ```json
        {
          "name": "John Doe",
          "email": "john.doe@example.com"
        }
        ```
    *   Example using `curl`:
        ```bash
        curl -X POST -H "Content-Type: application/json" -d '{
          "name": "John Doe",
          "email": "john.doe@example.com"
        }' http://localhost:8080/users
        ```
*   **Get a user by ID:**
    *   `GET /users/{id}`
    *   Example using `curl`:
        ```bash
        curl http://localhost:8080/users/your_user_id
        ```
*   **Get all users:**
    *   `GET /users`
    *   Example using `curl`:
        ```bash
        curl http://localhost:8080/users
        ```
*   **Update an existing user:**
    *   `PUT /users/{id}`
    *   Request body:
        ```json
        {
          "name": "John Doe",
          "email": "john.doe.updated@example.com"
        }
        ```
    *   Example using `curl`:
        ```bash
        curl -X PUT -H "Content-Type: application/json" -d '{
          "name": "John Doe",
          "email": "john.doe.updated@example.com"
        }' http://localhost:8080/users/your_user_id
        ```
*   **Delete a user by ID:**
    *   `DELETE /users/{id}`
    *   Example using `curl`:
        ```bash
        curl -X DELETE http://localhost:8080/users/your_user_id
        ```
*   **Delete multiple users by IDs:**
    *   `DELETE /users?ids=<id1>,<id2>`
    *   Example using `curl`:
        ```bash
        curl -X DELETE http://localhost:8080/users?ids=id1,id2
        ```

## Demo Video

Watch a demo of the project here: [https://youtu.be/ro9diCZWZ7s](https://youtu.be/ro9diCZWZ7s)
