Feature: Search SVEC events

Background:
	Given user is on the event page

@ValidEventSearch
Scenario: User searches for SVEC events with valid keyword
When the user enters a valid keyword "a" in the event search field
And the user clicks on event search button
Then the user is directed to SVEC event page

@InvalidEventSearch
Scenario: User searches for SVEC events with invalid keyword
When the user enters a invalid keyword "12312" in the event search field
And the user clicks on event search button
Then an error message that no events found is shown