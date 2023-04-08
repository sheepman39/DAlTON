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

### Unit.menu()
Goal - create a menu where the user can edit the unit

Input - integers and responses from the user

Output - none

Steps - create a boolean variable called keepGoing and set it to true.  Then use a while loop to handle the input from the user.  Create a new scanner called input for user input.  Then print out the current information about the unit along with the menu of options
|Option|Description|Method|
|---|---|---|
|0|Quit|keepGoing = false|
|1|Change unit number|.setUnitNum|
|2|Change the number of members| .setYouthM/F...|
|3|Change the number of needed cots|.setExtraCots()|
|4|Change the number of needed tents|.setExtraTents()|
|5|See all info|lots of stuff|

With the response being stored in response, we can use if/else statements to handle the input and complete the appropriate actions.

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
d
### Site.editUnits() 
Goal - create a menu where the user can choose a unit to edit in a site

Input - integer from the user
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

### GenericQ.GenericQ()
Goal - set the head and tail to null

Input - None

Output - None 

Steps - set this.head and this.tail to null

### GenericQ.append(NodeType data)
Goal - append an object to the end of the queue

Input - an object of the same type as the queue

Output - none

Steps - first, create a new node of the same nodetype and call it newNode.  Then, set the data of that node to the data provided by the user.  If the head is null, set the head and tail of the queue to the new node.  Else, take the tail of the queue and set the newNode to the one next to the tail, making the newNode the new tail

### GenericQ.pop(): NodeType
Goal - return and remove the head of the queue to the user

Input - none

Output - A value the same data type as the node type

Steps - create a GenericNode of NodeType type called poppedNode and set it to null. Then create a NodeType returnvalue set to null.  Check if the head is not null.  If the head exists, then set the popped node to the head.  Then set the head to the node after the poppedNode.  Then set the return value to the poppedNode's data.  Then return the returnValue, which will either be null if the queue is empty or some data value.

### GenericQ.iterate()
Goal - print out a list of all of the nodes in the queue

Input - none

Output - a string containing the data for each node in the queue

Steps - Create a new node called currentNode and set it to head.  While the currentNode is not null, print out the data from the current node and then set currentNode to the next node in the queue.  This will allow for each element to be printed and for it to end when it gets to the end of the list.

### GenericQ.length(): int
Goal - return an integer reprsenting the length of the list

Input - none

Output - an integer representing the length of the list

Steps - create a GenericNode called currentNode and currentNode gets head.  Also, create a length integer with the initial value of 0.  While the currentNode is not null, increment the length by 1 and then set the currentNode to the next node.  Once the loop is done, return the length.

### GenericQ.get(int i): NodeType
Goal - given an index, return the data in the node

Input - an integer representing the index of the item in the queue

Output - the data from a node at the index i

Steps - Create a GenericNode called currentNode and set it to null.  Create a returnValue and set it to null. Then check if i is a non-negative number.  If it is, set the currentNode to head and then start a for loop iterating over j while j < i, j++.  In the for loop, set the currentNode to the next node.  This will allow us to find the currentNode at the i index.  Out of the for loop, set the return value to the data in the current node.  Then return the retturnValue, which will either be data or null.   

