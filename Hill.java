// Hill.java
import java.util.*;
import java.io.*;

public class Hill extends Collection<Site> implements Serializable, Basic{

    // site linked list will be used to store all of the sites in the hill
    GenericLL <Site> dataLL = new GenericLL<Site>();

    public static void main(String[] args){

        // test harness
        Hill testHill = new Hill();

        testHill.menu();
    } // end main

    public Hill(){
    } // end constructor

    public Hill(int id){
        this.id = id;
    } // end Hill

    public int getID(){

        // returnt the id
        return this.id;

    } // end getID

    public void setID(int num){
    
        // set the id to the provided option 
        this.id = num;

    } // end setID

    public void addItem(){

        // prompt the user for what the new site number should be
        int siteNum = Unit.integerInput("What should the new site number be?");

        // create a site
        Site tempSite = new Site(siteNum);

        // append the site to the end of the list
        this.dataLL.append(tempSite);

    } // end addSite

    public void addItem(int siteNum){

        // creatte a site
        Site tempSite = new Site(siteNum);

        // append the site to the end of the list
        this.dataLL.append(tempSite);

    } // end addSite

    public void printHillInfo(){

        // print the information about this hill
        System.out.println("Information about this hill: ");
        System.out.println("This hill has " + this.dataLL.length() + " sites");
        System.out.println("Cots needed: " + this.getCots());
        System.out.println("Tents needed: " + this.getTents());

    } // end printHillInfo()
    
    public void printAllInfo(){

        // print out the hill info
        this.printHillInfo();

        // print out each site info
        GenericNode <Site> currentNode = this.dataLL.getNode(0);
        
        // iterate through each of the sites
        while(currentNode != null){

            // temp site
            Site tempSite = currentNode.getData();

            // print the sites data
            System.out.println();
            tempSite.printAllInfo();

            // set the next node
            currentNode = currentNode.getNext();

        } // end while loop
    } // end printAllInfo

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
            System.out.println("Menu for the hill");
            System.out.println("0) Quit");
            System.out.println("1) See some hill info");
            System.out.println("2) See all hill info");
            System.out.println("3) Add a site");
            System.out.println("4) Edit a site");
            System.out.println("5) Delete a site");

            // store the response in response
            String response = input.nextLine();

            // spacer
            System.out.println();

            // input handling
            if(response.equals("0")){

                // quit
                keepGoing = false;

            } else if(response.equals("1")){

                // see some hill info
                this.printHillInfo();

            } else if(response.equals("2")){
                
                // print all of the info
                this.printAllInfo(); 

            } else if(response.equals("3")){

                // add a site
                this.addItem();

            } else if(response.equals("4")){
                
                // message to edit
                System.out.println("Please select a site to edit");

                // run a sub-menu to select which unit to edit
                int siteLoc = this.itemSelect();

                // check if the response is greater than or equal to 0, meaning the user selected a valid response
                if(siteLoc >= 0){

                    // get the unit and run the menu
                    this.dataLL.get(siteLoc).menu();
                
                } // end if
            } else if(response.equals("5")){
                
                // message to edit
                System.out.println("Please select a site to DELETE");

                // delete a unit
                int siteLoc = this.itemSelect();

                // check if the response is valid
                if(siteLoc >= 0){
                    
                    // get the unit and delete it
                    this.deleteItem(siteLoc);
                
                } else {
                
                    System.out.println("Invalid unit. Nothing was deleted");
                
                }// end if

            } else {

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while
    } // end menu
} // end site
    

