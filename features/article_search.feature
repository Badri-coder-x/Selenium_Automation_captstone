Feature: Search SVEC articles

Background:
	Given user is on the Home page

@ValidArticleSearch
Scenario: User searches for SVEC articles with valid keyword
When the user enters a valid keyword "a" in the search field
And the user clicks on search button
Then the user is directed to SVEC articles page


@InvalidArticleSearch
Scenario: User searches for SVEC articles with invalid keyword
When the user enters an invalid keyword "123456" in the search field
And the user clicks on search button
Then an error message that no elements found is displayed