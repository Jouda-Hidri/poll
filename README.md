# Poll Restful API

A solution to Doodle's coding challenge.

**Setup**
To run this project after cloning the repository:
* `mvn clean package`
* `docker-compose up --build`

Once it finishes go to `http://localhost:8080/swagger-ui.html` for the documentation on how to use the API.

**Choice of technologies**

I chose Maven over Gradle because of its simplicity, since Gradle's more powerful features were not needed for this project.

I chose Spring Boot as a framework because it allows for great productivity thanks to its starter POMs and embedded server.

I chose H2 as an in-memory database for testing and PostgreSQL because it is an open-source database with many advanced features.

**Design decisions**

The API restricts the user to be able to use exactly one filter per request by design.

I chose a layer based organization of the packages splitting them into three layers: an API layer, a service layer and a persistence layer. Another approach would have been to split them by domain but I would reserve this for a bigger, more complex project.

Regarding my testing strategy, I chose to do one integration test covering all the layers. I used setters to create instances of `Poll` and `Participant` for the unit tests. It would also be possible to load test data from JSON files instead of using setters, but chose setters for simplicity.