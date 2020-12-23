Feature: Epam website

  Scenario: Search specific keyword
    Given I should click on search button on menu bar
    When I enter keyword
    And I click find button
    Then I should be able to get all results found on this website and be on search page

  Scenario: Change language for website
    Given I am on main page
    When I click on language button on menu bar
    And I select language (Россия(Русский))
    Then Everything on website should be translated to selected language and be on main page


  Scenario: Sending a letter/feedback/ask something
    Given I should be on "Contact us" page
    When I enter every field with information
    And I click on two check marks
    And I click on submit button
    Then I should stay on same page


  Scenario: Getting information about post(Continuum)
    Given I should be on main page
    When I click on Learn more button on exact post
    Then I am directed to exact page with this post


  Scenario: Getting information on services/optimize page
    Given I should be on optimize page
    When I click on buttons
    Then I should get information below buttons
    But If click on another button
    Then information must change


  Scenario: Search for dream job
    Given I should be on careers page
    And I enter keywords or job ID, city, skills, sign check marks
    When I click on find button
    Then I should be able to get all results found about jobs

