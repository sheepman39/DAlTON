// Main.java
import java.util.*;
import java.io.*;

public class Main{

    // we will use an arraylist to handle persistent data
    ArrayList<Week> weekList = new ArrayList<Week>();

    public static void main(String[] args){
    } // end main

    public Main(){

        // try to load up any existing data
        this.load();

    } // end constructor

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
            this.weekList.add(newWeek);

        } catch(Exception e){

            System.out.println("ERROR Resetting file: " + e.getMessage());
            System.out.println("Unable to run this program on this machine, shutting down...");
            System.exit(1);

        } // end try/catch
     } // end resetFile

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

            // store the response in response
            String response = input.nextLine();

            // spacer
            System.out.println();

            // input handling
            if(response.equals("0")){

                // quit
                keepGoing = false;

            } else if(response.equals("1")){


            } else if(response.equals("2")){

            } else if(response.equals("3")){


            } else if(response.equals("4")){

            } else if(response.equals("5")){

            } else {

                // error message
                System.out.println("Please put in a valid option");

            } // end if/else block
        } // end while

} // end main
