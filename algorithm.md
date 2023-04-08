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
---
### Site
Goal - store multiple units as a member of the site and return the total number of cots/tents needed in the site

### Site.Site()
Goal - instantialize the attributes

Input - None

Output - None

Steps - set the siteNum to -1, indicating that it has not been set yet

### Site.Site(int siteNum)
Goal - create a new site with the initial siteNum as the provided one

Input - integer with the site number

Output - None

Steps - set this.siteNum to siteNum

### Site.addUnit()
Goal - create a new unit and append it t the siteQ

Input - none

Output - none

Steps - create a new site called tempUnit.  The unit constructor will handle all input for the information.  Then, append it to the end of unitQ

### Site.setSiteNum(int siteNum)
Goal - Set the sites siteNum as the provided one

Input - integer with the site number

Output - None

Steps - set this.siteNum to siteNum

### Site.getSiteNum(): int
Goal - get the site number

Input - None

Output - an integer containing the site number

Steps - return this.siteNum

### Site.getCots(): int and Site.getTents(): int
Goal - return the number of cots and tents in a given site

Input - none

Output - integer representing the number of cots or tents in a site

Steps - initialize a counter variable to 0.  Then use a for loop to iterate over the unitQ (treating it more like a traditional array) and count the number of tents/cots each unit returns

---
### GenericNode
Goal - create a node that can be used with any type and (almost) every data structure we might need for this project

### GenericNode.GenericNode()
Goal - set each of the initial values to null

Input - none

Output - none

Steps - set the data, previous, and next values to null

### GenericNode.setData(NodeType data)
Goal - set the data of the node to a provided object

Input - an object of the type the node uses

Output - None

Steps - set this.data to the data provided

### GenericNode.getData(): NodeType
Goal - return the object the node is holding

Input - none

Output - An object of the same type the node uses

Steps - return this.data

### GenericNode.getNext() and .getPrevious(): GenericNode\<NodeType\>
Goal - return the next node attached to the current one

Input - none

Output - a node that is next in a data structure

Steps - return this.next; or this.previous;

### GenericNode.setNext(GenericNode\<NodeType\> next) and GenericNode.setPrevious(GenericNode\<NodeType\>)
Goal - set the previous or next node to a given node

Input - a node of the same type 

Output - none

Steps - set this.next to next or this.previous to previous, respectively

---
### GenericQ
Goal - create a queue data structure that can be used with any data structure

### GenericQ
