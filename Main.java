// Main.java
import java.util.*;
import java.io.*;

public class Main{

    // we will use an arraylist to handle persistent data
    ArrayList<Week> weekList = new ArrayList<Week>();

    public static void main(String[] args){
    
        Main main = new Main();

        main.menu();
    } // end main

    public Main(){

        // try to load up any existing data
        this.load();

    } // end constructor

    public void addWeek(int weekNum){

        // create a new week with the given weekNum
        Week tempWeek = new Week();
        tempWeek.setID(weekNum);
        
        // append it to the end of the list
        this.weekList.add(tempWeek);

        // sort the list
        this.sortWeeks();

    } // end addWeek

    public void deleteWeek(int index){

        // delete a week
        this.weekList.remove(index);

    } // end deleteWeek
    
    public void printSomeInfo(){
        
        // print some basic information
        System.out.println("Information for Camp Blackhawk (GO!): ");
        System.out.println("We have " + this.weekList.size() + " weeks of camp");
        
        // use a for loop to print cots/tents needed for each week/hill
        for(int i = 0; i < this.weekList.size(); i++){
            
            // get the current week
            Week tempWeek = this.weekList.get(i);

            // print out the week information
            tempWeek.printWeekInfo();

        } // end for loop
    } // end print some info

        
    public void printAllInfo(){
        
        // print some basic information
        System.out.println("Information for Camp Blackhawk (GO!): ");
        System.out.println("We have " + this.weekList.size() + " weeks of camp");
        
        // use a for loop to print cots/tents needed for each week/hill
        for(int i = 0; i < this.weekList.size(); i++){
            
            // get the current week
            Week tempWeek = this.weekList.get(i);

            // print out the week information
            tempWeek.printAllInfo();

        } // end for loop
    } // end print some info

    public void compareWeeks(Week week1, Week week2){
        // goal: compare each hill, site ect
        // compare wilderness
        GenericLL<Site> chec1 = week1.getChec().getSites();
        GenericLL<Site> chec2 = week2.getChec().getSites();

        GenericLL<Site> wild1 = week1.getWild().getSites();
        GenericLL<Site> wild2 = week2.getWild().getSites();

        GenericLL<Site> pio1 = week1.getPio().getSites();
        GenericLL<Site> pio2 = week2.getPio().getSites();

        this.compareHills(wild1, wild2);
        this.compareHills(chec1, chec2);
        this.compareHills(pio1, pio2);

    } // end compareWeeks

    public void compareHills(GenericLL<Site> week1, GenericLL<Site> week2){

        // get the head nodes for both weeks
        GenericNode<Site> currentNode1 = week1.getNode(0);
        GenericNode<Site> currentNode2 = week2.getNode(0);
        
        // create counter variables so we know what the total delta is
        int cotCounter = 0;
        int tentCounter = 0;
        
        // create cot queues
        // first pos will be the site num, second will be the number it has
        GenericQ <int[]> needCotQ = new GenericQ<int[]>();
        GenericQ <int[]> hasCotQ = new GenericQ<int[]>();

        // go through every site until there is nothing in the linked list
        while(currentNode1 != null){

            // get the sites from the current node
            Site site1 = currentNode1.getData();
            Site site2 = currentNode2.getData();

            // find the delta between cots and tents per week
            // positive means that more of an item will need to be there
            // negative means there is a surplus
            // 0 means no change
            int cotDiscrepancy = site2.getCots() - site1.getCots();
            int tentDiscrepancy = site2.getTents() - site1.getTents();
            
            int[] tempCotArray = new int[2];
            tempCotArray[0] = site1.getID();
            tempCotArray[1] = cotDiscrepancy;

            // check if the discrepancy is + or -
            if(cotDiscrepancy > 0){
                
                // append the information to the end of the needCotQ
                needCotQ.append(tempCotArray);
    
            } else if(cotDiscrepancy < 0){

                hasCotQ.append(tempCotArray);

            } // end if/else
            // increment this to the total count
            cotCounter += cotDiscrepancy;
            tentCounter += tentDiscrepancy;

            // get the next node
            currentNode1 = currentNode1.getNext();
            currentNode2 = currentNode2.getNext();
        } // end while loop

        // create an instance of the compare class
        Compare compare = new Compare();
        compare.init(needCotQ, hasCotQ);
        compare.move(needCotQ.pop(), hasCotQ.pop(), "cots");
        System.out.println();
    
    } // end compareHill

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
            System.out.println("Menu for Camp Blackhawk (GO!)");
            System.out.println("0) Quit");
            System.out.println("1) Print week highlights");
            System.out.println("2) Print all information");
            System.out.println("3) Add a week");
            System.out.println("4) Edit a week");
            System.out.println("5) Delete a week");
            System.out.println("6) Compare weeks");

            // store the response in response
            String response = input.nextLine();

            // spacer
            System.out.println();

            // input handling
            if(response.equals("0")){

                // quit
                keepGoing = false;
               
                // save
                this.save();
            } else if(response.equals("1")){

                // print some information
                this.printSomeInfo();

            } else if(response.equals("2")){

                // print all info
                this.printAllInfo();

            } else if(response.equals("3")){

                // add a week
                // get an integer from the user
                int weekNum = Unit.integerInput("What week number will the new week be? ");

                System.out.println("Weeknum" + weekNum);
                
                // add the week
                this.addWeek(weekNum);

            } else if(response.equals("4")){
                
                // edit a week
                System.out.println("Please select a week to edit");
                int index = this.weekSelect();

                if(index >= 0){

                    // open the menu of that week
                    this.weekList.get(index).menu();
                } else {
                    System.out.println("Invalid week inputed. Returning to main menu");
                } // end inner if/else

            } else if(response.equals("5")){
                    
                // delete a week
                System.out.println("Please select a week to DELETE");
                int index = this.weekSelect();

                // check if the response was valid
                if(index >= 0){

                    // delete the week
                    this.deleteWeek(index);

                } else {

                    System.out.println("Invalid week. Nothing was deleted");
                } // end inner if/else

            } else if(response.equals("6")){
                // delete a week
                System.out.println("Please select the first week to select");
                int firstIndex = this.weekSelect();

                System.out.println("Please select the second week to compare");
                int secondIndex = this.weekSelect();
                
                // check if the response was valid
                if(firstIndex >= 0 && secondIndex >= 0){

                    // get the week
                    Week week1 = this.weekList.get(firstIndex);
                    Week week2 = this.weekList.get(secondIndex);
                    this.compareWeeks(week1, week2);
                } else {

                    System.out.println("Invalid week selected. Nothing was selected");

                } // end inner if/else
            } else { 

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while
    } // end menu

    @SuppressWarnings("unchecked")
    public void load(){

        // load up any data that already exists
        try{

            FileInputStream fIn = new FileInputStream("campData.dat");
            ObjectInputStream obIn = new ObjectInputStream(fIn);
            this.weekList = (ArrayList<Week>)obIn.readObject();

        } catch(Exception e){

            // if there is an error, print it here
            System.out.println("Loading ERROR: " + e.getMessage());
            System.out.println("Deleting and resetting campData.dat");

            // try to reset the file
            this.resetFile();

        } // end try/catch blocks
    } // end load

    public void resetFile(){
        try{

            // create a new dogList.dat file
            File newFile = new File("campData.dat");
            newFile.createNewFile();

            // create a new dog to go in the dogs list
            Week newWeek = new Week();
            newWeek.setID(1);
            this.weekList.add(newWeek);

        } catch(Exception e){

            System.out.println("ERROR Resetting file: " + e.getMessage());
            System.out.println("Unable to run this program on this machine, shutting down...");
            System.exit(1);

        } // end try/catch
     } // end resetFile

    @SuppressWarnings("unchecked")
    public void save(){

        // try to save any data that is in users
        try {

            FileOutputStream fOut = new FileOutputStream("campData.dat");
            ObjectOutputStream obOut = new ObjectOutputStream(fOut);
            obOut.writeObject(this.weekList);

        } catch(Exception e){

            // if there is an error, print it here
            System.out.println("Saving ERROR: " + e.getMessage());

        } // end try/catch blocks
    } // end save

    public void sortWeeks(){

        // use an insertion sort to sort each week by their id
        // begin with a for loop to go over the arrayList
        for(int i = 0; i < this.weekList.size() - 1; i++){
            
            // set the value of j here
            int j = i;

            // initialize sentry variable
            boolean keepGoing = true;

            // while loop wil lkeep switching until an element is in the proper place
            while(keepGoing){

                // if the current j id value is greater than the next one, swap
                if(this.weekList.get(j).getID() > this.weekList.get(j + 1).getID()){

                    // make sure j is non-negative as it loops backwards
                    if(j >= 0){
                        // swap the two elementsi
                        Week tempWeek = this.weekList.get(j);

                        // set the smaller element to the j position
                        this.weekList.set(j, this.weekList.get(j + 1));

                        // set the larger element to the proper position
                        this.weekList.set(j + 1, tempWeek);

                        // decrement j by 1
                        j--;

                    } else {

                        // end the loop when get to the end
                        keepGoing = false;

                    } // end inner if/else
                } else {
                    
                    // end the loop
                    keepGoing = false;
                
                } // end out if/else loop
            } // end while loop
        } // end for loop
    } // end sort week

    public int weekSelect(){

        // sentry variable
        boolean keepGoing = true;

        // set the default return value to -1 (invalid)
        int returnValue = -1;

        // while loop to control user input
        while(keepGoing){

            // create the new scanner for input
            Scanner input = new Scanner(System.in);
        
            // output all of the options for the units
            System.out.println("");
            System.out.println("Please select an option");

            // display a quit message
            System.out.println("0) Quit and return to the menu");

            // counter will tell the user which option to select to edit a given unit
            int counter = 1;
            for(int i = 0; i < this.weekList.size(); i++){

                // print the week numbers
                System.out.println(counter + ") Select " + weekList.get(i).getID());

                // increment counter
                counter++;
           
            } // end while loop
           
            // spacer
            System.out.println("");
            
            // define response
            Integer response;

            // since we have to turn the user's response into an int to use in the unit list, we will run the following code
            try{

                // set keepGoing to false
                keepGoing = false;

                // attempt to put the input in response
                response = input.nextInt();
                
                // check if the response is the same as the size of the dogs list
                if(response.equals(0)){
                
                    // quit
                    keepGoing = false;
                
                // note: offset response by -1 since quit is 0
                } else if(response - 1 < this.weekList.size()){

                    if(response > 0){
                        
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
                
            } catch(NumberFormatException e){

                // this exception means that an invalid answer was put in so we will clarify for the user
                System.out.println("Please input a valid number");

                // reset keepGoing
                keepGoing = true;

            } catch(Exception e){

                // if this happens we aren't sure what the error is
                System.out.println("Unexpected error. Please input a valid number.");
                System.out.println(e.getMessage());

                // reset keepGoing
                keepGoing = true;
            
            } // end try/catch blocks
        } // end while loop 

        // return the value
        return returnValue;
    } // end weekSelect




} // end main
