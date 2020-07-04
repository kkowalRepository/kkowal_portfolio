# Heroku App - Login functionality test with SeleniumIDE


http://the-internet.herokuapp.com is a test automastion practice website with many examples to explore. For this task I chose the Form Authentication test. This is where user can acces secure area aftre logging in. I created two scenarios for coccrect and incorrect entries. So the basic steps to get there are:

Scenario one: @correctDataHeroku 
>- go to a website : http://http://the-internet.herokuapp.com/login
>- enter correct username: tomsmith
>- enter correct password: SuperSecretPassword!
>- click "login"
>- user is logged into a secure area
>- click "logout"
>- close the browser

Scenario two:  @incorrectDataHeroku
>- go to a website : http://http://the-internet.herokuapp.com/login
>- enter incorrect username: someLogin
>- enter incorrect password: randomPassword
>- clikc login
>- user is not logged into a secure area
>- close the browser


##### Scenario one

 So, first I launched Google Chrome browser and clicked teh Selenium IDE extension icon to start the app. I chose: "Create new project" and gave it a name: Form Authentication test. I entered playback base URL which is https://the-internet.herokuapp.com/login and pressed record. 
 
 ![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppLogintestSeleniumIDE/images/loginTestStep1.png)
 
 I entered correct username : tomsmith and password: SuperSecretPassword!. After clicking login button I was transfered to a secure area form which I successfulley logged out. Hera are test results:
 
 ![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppLogintestSeleniumIDE/images/loginTestStep2.png)
 
 
 ![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppLogintestSeleniumIDE/images/herokuAppLoginTest%20SeleniumIDE480p.mov)
 
 
 
 

