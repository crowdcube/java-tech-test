# CCMDB

### Background
A new startup CCMDB need your help in producing a prototype for a movie information portal to rival IMDB which they can pitch to investors on Crowdcube. 

They have opted to use Java and Spring Boot to build it and have brought you in as a consultant to answer some questions regarding the design and build.   
  
Good luck!

### How to run
Either run via your IDE by running the main application class CcmdbApplication or via the gradle command  

./gradlew bootRun

The app will re-populate the database with a set of test movies each time the app restarts and will also reset the database.

### Database
The database is a simple in memory H2 database 
To access it navigate to http://localhost:8080/h2-console/ in a browser

JDBC URL: jdbc:h2:mem:ccmdb  
Username: sa  
Password: movies



