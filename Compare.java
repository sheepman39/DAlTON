
// Compare.java
import java.io.*;

public class Compare {

    GenericQ<int[]> needQ = new GenericQ<int[]>();
    GenericQ<int[]> hasQ = new GenericQ<int[]>();

    public static void main(String[] args) {
    } // end main

    public Compare() {
    } // end constructor

    public void init(GenericQ<int[]> needQ, GenericQ<int[]> hasQ) {

        // set the queues to the ones provided
        this.needQ = needQ;
        this.hasQ = hasQ;

    } // end init

    public void move(int[] need, int[] has, String type, PrintWriter output) {

        // check if need or has is null
        if (need == null) {
            
            // define the currentSet of values
            int[] currentSet = has;

            // use a loop to find all of the site that has materials left
            while (currentSet != null) {

                output.println("Site " + currentSet[0] + " has " + Math.abs(currentSet[1]) + " extra " + type);
                currentSet = this.hasQ.pop();

            } // end while loop

        } else if (has == null) {
            
            // define the currentSet of values
            int[] currentSet = need;

            // use a loop to find all of the sites that need materials
            while (currentSet != null) {

                output.println("Site " + currentSet[0] + " has " + Math.abs(currentSet[1]) + " extra " + type);
                currentSet = this.needQ.pop();

            } // end while loop

        } else if (Math.abs(need[1]) > Math.abs(has[1])) {

            // move all of the materials from the site that has them to the site that needs them
            output.println("Move " + Math.abs(has[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);
            need[1] = need[1] + has[1];
            has[1] = 0;

            // recursion
            this.move(need, hasQ.pop(), type, output);

        } else if (Math.abs(need[1]) == Math.abs(has[1])) {

            // if the need and the has contain the same amount, set them both to 0
            output.println("Move " + Math.abs(has[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);

            need[1] = 0;
            has[1] = 0;

            // recursion
            this.move(needQ.pop(), hasQ.pop(), type, output);

        } else if (Math.abs(need[1]) < Math.abs(has[1])) {

            output.println("Move " + Math.abs(need[1]) + " " + type + " from site " + has[0] + " to site " + need[0]);

            // set the has to has + need and need to 0
            has[1] = need[1] + has[1];
            need[1] = 0;

            // recursion
            this.move(needQ.pop(), has, type, output);

        } // end if/else block
    } // end move
} // end Compare
