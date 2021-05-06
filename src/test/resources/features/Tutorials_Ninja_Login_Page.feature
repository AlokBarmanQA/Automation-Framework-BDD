Feature: Application login

Scenario: Login with valid credentials
Given Open any browser
And Navigate to login Page
When user login using username as "alok.kumar_barman@outlook.com" and password as "test@1234"
Then Verify user is able to successful login
