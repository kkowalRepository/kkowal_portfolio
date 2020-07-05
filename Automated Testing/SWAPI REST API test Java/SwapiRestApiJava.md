# The Star Wars API test - Java


The Star Wars API test but this time using Java and IntelliJ IDEA. I used the Rest Assured library which is dedicated to write Rest Api tests. Tests will include three sections: 

- given (set configuration),
- when (send http request),
- then (set assertions).

So I launched a Maven project in IntelliJ and started adding libraries:

- Rest Assured
- JUnit
- Hamcrest
- AssertJ

##### Test 1 Status code is 200 for teh basic API request

```
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
```
##### Test 2 Read one person (id1) and check if it's Luke Skywalker
```
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
```
##### Test 3 Total number of characters is correct
```
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
```
##### Test 4 Gender is on male or female or n/a
```
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
```
All tests passed. See the screenshot below:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/SWAPI%20REST%20API%20test%20Java/images/restApiTestJava.png)


