// Unit.java
import java.math.*;
import java.util.*;

public class Unit{
    
    // attributes to describe each unit
    int unitNum;
    int youthM;
    int youthF;
    int adultM;
    int adultF;
    int extraCots;
    int extraTents;

    public static void main(String[] args){

        Unit testUnit = new Unit();
        System.out.println(testUnit.getCots());
        System.out.println(testUnit.getTents());
    } // end main


    public Unit(){

        this.unitNum = this.integerInput("What is your unit number?");
        this.youthM = this.integerInput("How many youth (m) do you have?");
        this.youthF = this.integerInput("How many youth (f) do you have?");
        this.adultM = this.integerInput("How many adults (m) do you have?");
        this.adultF = this.integerInput("How many adults (f) do you have?");
        this.extraCots = this.integerInput("How many extra cots will you need?");
        this.extraTents = this.integerInput("How many extra tents will you need?");

    }// end constructor 

    public int integerInput(String prompt){

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

    public int getYouth(){
        
        // return the total yout
        return this.youthM + this.youthF;

    } // end getYouth

    public int getAdults(){

        // return the total adults
        return this.adultM + this.youthF;

    } // end getAdults

    public void setExtraCots(int number){

        // set the number of extra cots to number
        this.extraCots = number;
   
    } // end setExtraCots
    
    public void setExtraTents(int number){

        // set the number of extra tents to the number
        this.extraTents = number;

    } // end setExtraTents
} // end Unit
