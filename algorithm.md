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

### Unit.getYouthM(): int
Goal - return youthM in a unit

Input - none

Output - An integer representing the number of youth in a unit

Steps - return youthM

### Unit.getYouthF(): int
Goal - return youthF in a unit

Input - none

Output - An integer representing the number of youth in a unit

Steps - return youthF


### Unit.getAdultM(): int
Goal - return adultM in a unit

Input - none

Output - An integer representing the number of adults

Steps - return adultM

### Unit.getAdultF(): int
Goal - return adultF in a unit

Input - none

Output - An integer representing the number of adults

Steps - return adultF

### Unit.setUnitNum(int num)
Goal - set the unit number

Input - an integer representing the new unit number

Output - none

Steps - set the unitNum to the provided num

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

### Unit.printAllInfo()
Goal - print out all of the information of the unit

Input - none

Output - multiple lines of text describing the unit

Steps - print out all of the relevant attributes in a nice way

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

### Site.deleteUnit(int i)
Goal - delete a unit in the unit linked list

Input - an integer representing the index of the list is needed

Output - None

Steps - run the delete method of the linked list

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

Steps - initialize a counter variable to 0.  Then use a for loop to iterate over the unitQ (treating it more like a traditional array) and count the number of tents/cots each unit return

### Site.menu() 
Goal - create a menu where the user can edit the various aspects of the site

Input - responses from the user

Output - none

Steps - create a boolean variable called keepGoing and set it to true.  Then use a while loop to handle the input from the user.  Create a new scanner called input for user input.  Then print out the current information about the unit along with the menu of options
|Option|Description|Method|
|---|---|---|
|0|Quit|keepGoing = false|
|1|Change site number|.setSiteNum|
|2|See all info|lots of stuff|
|3|Add a unit|.addUnit()|
|4|Edit a unit|unit.menu()|
|5|Delete a unit|unitLL.delete()|

With the response being stored in response, we can use if/else statements to handle the input and complete the appropriate actions.

### Site.printAllInfo()
Goal - print out the information of the site including the information from the units

Input - none

Output - lines containing information about the site

Steps - print out the site number, total cots/tents needed, number of units staying, and how many people are in each unit

Input - integer from the user

### Site.unitSelect(): int
Goal - return an integer representing the index of a unit

Input - user input to select a unit

Output - An integer representing the location of the unit

Steps - first define a sentry variable called keepGoing and set it to true. Then set the return value to -1 as an invalid result.  Then create a while loop while keepGoing is true.  Then create a scanner called input and print out all of the units to select using a for loop.  Then define an Integer response to handle type conversion.  In a try/catch block, we are going to set keepGoing to false and then try to convert the nextInt from input and put it in response.  If anything goes wrong, the exception will be cought, keepGoing set to true, and the loop will be ran again.  If the conversion goes ok, we will check if it is 0.  If it is 0, then set keepGoing to false and return -1 as in no valid option was selected.  If the response is greater than 0 and less than the length of the unitLL, set the returnValue to the response - 1 (since 0 was taken by quit, need to move the indices back). If any of the checks fail, prompt the user to input another valid response again.



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

---
### GenericLL
Goal - create a linked list data structure that can be used with any data structure

### GenericLL.GenericLL()
Goal - set the head and tail to null

Input - None

Output - None 

Steps - set this.head and this.tail to null

### GenericLL.append(NodeType data)
Goal - append an object to the end of the linked list

Input - an object of the same type as the linked list

Output - none

Steps - first, create a new node of the same nodetype and call it newNode.  Then, set the data of that node to the data provided by the user.  If the head is null, set the head and tail of the linked list to the new node.  Else, take the tail of the linked list and set the newNode to the one next to the tail, making the newNode the new tail

### GenericLL.delete(int index)
Goal - delete whatever node is at index

Input - Index representing the location of the deleted item

Output - None

Steps - First, find the target node we are trying to delete using the .getNode(index) method and store it in targetNode.  Then check if the head is null.  If the head is null, then there is nothing in the list to delete.  If the head is not null but the targetNode is null, then display an error message.  If neither are null, then find the node before and after the targetNode and set these to previous and next respectively.  If the previous node is not null, then set the next node to previous to next.  If the next node is not null, then set the previous one to previous. 

### GenericLL.iterate()
Goal - print out a list of all of the nodes in the linked list

Input - none

Output - a string containing the data for each node in the linked list

Steps - Create a new node called currentNode and set it to head.  While the currentNode is not null, print out the data from the current node and then set currentNode to the next node in the linked list.  This will allow for each element to be printed and for it to end when it gets to the end of the list.

### GenericLL.length(): int
Goal - return an integer reprsenting the length of the list

Input - none

Output - an integer representing the length of the list

Steps - create a GenericNode called currentNode and currentNode gets head.  Also, create a length integer with the initial value of 0.  While the currentNode is not null, increment the length by 1 and then set the currentNode to the next node.  Once the loop is done, return the length.

### GenericLL.get(int i): NodeType
Goal - given an index, return the data in the node

Input - an integer representing the index of the item in the linked list

Output - the data from a node at the index i

Steps - Create a GenericNode called currentNode and set it to null.  Create a returnValue and set it to null. Then check if i is a non-negative number.  If it is, set the currentNode to head and then start a for loop iterating over j while j < i, j++.  In the for loop, set the currentNode to the next node.  This will allow us to find the currentNode at the i index.  Out of the for loop, set the return value to the data in the current node.  Then return the retturnValue, which will either be data or null.   

### GenericLL.get(int i): GenericNode
Goal - given an index, return the node

Input - an integer representing the index of the item in the linked list

Output - the data from a node at the index i

Steps - Create a GenericNode called currentNode and set it to null.  Create a returnValue and set it to null. Then check if i is a non-negative number.  If it is, set the currentNode to head and then start a for loop iterating over j while j < i, j++.  In the for loop, set the currentNode to the next node.  This will allow us to find the currentNode at the i index.  Out of the for loop, set the return value to the data in the current node.  Then return the retturnValue, which will either be data or null.   

