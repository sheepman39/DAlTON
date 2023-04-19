// Compare.java

public class Compare{
    
    GenericQ<int[]> needQ = new GenericQ<int[]>();
    GenericQ<int[]> hasQ = new GenericQ<int[]>();


    public static void main(String[] args){} // end main

    public Compare(){} // end constructor

    public void init(GenericQ<int[]> needQ, GenericQ<int[]> hasQ){
        
        // set the queues to the ones provided
        this.needQ = needQ;
        this.hasQ = hasQ;

    } // end init


    public void move(int[] need, int[] has, String type){

        // check if need or has is null
        if(need == null){

            int[] currentSet = has;

            while(currentSet != null){

                System.out.println("Site " + currentSet[0] + " has " + Math.abs(currentSet[1]) + " extra " + type);
                currentSet = this.hasQ.pop();

            } // end while loop
        
        } else if(has == null){

            int[] currentSet = need;

            while(currentSet != null){

                System.out.println("Site " + currentSet[0] + " needs " + currentSet[1] + " more " + type);
                currentSet = this.needQ.pop();

            } // end while loop

        } else if(Math.abs(need[1]) > Math.abs(has[1])){
            System.out.println("Move " + Math.abs(has[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);
            need[1] = need[1] + has[1];
            has[1] = 0;

             // recursion
             this.move(need, hasQ.pop(), type);
        } else if(Math.abs(need[1]) == Math.abs(has[1])){
            
            // if the need and the has contain the same amount, set them both to 0
            System.out.println("Move " + Math.abs(has[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);
            
            need[1] = 0;
            has[1] = 0;

            // recursion
            this.move(needQ.pop(), hasQ.pop(), type);
            
        } else if(Math.abs(need[1]) < Math.abs(has[1])){

            System.out.println("Move " + Math.abs(need[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);
            
            // set the has to has +  need and need to 0
            has[1] = need[1] + has[1];
            need[1] = 0;
            
            // recursion
            this.move(needQ.pop(), has, type);
        } // end if/else block
    } // end move
} // end Compare
