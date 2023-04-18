# Final Project Algorithm
# John Salata
## April 4th, 2023

### Unit
Goal - hold all of the relevant information about a given unit in a site
The Unit will implement the Basic interface.

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

Output - An integer representing the number of adults

Steps - return adultF

### Unit.setID(int num)
Goal - set the unit number

Input - an integer representing the new unit number

Output - none

Steps - set the unitNum to the provided num

### Unit.getID(): int
Goal - get the unit number

Input - none

Output - integer representing the id of the unit

Steps - return this.id.

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
Site will inherit from the Collection abstract class (with type Unit) and implement the Basic class as well.

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

### Site.addItem()
Goal - create a new unit and append it to the dataLL

Input - none

Output - none

Steps - create a new site called tempUnit.  The unit constructor will handle all input for the information.  Then, append it to the end of dataLL

### Site.deleteItem(int i)
Goal - delete a unit in the unit linked list

Input - an integer representing the index of the list is needed

Output - None

Steps - run the delete method of the linked list

### Site.setID(int siteNum)
Goal - Set the sites id as the provided one

Input - integer with the site number

Output - None

Steps - set this.id to siteNum

### Site.getID(): int
Goal - get the site number

Input - None

Output - an integer containing the site number

Steps - return this.id

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

---
### Hill
Goal - the Hill object will hold and manage sites that are geographically close to one another in order to make later calculations easier.
It will also inherit from the abstract class Collection with type site and implement the Basic interface

### Hill.Hill(int id)
Goal - initialize the attributes

Input - an integer containing an id

Output - none

Steps - set the id of the hill to the provided one

### Hill.setID(int num)
Goal - set the ID of the hill

Input - an integer containing an id

Output - none

Steps - set the id of the hill to the provided one

### Hill.addItem() and Hill.addItem(int siteNum)
Goal - add a site to the hill's dataLL

Input - an integer representing the site number

Output - none

Steps - if no number was provided, prompt the user for one.  Then create a new site called tempSite and append it to the dataLL

### Hill.printHillInfo()
Goal - print out a small amount of information about the hill

Input - none

Output - Information about the hill

Steps - print out a line telling how many sites the hill has along with how many cots and tents are needed

### Hill.printAllInfo()
Goal - print out all of the information about a hill

Input - none

Output - information about the hill, site, and units

Steps - first call the this.printHillInfo method.  Then get the head of the dataLL and set it to currentNode.  Use a while loop to loop through it and print out all of the information in the sites contained in the dataLL.

### Hill.menu()
Goal - create a menu the user can use to edit the hill

Input - input from the user to determine what to do

Output - none

Steps - create a boolean variable called keepGoing and set it to true.  Then use a while loop to handle the input from the user.  Create a new scanner called input for user input.  Then print out the current information about the unit along with the menu of options
|Option|Description|Method|
|---|---|---|
|0|Quit|keepGoing = false|
|1|See some hill info|.printHillInfo|
|2|See all hill info| .printAllInfo|
|3|Edit a site|.menu()|

With the response being stored in response, we can use if/else statements to handle the input and complete the appropriate actions. 

---
### Week
Goal - Organize each of the hills so collecting information can be easier
Week implements the Basic interface

### Week.Week()
Goal - setup the week to include the proper information

Input - none

Output - none

Steps - Create three hills called wilderness, checaugau, and pioneer.  These three hills are not connected and are therefore separated.  In the constructor, use a loop to add sites to each of these hills.  wilderness gets sites 1-8, checaugau 9-15, and pioneer 16-21.

### Week.getWild(), .getChec(), .getPio()
Goal - return the given hill

Input - none

Output - a hill containing the information of one of the three hills

Steps - return this.wilderness, checaugau, or pioneer
d
### Week.getCots(): int and .getTents(): int
Goal - return an integer representing the number of cots/tents needed

Input - none

Output - an integer representing the number of cots/tents needed

Steps - create a counter variable and set it to 0.  Then increment it by each of the hills .getCots method.  Return the counter variable

### Week.menu()
Goal - create a menu the user can use to edit the week

Input - input from the user to determine what to do

Output - none

Steps - create a boolean variable called keepGoing and set it to true.  Then use a while loop to handle the input from the user.  Create a new scanner called input for user input.  Then print out the current information about the unit along with the menu of options
|Option|Description|Method|
|---|---|---|
|0|Quit|keepGoing = false|
|1|See some week info|.printWeekInfo|
|2|See all info| .printAllInfo|
|3|Edit Wilderness|.menu()|
|4|Edit Checaugau|.menu()|
|5|Edit Pioneer|.menu()|

With the response being stored in response, we can use if/else statements to handle the input and complete the appropriate actions. 

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

### GenericLL.get(int i): NodeTyp
Goal - given an location, return the data in the node

Input - an integer representing the index of the item in the linked list

Output - the data from a node at the location i

Steps - Create a GenericNode called currentNode and set it to null.  Create a returnValue and set it to null. Then check if i is a non-negative number.  If it is, set the currentNode to head and then start a for loop iterating over j while j < i, j++.  In the for loop, set the currentNode to the next node.  This will allow us to find the currentNode at the i index.  Out of the for loop, set the return value to the data in the current node.  Then return the retturnValue, which will either be data or null.   

### GenericLL.get(int i): GenericNode
Goal - given an index, return the node

Input - an integer representing the index of the item in the linked list

Output - the data from a node at the index i

Steps - Create a GenericNode called currentNode and set it to null.  Create a returnValue and set it to null. Then check if i is a non-negative number.  If it is, set the currentNode to head and then start a for loop iterating over j while j < i, j++.  In the for loop, set the currentNode to the next node.  This will allow us to find the currentNode at the i index.  Out of the for loop, set the return value to the data in the current node.  Then return the retturnValue, which will either be data or null.   

---
### Basic Interface
Goal - Create an interface that will guide the construction of most of the classes for this project.  Some methods include int getCots(), int getTents(), int getID(), void setID(int num), and void menu().  These methods will be implemented in Unit, Site, Hill, and Week.

---
### Collection Abstract Class
Goal - create an abstract class that can help implement the basic functionality of each class
Abstract methods include void menu(), void printAllInfo(), void addItem().  It should also be noted that the Collection takes in a data type that implements the Basic interface.  This is so the linked list will be usable for each method.

### Collection.deleteItem(int loc)
Goal - given the location of an item in the linked list, delete it

Input - integer containing the location of the item in the linked list

Output - none

Steps - call the .delete(loc) method of this.dataLL, which is the generic linked list in the collection

### Collection.getCots(): int and Collection.getTents(): int
Goal - return the number of cots and tents in the linked list

Input - none

Output - integer representing the number of cots or tents in a site

Steps - initialize a counter variable to 0.  Then get the head node from dataLL and store it in currentNode.  While the currentNode is not null, get the data from the node, get the number of cots/tents from it, increment the counter variable, and set the currentNode to the next node.  This allows us to traverse over the linked list.  When the while loop is done, return the counter variable.

### Collection.itemSelect(): int
Goal - create a menu that allows the user to select an item from the linked list

Input - integer from the user

Output - the verified integer from the user

Steps - first define a sentry variable called keepGoing and set it to true. Then set the return value to -1 as an invalid result.  Then create a while loop while keepGoing is true.  Then create a scanner called input and print out all of the items in the linked list to select using a for loop.  Then define an Integer response to handle type conversion.  In a try/catch block, we are going to set keepGoing to false and then try to convert the nextInt from input and put it in response.  If anything goes wrong, the exception will be cought, keepGoing set to true, and the loop will be ran again.  If the conversion goes ok, we will check if it is 0.  If it is 0, then set keepGoing to false and return -1 as in no valid option was selected.  If the response is greater than 0 and less than the length of the unitLL, set the returnValue to the response - 1 (since 0 was taken by quit, need to move the indices back). If any of the checks fail, prompt the user to input another valid response again.
