@backgroud
Feature: Title of your feature

  Background:
    Given Open Application APIDemo
    When I choose menu "API Demos"

  Scenario: view menu app1
    And I choose menu "App"
    Then I see title of screen is "App"

  Scenario: view menu app2
    And I choose menu "Media"
    Then I see title of screen is "Media"

  Scenario: view menu app3
    And I choose menu "OS"
    Then I see title of screen is "OS"
    And I choose menu "Morse Code"
    Then I see button VIBRATE visible





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
