
// Collection.java
import java.util.*;
import java.io.*;

public abstract class Collection<Type extends Basic> implements Serializable {

    // common functions
    GenericLL<Type> dataLL = new GenericLL<Type>();
    int id;

    public abstract void menu();
    public abstract void printAllInfo();
    public abstract void addItem();

    public void deleteItem(int loc) {

        // delete the item at the location in the ll
        this.dataLL.delete(loc);

    } // end deleteItem

    public int getCots() {

        // use a for loop to get the number of cots from each unit in the queue
        int cotNum = 0;

        // use a better way to traverse over the linked list
        // get the first node and set it to currentNode
        GenericNode<Type> currentNode = this.dataLL.getNode(0);

        while (currentNode != null) {

            // get the data stored in the current node
            Type tempType = currentNode.getData();

            // increment cotNum by the number of cots in the data
            cotNum += tempType.getCots();

            // get the next node
            currentNode = currentNode.getNext();

        } // end while loop

        // return cotNum
        return cotNum;

    } // end getCots

    public int getTents() {

        // use a for loop to get the number of cots from each unit in the queue
        int tentNum = 0;

        // get the first node and set it to currentNode
        GenericNode<Type> currentNode = this.dataLL.getNode(0);

        while (currentNode != null) {

            // get the data stored in the current node
            Type tempType = currentNode.getData();

            // increment tentNum by the number of tents in the data
            tentNum += tempType.getTents();

            // get the next node
            currentNode = currentNode.getNext();

        } // end while loop

        // return tentNum
        return tentNum;

    } // end getTents

    public int itemSelect() {

        // sentry variable
        boolean keepGoing = true;

        // set the default return value to -1 (invalid)
        int returnValue = -1;

        // while loop to control user input
        while (keepGoing) {

            // create the new scanner for input
            Scanner input = new Scanner(System.in);

            // output all of the options for the units
            System.out.println("");
            System.out.println("Please select an option");

            // display a quit message
            System.out.println("0) Quit and return to the menu");

            // get the first node in the list
            GenericNode<Type> currentNode = this.dataLL.getNode(0);

            // counter will tell the user which option to select to edit a given unit
            int counter = 1;
            while (currentNode != null) {

                // get the data from the unit
                Type tempType = currentNode.getData();

                System.out.println(counter + ") Select " + tempType.getID());

                // note - after rewrite, readd tempType.getID()

                // increment counter
                counter++;

                // get the next node
                currentNode = currentNode.getNext();

            } // end while loop

            // spacer
            System.out.println("");

            // define response
            Integer response;

            // since we have to turn the user's response into an int to use in the unit
            // list, we will run the following code
            try {

                // set keepGoing to false
                keepGoing = false;

                // attempt to put the input in response
                response = input.nextInt();

                // check if the response is the same as the size of the dogs list
                if (response.equals(0)) {

                    // quit
                    keepGoing = false;

                // note: offset response by -1 since quit is 0
                } else if (response - 1 < this.dataLL.length()) {

                    if (response > 0) {

                        // if it is a valid index, run the menu of that unit
                        // note that it is -1 since we added 1 in the menu
                        returnValue = (response - 1);

                    } else {

                        // keep prompting the user for valid input
                        System.out.println("Please input a valid number greater than 0");
                        keepGoing = true;

                    } // end inner if/else

                } else {

                    // keep prompting the user for valid input
                    System.out.println("Please input a valid number");
                    keepGoing = true;

                } // end if/else

            } catch (NumberFormatException e) {

                // this exception means that an invalid answer was put in so we will clarify for
                // the user
                System.out.println("Please input a valid number");

                // reset keepGoing
                keepGoing = true;

            } catch (Exception e) {

                // if this happens we aren't sure what the error is
                System.out.println("Unexpected error. Please input a valid number.");
                System.out.println(e.getMessage());

                // reset keepGoing
                keepGoing = true;

            } // end try/catch blocks
        } // end while loop

        // return the value
        return returnValue;
    } // end getItem

} // end Collection
