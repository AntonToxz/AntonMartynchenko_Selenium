Feature epam website

  Scenario: Search specific keyword
    Given I should click on search button on menu bar
    And I enter keyword
    When I click find button
    Then I should be able to get all results found on this website
    And I should be on search page


  Scenario: Change language for website
    Given I am on main page
    When I click on language button on menu bar
    And I select language (Россия(Русский))
    Then Everything on website should be translated to selected language
    And I should be on main page


  Scenario: Sending a letter/feedback/ask something
    Given I should be on "Contact us" page
    When I enter every field with information
    And I click on two check marks
    And I click on submit button
    And I complete CAPTCHA
    Then I should stay on same page
    And I get confirmation that email was sent
    And I stay on same page
    But i dont see fields to enter


  Scenario: Getting information about post(Continuum)
    Given I should be on main page
    When I click on Learn more button on exact post
    Then I am directed to exact page with this post


  Scenario: Getting information on services/optimize page
    Given I should be on services/optimize page
    When I click on buttons
    Then I should get information below buttons
    And If i click on another button information must change


  Scenario: Search for dream job
    Given I should be on careers page
    And I enter keywords or job ID, city, skills, sign check marks
    When I click on find button
    Then I should be able to get all results found about jobs

