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
Feature: Sample calculator function
  #This is for a practice. Took demo application from selenium easy to do this.

  @tag1
  Scenario Outline: Verify that result dispayed is correct in the calculator
    Given user have opened the url 
    And user enter <value1> in field1
    And user enter <value2> in field2
    When I Press the button to calculate
    Then I check the result with <sum>
    And if it is same mark it as Pass and if not same mark it as Failed
    Examples: 
      | value1  | value2 | sum  |
      |   1     |   2    | 3    |
      |   2     |   3    | 5    |
