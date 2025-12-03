### DEPENDENCIES VERSIONS
| dependency | version |
|:---: | :---: |
| java | 17  |
| spring framework | 4.0.0 |
| MySQL |	latest compatible (9.5.0)|
| dependency management | 1.1.7 |
| docker compose | 3.8 |

# HELPFUL VIDEOS I USED:
for spring security:

    https://www.youtube.com/watch?v=nhsdPVXhbHo
    
    https://www.youtube.com/watch?v=RhIXP5tjHkk

for fetching data using thymeleaf:

    https://www.youtube.com/watch?v=TLtksmnrSII

# DEV LOG ---
STEPS
1. creating a docker container + docker compose yml for mysql and connecting with the database in the app
2. making a simplified diagram how the app relationships would look like

<img width="913" height="491" alt="image" src="https://github.com/user-attachments/assets/dfaebc74-e5ac-4759-b69b-94ebbc44afe8" />

3. creating all basic classes and interfaces such as: models, services, repositories, controllers, database (which acts as the loader of the database)
4. setting up spring security that makes it available for the users in database to log in
5. creating APIs + testing them in POSTMAN
6. setting up the gallery page for existing users