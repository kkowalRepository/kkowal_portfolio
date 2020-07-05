import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SwapiTest {
    @Test
    public void checkStatus(){
//  check status for the body of a response of a basic request
        given()
                .when()
                .get("https://swapi.dev/api/")
                .then()
                .statusCode(200)
                .body("people", Matchers.equalTo("http://swapi.dev/api/people/"))
                .body("planets", Matchers.equalTo("http://swapi.dev/api/planets/"))
                .body("films", Matchers.equalTo("http://swapi.dev/api/films/"))
                .body("species", Matchers.equalTo("http://swapi.dev/api/species/"))
                .body("vehicles", Matchers.equalTo("http://swapi.dev/api/vehicles/"))
                .body("starships", Matchers.equalTo("http://swapi.dev/api/starships/"));
    }

    @Test
    public void readOnePerson() {
        given()
                .when()
// send http request
                .get("https://swapi.dev/api/people/1/")
                .then()
// check for status 200
                .statusCode(200)
// check if person id=1 is Luke Skywalker
                .body("name", Matchers.equalTo("Luke Skywalker"));

    }
    @Test
    public void checkLuke(){
        Response response = given()
                .when()
                .get("https://swapi.dev/api/people/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath json = response.jsonPath();
        List<String> height = json.getList("results.height");
        Assertions.assertThat((height).contains("172"));
        System.out.println("Luke's height is 172");
    }
    @Test
    public void darkCharacter() {
        Response response = given()
                .when()
                .get("https://swapi.dev/api/people/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath json = response.jsonPath();
        List<String> name = json.getList("results.name");
        Assertions.assertThat(name).contains("Darth Vader");
        System.out.println("Darth Vader is in the database");
    }
    @Test
    public void genderCheck() {

// creating local variable
        Response response = given()
                .when()
                .get("https://swapi.dev/api/people/")
                .then()
                .statusCode(200)
                .body("count", Matchers.equalTo(82))
//  extract info form response within all characters on gender
                .extract()
                .response();
// turn response to JsonPath
        JsonPath json = response.jsonPath();
// get list with gender names
        List<String> gender = json.getList("results.gender");
// assertJ assertion to check if gender field contains gender names
        Assertions.assertThat(gender).containsOnly("male", "female", "n/a");
    }
    @Test
    public void getAllPeople() {
        given()
                .when()
                .get("https://swapi.dev/api/people/")
                .then()
                .statusCode(200)
//  check the count of all characters
                .body("count", Matchers.equalTo(82));
    }

}
