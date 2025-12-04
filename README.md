### DEPENDENCIES VERSIONS
| dependency | version |
|:---: | :---: |
| java | 17  |
| spring framework | 4.0.0 |
| MySQL |	latest compatible (9.5.0)|
| dependency management | 1.1.7 |
| docker compose | 3.8 |

# PROJECT FILE STRUCTURE [WIP]
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
    │       │   └── uploads/                      → static photos to use while loading user photos from database, in reality would be somewhere else (on a server/disk)
    │       │       └── trees.jpg
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
</pre>

# HELPFUL VIDEOS I USED:
for spring security:

    https://www.youtube.com/watch?v=nhsdPVXhbHo
    
    https://www.youtube.com/watch?v=RhIXP5tjHkk

for fetching data using thymeleaf:

    https://www.youtube.com/watch?v=TLtksmnrSII

# DEV LOG ---
STEPS
1. creating a docker container + docker compose yml for mysql and connecting with the database in the app
2. making a simplified diagram how the app relationships would look like (final version below (TODO))
3. creating all basic classes and interfaces such as: models, services, repositories, controllers, database (which acts as the loader of the database)
4. setting up spring security that makes it available for the users in database to log in
5. creating APIs + testing them in POSTMAN
6. setting up the gallery page for existing users
7. creation of users and galleries for existing users
8. (TODO) adding photos to existing gallery
9. (TODO) adding css to pages
10. (TODO) better documentation with features, screenshots etc
