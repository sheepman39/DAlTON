// Site.java
import java.util.*;
import java.io.*;

public class Site extends Collection<Unit> implements Serializable, Basic{
    
    // we will use a linked list for the units
    //GenericLL <Unit> dataLL = new GenericLL<Unit>();

    // site number
    int siteNum;

    public static void main(String[] args){

        Site testSite = new Site();

        testSite.menu();


    } // end main

    public Site(){
        
        // set the siteNum to -1 initially
        this.siteNum = -1;

    } // end constructor

    public Site(int siteNum){
        
        // constructor with the site num provided
        this.siteNum = siteNum;
        
    } // end constructor

    public void addItem(){

        // create a unit
        Unit tempUnit = new Unit();

        // append that unit to the queue
        this.dataLL.append(tempUnit);

    } // end addUnit
    
    public void deleteUnit(int i){

        // delete the unit at the given index
        this.dataLL.delete(i);
        
    } // end deleteUnit
    
    public void setSiteNum(int siteNum){

        // set the siteNum to the num provided
        this.siteNum = siteNum;

    } // end setSiteNum

    public int getSiteNum(){

        // return the site num
        return this.siteNum;

    } // end getSiteNum

    public void menu(){

        // define sentry variable
        boolean keepGoing = true;

        // loop to control the menu
        while(keepGoing){

            // create the new scanner for input
            Scanner input = new Scanner(System.in);

            // spacer
            System.out.println();

            // options
            System.out.println();
            System.out.println("Menu for site #" + this.getSiteNum());
            System.out.println("0) Quit");
            System.out.println("1) Change site num");
            System.out.println("2) See all site info");
            System.out.println("3) Add a unit");
            System.out.println("4) Edit a unit");
            System.out.println("5) Delete a unit");

            // store the response in response
            String response = input.nextLine();

            // spacer
            System.out.println();

            // input handling
            if(response.equals("0")){

                // quit
                keepGoing = false;

            } else if(response.equals("1")){

                // change the unit number
                int num = Unit.integerInput("What would you like the new number to be?: ");
                this.setSiteNum(num);

                // confirmation message
                System.out.println("Ok the site number is now " + this.getSiteNum());

            } else if(response.equals("2")){
                
                // print all of the info
                this.printAllInfo(); 

            } else if(response.equals("3")){

                // add a unit
                this.addItem();

            } else if(response.equals("4")){
                
                // message to edit
                System.out.println("Please select a unit to edit");

                // run a sub-menu to select which unit to edit
                int unitIndex = this.itemSelect();

                // check if the response is greater than or equal to 0, meaning the user selected a valid response
                if(unitIndex >= 0){

                    // get the unit and run the menu
                    this.dataLL.get(unitIndex).menu();
                
                } // end if
            } else if(response.equals("5")){
                
                // message to edit
                System.out.println("Please select a unit to DELETE");

                // delete a unit
                int unitIndex = this.itemSelect();

                // check if the response is valid
                if(unitIndex >= 0){
                    
                    // get the unit and delete it
                    this.deleteUnit(unitIndex);
                
                } else {
                
                    System.out.println("Invalid unit. Nothing was deleted");
                
                }// end if
            } else {

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while
    } // end menu

    public void printAllInfo(){

        // print out the sites information
        System.out.println("Information about Site #" + this.getSiteNum());
        System.out.println("Total number of cots: " + this.getCots());
        System.out.println("Total number of tents: " + this.getTents());
        
        // print out information from each unit staying
        // get the first node and set it to currentNode
        GenericNode <Unit> currentNode = this.dataLL.getNode(0);

        while(currentNode != null){
            
            // get the data stored in the current node
            Unit tempUnit = currentNode.getData();

            // increment tentNum by the number of tents in the data
            System.out.println();
            tempUnit.printAllInfo();
            
            // get the next node
            currentNode = currentNode.getNext();

        } // end while loop
    } // end printAllInfo
} // end site
