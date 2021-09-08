# CCMDB

### Background
A new startup CCMDB need your help in producing a prototype for a movie information portal to rival IMDB which they can pitch to investors on Crowdcube. 

They have opted to use Java and Spring Boot to build it and have brought you in as a consultant to answer some questions regarding the design and build.  

### Interview format
The interview is a 45min pair programming exercise where you will work with another developer through a set of tasks  

The interview will start with a basic introduction to the application and there will be the opportunity to ask questions  

You will be the driver and are responsible for directing the overall solution design but we encourage you to vocalise your thoughts with your partner and ask questions.    

And yes you can Google commands and documentation as needed.


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



