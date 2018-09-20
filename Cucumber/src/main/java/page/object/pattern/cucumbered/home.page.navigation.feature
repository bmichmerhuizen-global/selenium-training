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
Feature: test Home Page Navigation
	Scenario: HomePage works
		Given the user is at the "Home" page
		Then the page title is "CashFlow"
		
		Scenario: Calculator Page works
		Given the user is at the "Line of Credit Calculator" page
		Then the page contains "Line of Credit Calculator"
		
	Scenario: About Us page is anti-social
		Given the user is at the "About Us" page
		Then the page contains "you should not be here"
		
	Scenario: Contact Us page is anti-social
		Given the user is at the "Contact Us" page
		Then the page contains "you should not be here"
		
		
		Scenario: Links page is anti-social
		Given the user is at the "Links" page
		Then the page contains "you should not be here"