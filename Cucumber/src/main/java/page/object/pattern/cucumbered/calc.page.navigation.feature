#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculator page navigation
  I want to use this template for my feature file
		
	Scenario: Calculator Page works
		Given the user is at the "Line of Credit Calculator" page
		Then the page contains "Line of Credit Calculator"
		
	Scenario: About Us link stays on the same page
		Given the user is at the "Line of Credit Calculator" page
		When the user clicks the "About Us" link
		Then the page contains "Line of Credit Calculator"
		
	Scenario: Contact Us stays on the same page
		Given the user is at the "Line of Credit Calculator" page
		When the user clicks the "Contact Us" link
		Then the page contains "Line of Credit Calculator"
		
		
	Scenario: Links stays on the same page
	Given the user is at the "Line of Credit Calculator" page
		When the user clicks the "Links" link
		Then the page contains "Line of Credit Calculator"
		
	Scenario: News stays on the same page
	Given the user is at the "Line of Credit Calculator" page
		When the user clicks the "News" link
		Then the page contains "Line of Credit Calculator"