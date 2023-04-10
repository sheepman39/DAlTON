// Site.java

public class Site{
    
    // we will use a linked list for the units
    GenericLL <Unit> unitLL = new GenericLL<Unit>();

    // site number
    int siteNum;

    public static void main(String[] args){

        Site testSite = new Site();

        testSite.setSiteNum(2);

        //        testSite.addUnit();
//        testSite.addUnit();
//        testSite.addUnit();

        System.out.println("Cots needed for site " + testSite.getSiteNum() + ": " + testSite.getCots());

        System.out.println("Tents needed for site " + testSite.getSiteNum() + ": " + testSite.getTents());


    } // end main

    public Site(){
        
        // set the siteNum to -1 initially
        this.siteNum = -1;

    } // end constructor

    public Site(int siteNum){
        
        // constructor with the site num provided
        this.siteNum = siteNum;
        
    } // end constructor

    public void addUnit(){

        // create a unit
        Unit tempUnit = new Unit();

        // append that unit to the queue
        this.unitLL.append(tempUnit);

    } // end addUnit
    
    public void deleteUnit(int i){

        // delete the unit at the given index
        this.unitLL.delete(i);

    } // end deleteUnit
    
    public void setSiteNum(int siteNum){

        // set the siteNum to the num provided
        this.siteNum = siteNum;

    } // end setSiteNum

    public int getSiteNum(){

        // return the site num
        return this.siteNum;

    } // end getSiteNum

    public int getCots(){

        // use a for loop to get the number of cots from each unit in the queue
        int cotNum = 0;

        for(int i = 0; i < this.unitLL.length(); i++){
            
            // get the tempNode from the queue
            Unit tempUnit = this.unitLL.get(i);

            // get the num of cots from the nodes data
            cotNum += tempUnit.getCots();
    
        } // end for loop

        // return cotNum
        return cotNum;
    } // end getCots

    public int getTents(){

        // use a for loop to get the number of cots from each unit in the queue
        int tentNum = 0;

        for(int i = 0; i < this.unitLL.length(); i++){
            
            // get the tempNode from the queue
            Unit tempUnit = this.unitLL.get(i);

            // get the num of tents from the nodes data
            tentNum += tempUnit.getTents();
    
        } // end for loop

        // return tentNum
        return tentNum;
    } // end getCots

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
                this.addUnit();

            } else if(response.equals("4")){
                
                // run a sub-menu to select which unit to edit
                this.unitMenu();

            } else if(response.equals("5")){

                // delete a unit
                
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
        for(int i = 0; i < unitLL.length(); i++){

            // spacer
            System.out.println();

            // each units information
            unitLL.get(i).printAllInfo();

        } // end for loop
    } // end printAllInfo

    public void unitMenu(){

        // sentry variable
        boolean keepGoing = true;

        // while loop to control user input
        while(keepGoing){

            // create the new scanner for input
            Scanner input = new Scanner(System.in);
        
            // output all of the options for the units
            System.out.println("");
            System.out.println("Please select a unit to edit");

            // display a quit message
            System.out.println("0) Quit and return to the site menu");

            // use a for loop to display options for each of the units
            for(int i = 0; i < this.unitLL.length(); i++){
                
                // print the option with the proper index
                System.out.println(i + 1 + ") Edit" + this.unitLL.get(i).getUnitNum());
            
            } // end for loop

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
                if(response.equals(this.unitLL.Length())){
                
                    // quit
                    keepGoing = false;

                } else if(response < this.unitLL.Length()){

                    if(response > 0){
                        
                        // if it is a valid index, run the menu of that unit
                        // note that it is -1 since we added 1 in the menu
                        this.unitLL.get(response - 1).menu();
                
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
    } // end unitMenu

} // end site
