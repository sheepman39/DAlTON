// Site.java

public class Site{
    
    // we will use a queue for the units
    GenericQ <Unit> unitQ = new GenericQ<Unit>();

    // site number
    int siteNum;

    public static void main(String[] args){

        Site testSite = new Site();

        testSite.setSiteNum(2);

        testSite.addUnit();
        testSite.addUnit();
        testSite.addUnit();

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
        this.unitQ.append(tempUnit);

    } // end addUnit

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

        for(int i = 0; i < this.unitQ.length(); i++){
            
            // get the tempNode from the queue
            Unit tempUnit = this.unitQ.get(i);

            // get the num of cots from the nodes data
            cotNum += tempUnit.getCots();
    
        } // end for loop

        // return cotNum
        return cotNum;
    } // end getCots

    public int getTents(){

        // use a for loop to get the number of cots from each unit in the queue
        int tentNum = 0;

        for(int i = 0; i < this.unitQ.length(); i++){
            
            // get the tempNode from the queue
            Unit tempUnit = this.unitQ.get(i);

            // get the num of tents from the nodes data
            tentNum += tempUnit.getTents();
    
        } // end for loop

        // return tentNum
        return tentNum;
    } // end getCots


} // end site
