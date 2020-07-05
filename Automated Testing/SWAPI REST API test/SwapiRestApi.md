# The Star Wars API test - Postman


The Star Wars API, or "swapi" (Swah-pee) is the world's first quantified and programmatically-accessible data source for all the data from the Star Wars canon universe!

All the rich contextual stuff from the universe was taken and formatted into something easier to consume with software. It can all be accessed thanks to the API, Teh Star Wars API.
I focused on characters that starred in the movies so I launched Postaman to start writinig my requests and tests.

Basic Api request is `https://swapi.dev/api/people/`

I go the count of 82, the number of charascters on first page is 10 and there are three types of gender listed: male, female and n/a (in case of robots). So I wrote a couple of tests to check it.

##### Test 1 Status code is 200
```
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
 });
```
##### Test 2 Total number of characters is correct
```
let people = json.results;
pm.test("Total number of characters is correct", function () {
    pm.expect(json.count).is.eql(82);
});
```
##### Test 3 Number of characters on fisrt page is correct
```
let people = json.results;
pm.test("Number of characters on fisrt page is correct", function (){
    pm.expect(people.length).is.eql(10);
});
```
##### Test 4 Gender is on male or female or n/a
```
let person = pm.response.json();
let people = json.results;
pm.test("Gender is on male or female or n/a", function() {
    _.each(people, function(person){
        pm.expect(person.gender).to.be.oneOf(['male', 'female', 'n/a']);
    })
});
```
So far all tests passed. See the Postman screenshot below:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/SWAPI%20REST%20API%20test/images/peopleTest1.png)



