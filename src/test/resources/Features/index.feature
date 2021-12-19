Feature: Job Feature

Scenario: Job detailed page 
Given user is on TMSandbox page
And user click on the existing job list
When user get the title of the page
Then user verify the page of the title should be "Plumber | Trade Me Jobs"
Then user get on jobs detailed page and verify the information details

