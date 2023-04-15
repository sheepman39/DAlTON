// Unit.java
import java.math.*;
import java.util.*;
import java.io.*;

public class Unit implements Serializable, Basic{
    
    // attributes to describe each unit
    int id;
    int youthM;
    int youthF;
    int adultM;
    int adultF;
    int extraCots;
    int extraTents;

    public static void main(String[] args){

        Unit testUnit = new Unit();
        testUnit.menu();

    } // end main

    public Unit(){

        this.id = integerInput("What is your unit number?");
        this.youthM = integerInput("How many youth (m) do you have?");
        this.youthF = integerInput("How many youth (f) do you have?");
        this.adultM = integerInput("How many adults (m) do you have?");
        this.adultF = integerInput("How many adults (f) do you have?");
        this.extraCots = integerInput("How many extra cots will you need?");
        this.extraTents = integerInput("How many extra tents will you need?");

    }// end constructor 

    public static int integerInput(String prompt){

        // sentry variable
        boolean keepGoing = true;
        
        // integer response will hold the response
        Integer response = 0;

        while(keepGoing){
            
            // create new scanner for input
            Scanner input = new Scanner(System.in);

            // print out the prompt with space
            System.out.println();
            System.out.print(prompt);

            // try/catch block to handle int input
            try{
                
                // convert input to integer
                response = input.nextInt();

                // all responses must be positive or 0
                if(response >= 0){
                    
                    // set keepGoing to false to end the loop
                    keepGoing = false;

                } else {
                
                    System.out.println("Please input a number greater than 0");

                } // end if/else block
            
            } catch (Exception e){

                // give an error message
                System.out.println("Please input a valid number");

            } // end try/catch block

        } // end while loop

        // return the response value
        return response;

    } // end integerInput


    public int getCots(){

        // total cots will be the return value
        int totalCots = this.adultM;
        totalCots += this.adultF;
        totalCots += this.youthM;
        totalCots += this.youthF;
        totalCots += this.extraCots;

        // return the value
        return totalCots;

    } // end getCots

    public int getTents(){

        // total tents will be the return value
        // since we allocate two people per tent, following certain guidelines, divide each group by 2 and take the ceiling of it so everyone can have a space. 
        int totalTents = (int) Math.ceil(this.adultM/2.0);
        totalTents += (int) Math.ceil(this.adultF/2.0);
        totalTents += (int) Math.ceil(this.youthM/2.0);
        totalTents += (int) Math.ceil(this.youthF/2.0);
        totalTents += (int) extraTents;

        // return the value
        return totalTents;

    } // end getTents

    public int getYouthM(){
        
        // return the total youth
        return this.youthM;

    } // end getYouthM

    public int getYouthF(){
        
        // return the total youth
        return this.youthF;

    } // end getYouthf
    
    public int getAdultM(){

        // return the num of adultM
        return this.adultM;

    } // end getAdultM

    public int getAdultF(){

        // return the num of adultF
        return this.adultF;

    } // end getAdultF

    public void setYouthM(int num){

        // set the number of youthM to the given amount
        this.youthM = num;

    }// end setYouthM
    
    public void setYouthF(int num){

        // set the number of youthM to the given amount
        this.youthF = num;

    }// end setYouthF

    public void setAdultM(int num){

        // set the number of youthM to the given amount
        this.adultM = num;

    }// end setYouthM   

    public void setAdultF(int num){

        // set the number of youthM to the given amount
        this.adultF = num;

    }// end setAdultF   

    public int getID(){

        // return the unit number
        return this.id;

    } // end getUnitNum

    public void setID(int num){

        // set the unit number
        this.id = num;

    } // end setUnitNum

    public void setExtraCots(int number){

        // set the number of extra cots to number
        this.extraCots = number;
   
    } // end setExtraCots
    
    public void setExtraTents(int number){

        // set the number of extra tents to the number
        this.extraTents = number;

    } // end setExtraTents

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
            System.out.println("Menu for unit #" + this.getID());
            System.out.println("0) Quit");
            System.out.println("1) Change unit num");
            System.out.println("2) Change the number of members");
            System.out.println("3) Request additional cots");
            System.out.println("4) Request additional tents");
            System.out.println("5) See all info");

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
                int num = integerInput("What would you like the new number to be?: ");
                this.setID(num);

                // confirmation message
                System.out.println("Ok your unit number is now " + this.getID());

            } else if(response.equals("2")){
                
                // change the number of members in the unit
                this.youthM = integerInput("How many youth (m) do you have?");
                this.youthF = integerInput("How many youth (f) do you have?");
                this.adultM = integerInput("How many adults (m) do you have?");
                this.adultF = integerInput("How many adults (f) do you have?");
            
            } else if(response.equals("3")){

                // change the number of needed cots
                System.out.println(this.getCots() - this.extraCots + " + " + this.extraTents + " extra requested = " + this.getCots() + " total cots");
                int num = integerInput("How many extra cots are needed? ");
                this.setExtraCots(num);
                
                // confirm message
                System.out.println("Ok you now have " + this.getCots() + " cots");

            } else if(response.equals("4")){

                // change the number of needed tents
                System.out.println(this.getTents() - this.extraTents + " + " + this.extraTents + " extra requested = " + this.getTents() + " total tents"); 
                int num = integerInput("How many extra tents are needed? ");
                this.setExtraTents(num);
            
                // confirm message
                System.out.println("Ok you now have " + this.getTents() + " tents");

            } else if(response.equals("5")){

                // print all of the information about the unit
                this.printAllInfo();

            } else {

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while
    } // end menu
    
    public void printAllInfo(){
        
        // print out the current information for the troop
        System.out.println("Information about Unit #" + this.getID());
        System.out.println("Total Cots needed: " + this.getCots());
        System.out.println("Total Tents needed: " + this.getTents());
        System.out.println("Extra requested cots: " + this.extraCots);
        System.out.println("Extra requested tents: " + this.extraTents);
        System.out.println("Total youth (m): " + this.getYouthM());
        System.out.println("Total youth (f): " + this.getYouthF());
        System.out.println("Total adults (m): " + this.getAdultM());
        System.out.println("Total adults (f): " + this.getAdultF());
    
    } // end printAllInfo   
} // end Unit
