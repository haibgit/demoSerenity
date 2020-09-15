Feature: test suite for outline

  @outline
  Scenario Outline: eating
    Given Open Application APIDemo
    When I choose menu <menu>
    Then I see title of screen is <title>


    Examples:
      | menu                   | title                  |
      | API Demos              | API Demos              |
      | Support App Navigation | Support App Navigation |


#  Scenario: test case1
#    Given Open Application APIDemo
#    When I choose menu "API Demos"
#    Then I see title of screen is "API Demos"
#
#  Scenario: test case2
#    Given Open Application APIDemo
#    When I choose menu API Demos
#    Then I see title of screen is "API Demos"

#  Scenario: test case3
#    Given Open Application APIDemo
#    When I choose menu API Demos
#    When I choose menu Animation
#    Then I see title of screen is "Animation"

#    Scenario: test case4
#    Given Open Application APIDemo
#    When I choose menu API Demos
#    Then I see title of screen is visible
