Feature: Line of Credit Calculator

  Scenario: Approved
    Given the user is at the calculator
    When the user enters 50000 for income
    And enters 750 for credit rating
    And enters 180 for days of employment
    Then the calculator provides the message "Please apply Today!!"
    And gives a maximum limit of 5000

  Scenario: Low Salary
    Given the user is at the calculator
    When the user enters 49999 for income
    And enters 750 for credit rating
    And enters 180 for days of employment
    Then the calculator provides the message "Your Income is too low"
    And gives a maximum limit of 0

  Scenario: Bad Credit
    Given the user is at the calculator
    When the user enters 50000 for income
    And enters 749 for credit rating
    And enters 180 for days of employment
    Then the calculator provides the message "Your credit rating is not good enough"
    And gives a maximum limit of 0

  Scenario: Not Employed Long Enough
    Given the user is at the calculator
    When the user enters 50000 for income
    And enters 750 for credit rating
    And enters 179 for days of employment
    Then the calculator provides the message "You have not worked long enough"
    And gives a maximum limit of 0