Feature: Login page

@Login
Scenario: Check login is successful with correct credentials

Given User is on login page
When User enters correct username and password
And Clicks on login button
Then User is navigated to home page
And Close the browser

@Payment
Scenario: Check payment is successful

Given User is on login page 
When User enters correct username and password
And Clicks on login button
Then User is navigated to home page
Then User is performing payment
Then User is navigated to successful page
And Close the browser