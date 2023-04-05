# Final Project Algorithm
# John Salata
## April 4th, 2023

### Unit
Goal - hold all of the relevant information about a given unit in a site

### Unit.Unit() 
Goal - Set the numbers for the unit

Input - user will have to input various integers to describe how big the unit is

Output - none

Steps - Using the integerInput method, prompt the user for the initial values for the given unit.

### Unit.integerInput(String prompt): Integer
Goal - Given a prompt, safely ask the user to input an integer

Input - Prompt to tell the user what to input and an integer from the user

Output - an integer representing the value the user inputed

Steps - first initialize a sentry variable called keepGoing and set it to true.  While keepGoing, create a new scanner called input.  Then print out the prompt and create a new Integer called response.  Since converting a string to an integer is risky, we will put the following section in a try/catch block.  In the try block, set response to input.nextInt to try and convert the user's input to an integer.  If it works, check if the response >= 0.  If it is not, run the prompt again.  If it is, set keepGoing to false and return the prompt value.  If the integer conversion fails, display an error in the catch that it needs to be a valid number. 

### Unit.getCots(): int
Goal - return the number of cots the unit requires

Input - none

Output - integer representing the number needed

Steps - add up each of the members in the unit plus the amount of extraCots that are needed and return that value

### Unit.getTents(): int
Goal - return the number of tents the unit requires

Input - none

Output - integer representing the number needed

Steps - since one tent is needed for every two people, each category of member can be divided by 2 and then take the ceiling of that result.  To this number, add in the number of extraTents the unit has.

### Unit.getYouth(): int
Goal - return the combined number of youth in a unit

Input - none

Output - An integer representing the number of youth in a unit

Steps - return youthM + youthF

### Unit.getAdults(): int
Goal - return the combined number of adults in a unit

Input - none

Output - An integer representing the number of adults

Steps - return adultM + youthF

### Unit.setExtraCots(int number)
Goal - set the number of extra resources needed

Input - an integer

Output - none

Steps - this.extraCots = number

### Unit.setExtraTents(int number)
Goal - set the number of extra resources needed

Input - an integer

Output - none

Steps - this.extraTents = number
