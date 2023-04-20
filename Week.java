// Week.java
import java.util.*;
import java.io.*;

public class Week implements Basic, Serializable{
    
    // id
    int id;

    // since each hill is not connected in any way, we will not put them in any sort of data structure.  They must be processed separately
    Hill wilderness = new Hill(0);
    Hill checaugau = new Hill(1);
    Hill pioneer = new Hill(2);

    public static void main(String[] args){
    
        Week testWeek = new Week();
        testWeek.setID(1);

        testWeek.menu();

    } // end main

    public Week(){

        // each hill has a certain number of sites assigned to them
        // Wilderness: sites 1-8
        // Checaugau: sites 9-15
        // Pioneer: sites 16-21
        int[] wildOrder = {8, 7, 1, 6, 5, 2, 3, 4};
        int[] checOrder = {9, 10, 11, 15, 14, 12, 13};
        int[] pioOrder = {17, 21, 18, 19, 16, 20};
        // we will use a for loop to assign each hill the right number of sites
        for(int i = 0; i < wildOrder.length; i++){
            
            wilderness.addItem(wildOrder[i]);

        } // end for loop

        for(int i = 0; i < checOrder.length; i++){

            checaugau.addItem(checOrder[i]);

        } // end for loop

        for(int i = 0; i < pioOrder.length; i++){

            pioneer.addItem(pioOrder[i]);

        } // end for loop

    } // end constructor
    
    public Hill getWild(){

        return this.wilderness;

    } // end getWild

    public Hill getChec(){

        return this.checaugau;

    } // end getChec

    public Hill getPio(){

        return this.pioneer;

    } // end getPio

    public int getCots(){

        // cot num will store the number of cots needed
        int cotNum = 0;

        // add them by each hill
        cotNum += wilderness.getCots();
        cotNum += checaugau.getCots();
        cotNum += pioneer.getCots();

        // return the total number of cots needed in one week
        return cotNum;

    } // end getCots()

    public int getTents(){

        // tentNum will store the number of tents needed
        int tentNum = 0;

        // add them by each hill
        tentNum += wilderness.getTents();
        tentNum += checaugau.getTents();
        tentNum += pioneer.getTents();

        // return the total number of tents
        return tentNum;

    } // end getTents()

    public int getID(){
    
        return this.id;
    
    } // end getID

    public void setID(int num){
        
        this.id = num;

    } // end setID

    public void printWeekInfo(){

        System.out.println("Information for week #" + this.getID());
        System.out.println("Total Tents: " + this.getTents());
        System.out.println("Total Cots: " + this.getCots());

    } // end getWeekInfo

    public void printAllInfo(){
        
        // print out existing info
        this.printWeekInfo(); 

        // print out each of the hills info
        this.wilderness.printAllInfo();
        this.checaugau.printAllInfo();
        this.pioneer.printAllInfo();

    } // end getAllInfo

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
            System.out.println("Menu for week " + this.id);
            System.out.println("0) Quit");
            System.out.println("1) See some info");
            System.out.println("2) See all info");
            System.out.println("3) Edit Wilderness");
            System.out.println("4) Edit Checaugau");
            System.out.println("5) Edit Pioneer");

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
                this.printWeekInfo();

            } else if(response.equals("2")){
                
                // print all of the info
                this.printAllInfo(); 

            } else if(response.equals("3")){

                // edit the wilderness hill
                System.out.println("Now editing Wilderness...");
                this.wilderness.menu();

            } else if(response.equals("4")){
            
                // edit the checaugau hill
                System.out.println("Now editing Checaugau...");
                this.checaugau.menu();

            } else if(response.equals("5")){
            
                // edit the pioneer hill
                System.out.println("Now editing Pioneer...");
                this.pioneer.menu();

            } else {

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while
    } // end menu


} // end Week
