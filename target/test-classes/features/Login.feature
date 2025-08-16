Feature: This feature file is a sample feature file to show all cucumber concepts


@Smoke
 Scenario: This is a login Scenario

	Given I Login to Application
	Then I logout of the application
		
	@Regression
Scenario: This is a Home Page Scenario

	Given I Login to Application
	Then I should Land on the Homepage
	Then I logout of the application

		