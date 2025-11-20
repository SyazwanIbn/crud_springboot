
## MyDevHub – CRUD Portfolio Project

This project is something I built to practice and showcase my backend skills. It focuses on real-world CRUD, proper relationships between entities, and clean API structure using Spring Boot.

## Tech Stack
I used:

- Java 17
- Spring Boot
- Spring Data JPA + Hibernate
- PostgreSQL
- Maven
- Git + GitHub


## Features

- Full CRUD for all entities
- Clear entity relationships:
    - One-to-One: User ↔ Profile
    - Many-to-One: Project → User
    - Many-to-Many: Project ↔ Technology

- Clean and simple REST API design
- Layered architecture (Controller → Service → Repository)
- DTOs for cleaner request/response handling


## API Endpoints

#### Get all items


| Entity    | Method   | Endpoints          | Description
| :-------- | :------- | :-------------     |:--------------|
| `Users`   | `POST`   |  /api/users        |Create user    |
| `Users`   | `GET`    |  /api/users        |Get all users |
| `Users`   | `GET`    |  /api/users/{id}   |Get user by id|
| `Users`   | `DELETE` |  /api/users/{id}   |Delete users  |
| `Profiles`| `POST`   |  /api/profiles/user/{userId}|Create profile for user |
| `Profiles`| `GET`   |  /api/profiles/user/{userId}|Get user profile  |
| `Profiles`| `PUT`   |  //api/profiles/{profileId} |Update profile |
| `Profiles`| `DELETE`   |  /api/profiles/{profileId}|Delete profile |
| `Projects`| `POST`   | /api/projects         |Create project  |
| `Projects`| `GET`   | /api/projects          |Get all projects |
| `Projects`| `GET`   |  /api/projects/{id}    |Get project by ID |
| `Projects`| `DELETE`   | /api/projects/{id}    |Delete project |
| `Technologies`   | `POST`   |  /api/technologies       |Create technology  |
| `Technologies`   | `GET`   |  /api/technologies      |Get all technologies  |
| `Technologies`   | `GET`   |  /api/technologies/{id}       |Get tech by ID  |
| `Technologies`   | `DELETE`   |  /api/technologies/{id}       |Delete tech  |

## Why I build this project

This is part of my journey to become a Java Backend Developer.
It shows that I understand:

- API design
- Entity relationships
- Clean code structure
- How to build a proper backend project




## Thank you


