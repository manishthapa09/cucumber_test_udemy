Feature: Login to the udemy.com website

Scenario: Login with valid username and passord
Given I open the web page
When I click on the Login button
Then I provide the email and password
Then I click the login button
