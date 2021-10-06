@Demo
Feature: 01_Permission_Accept

  @Severity=critical
  Scenario: 01_Is AUT installed and click on chapter 1
    Given Check AUT is installed
    When Click on chapter - Chapter 1: App Fundamentals

  @Severity=critical
  Scenario: 02_Click on chapter 2
    When Click on demo chapter - Chapter 2: User Interface
