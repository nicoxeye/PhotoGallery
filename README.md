- [Photo Gallery](#photo-gallery)
  * [Dependencies](#dependencies)
  * [App Preview](#app-preview)
  * [Dev Log](#dev-log)
  * [Project Set Up](#project-set-up)
  * [Default data](#default-data)
  * [Helpful Things](#helpful-things)
- [Project File Structure](#project-file-structure)


# Photo Gallery
A web app for a photographer to make photos accesible to users online. 
Users can view their galleries. Admin can create Users, create Galleries for Users (only one per User) and upload photos to existing Galleries.

## Dependencies

| dependency | version |
|:---: | :---: |
| java | 17  |
| spring framework | 4.0.0 |
| MySQL |	latest compatible (9.5.0)|
| dependency management | 1.1.7 |
| docker compose | 3.8 |

## App Preview
LOGIN PAGE:
<img width="1917" height="1030" alt="image" src="https://github.com/user-attachments/assets/0eef5177-23e3-4801-9774-0999f30aa60a" />
1 ST ACCOUNT:
<img width="1919" height="1032" alt="image" src="https://github.com/user-attachments/assets/7982f8f1-fac6-4870-a182-d2595176a5f7" />
<img width="1919" height="1028" alt="image" src="https://github.com/user-attachments/assets/14cb2e49-b160-4e4e-abef-feef85ecaab4" />
2ND ACCOUNT:
<img width="1919" height="1028" alt="image" src="https://github.com/user-attachments/assets/e71c809d-2a21-4f89-a721-0ff9bedf07d9" />
ADMIN:
<img width="1919" height="1029" alt="image" src="https://github.com/user-attachments/assets/a3e9ab0c-5c94-4bb4-85f3-1e26ab7df320" />
MANAGE USERS:
<img width="1919" height="1030" alt="image" src="https://github.com/user-attachments/assets/66711303-b2a1-48ed-a1da-d22d79ccff4d" />
<img width="1919" height="1028" alt="image" src="https://github.com/user-attachments/assets/2dfbf3dd-29b4-4596-8caa-154a77e32840" />
MANAGE GALLERIES:
<img width="1919" height="1031" alt="image" src="https://github.com/user-attachments/assets/b2a20752-02a6-49d6-a05f-54fcff2f73c0" />
<img width="1917" height="1029" alt="image" src="https://github.com/user-attachments/assets/c35c5781-e9be-4374-bbda-7503aa1a4473" />
<img width="1917" height="1028" alt="image" src="https://github.com/user-attachments/assets/72570859-21f2-4def-8e53-f04aac9fc90c" />


## Dev Log
1. creating a docker container + docker compose yml for mysql and connecting with the database in the app
2. making a simplified diagram how the app relationships would look like for reference
3. creating all basic empty classes and interfaces such as: models, services, repositories, controllers and database
4. making a data loading class to make the database have some users etc.
4. setting up spring security that makes it available for the users in the database to log in
5. creating APIs + testing them in POSTMAN to see how they look
6. user: setting up the gallery page for existing users
7. admin: creation of users + creation of galleries for existing users
8. admin: adding photos to existing gallery
9. adding css and fonts
10. better documentation with features, screenshots :]
## Project Set Up

Clone the project

```bash
  git clone https://github.com/nicoxeye/PhotoGallery
```

Change to your own passwords
```bash
  # docker-compose.yml file

  MYSQL_ROOT_PASSWORD: "EXAMPLE"
```
```bash
  # application.properties file
  
  spring.datasource.password=EXAMPLE
```
Use Docker compose
```bash
  docker compose up -d
```
Run the project ^^

## Default data
### [CHANGE spring.jpa.hibernate.ddl-auto=create-drop TO 'update' IF YOU DON'T WANT THE DATABASE TO REFRESH EACH TIME THE APP RESTARTS AND DELETE LoadData CLASS]

    Login: JaneAusten
    Password: 1234
    Role: USER

    Login: AnneRice
    Password: 1234
    Role: USER

    Login: admin
    Password: 999
    Role: ADMIN
## Helpful Things

for spring security:

    https://www.youtube.com/watch?v=nhsdPVXhbHo
    
    https://www.youtube.com/watch?v=RhIXP5tjHkk

for fetching data using thymeleaf:

    https://www.youtube.com/watch?v=TLtksmnrSII

for photo upload:

    https://www.baeldung.com/spring-boot-thymeleaf-image-upload

# Project File Structure
<pre>
└── src/
    ├── main/java/com/photogallery/
    │   ├── apicontroller/                       → api rest controllers, not really used anywhere, i did them to test requests in postman to see how data in json looked like for reference
    │   │   ├── GalleryController.java             
    │   │   ├── PhotoController.java               
    │   │   └── UserController.java               
    │   ├── config/                              → spring security configuration for logging in + user authentication
    │   │   └── WebSecurityConfig.java
    │   ├── controller/                          → main controller, redirects pages between each other and also sends data to thymeleaf that pages retrieve
    │   │   └── PageController.java
    │   ├── database/                            → i did a create-drop table from the start to avoid littering the database when doing testing so i decided to load some example data each time
    │   │   └── LoadData.java
    │   ├── model/                               → database entities + role enum
    │   │   ├── Gallery.java
    │   │   ├── Photo.java
    │   │   ├── Role.java
    │   │   └── User.java
    │   ├── PhotoGalleryApplication.java
    │   ├── repository/                         → model repositories extend jpa repositories that provides all the basic methods for handling data
    │   │   ├── GalleryRepository.java
    │   │   ├── PhotoRepository.java
    │   │   └── UserRepository.java
    │   └── service/                            → holds business logic, interacts with repositories with additional data checking logic
    │   │   ├── CustomUserDetailService.java
    │   │   ├── GalleryService.java
    │   │   ├── GalleryServiceImpl.java
    │   │   ├── PhotoService.java
    │   │   ├── PhotoServiceImpl.java
    │   │   ├── UserService.java
    │   │   └── UserServiceImpl.java
    └── resources/
    │       ├── application.properties
    │       ├── static/
    │       └── templates/
    │           ├── admin/                        → admin related pages, those with user role do not have access to them
    │           │   ├── admin_creategallery.html
    │           │   ├── admin_createuser.html
    │           │   ├── admin_galleries.html
    │           │   ├── admin_index.html
    │           │   └── admin_users.html
    │           ├── index.html
    │           ├── login.html
    │           └── user_gallery.html
    └── uploads/                         → photos to use while loading user photos in gallery from database, in reality would be somewhere else (on a server/disk)
        └── trees.jpg
</pre>

