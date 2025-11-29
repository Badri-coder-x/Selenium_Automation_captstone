Feature:  Registering the user as an Admin

@ValidDetails
Scenario: Successful registration with all mandatory fields
Given user is on the registration page
When user enters the mandatory fields by the following
	|	field		|	value				|
	|	login		|	user123				|
	|	password	|	password123			|
	|	firstname	| 	Steve				|
	|	lastname	|	Rogers				|
	|	email		| 	stev121@gmail.com	|
	
And the user clicks add
Then the system navigates to Home page

Scenario: Regsistration fails with missing mandatory fields
Given user is on the registration page
When user does not fill the mandatory page
And the user clicks add
Then the system throws error

@InvalidEmail
Scenario: Registration fails with invalid email format
Given user is on the registration page
When user enters invalid email
	|	field		|	value				|
	|	login		|	user123				|
	|	password	|	password123			|
	|	firstname	| 	Steve				|
	|	lastname	|	Rogers				|
	|	email		| 	stev121.com			|


And the user clicks add
Then the system throws error that email is invalid

@Invalidfnameandlname
Scenario: Registration fails with invalid firstname and lastname 
Given user is on the registration page
When user enters invalid firstname and lastname
	|	field		|	value				|
	|	login		|	usead1f		|
	|	password	|	password123			|
	|	firstname	| 	123456				|
	|	lastname	|	789012				|
	|	email		| 	stev121@gmail.com	|


And the user clicks add
Then the system throws error that firstname and lastname is invalid