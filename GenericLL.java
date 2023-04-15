// GenericLL.java
import java.io.*;

public class GenericLL <NodeType> extends Serializable {

    // mark that there should be a head and a tail here
    GenericNode <NodeType> head;
    GenericNode <NodeType> tail;

    public static void main(String[] args){

        // test code
        GenericLL <String> stringLL = new GenericLL<String>();

        stringLL.append("A");
        stringLL.append("B");
        stringLL.append("C");
        stringLL.append("D");
        stringLL.append("E");

        stringLL.iterate();
        System.out.println();

        System.out.println("Length: " + stringLL.length());
        System.out.println("0 index " + stringLL.get(0));
        System.out.println("1 index " + stringLL.get(1));
        System.out.println("2 index " + stringLL.get(2));

        stringLL.delete(2); // should remove C

        System.out.println();
        stringLL.iterate();

        GenericLL<Integer> emptyLL = new GenericLL<Integer>();
        System.out.println("Length: " + emptyLL.length());
        System.out.println("0 Index: " + emptyLL.get(0));
    } // end main

    public GenericLL(){
        
        // set the head to null for now
        this.head = null;
        this.tail = null;
    } // end Constructor

    public void append(NodeType data){

        // assuming that an object of the NodeType type is added, add it here
        // create a new node and add it to the end
        GenericNode <NodeType> newNode = new GenericNode<NodeType>();
        newNode.setData(data);

        // if the head is null, then there is no list existing so we kinda have to make it exist
        if(this.head == null){
           
            // the new node is the head of the list... how special!
            this.head = newNode;
            this.tail = newNode;

        } else {

            // set the next of the current node to teh new node and set the previous of the new node to the current one
            this.tail.setNext(newNode);
            newNode.setPrevious(tail);

            // set the tail to the new node now that the switch is made
            this.tail = newNode;

        } // end if/else block
    } // end append

    public void delete(int index){
        
        // get the node that we are trying to delete
        GenericNode <NodeType> targetNode = this.getNode(index);
        
        // if the queue is empty, return null
        if(this.head != null){
            
            if(targetNode == null){

                System.out.println("WARNING: Node at index " + index + " was not found.");
    
            } else {
                
                // find the nodes before and after the one we are trying to delete
                GenericNode <NodeType> previous = targetNode.getPrevious();
                GenericNode <NodeType> next = targetNode.getNext();

                // set the next and previous to the respective nodes, making the deleted node vanish into a poof of memory
                // make sure to check for null values first
                if(previous != null){
                    previous.setNext(next);
                } else {
                    this.head = next;
                } // end if/else
                if(next != null){
                    next.setPrevious(previous);
                } else {
                    this.tail = previous;
                } // end if/else
            } // end inner if/else block
        } // end if
    } // end delete

    public void iterate(){

        // start at the head
        GenericNode <NodeType> currentNode = head;

        // go through each element
        while(currentNode != null){

            // print out the data of the data in the node
            System.out.print(currentNode.getData());
            
            // go to the next node
            currentNode = currentNode.getNext();

        } // end while
    } // end iterate

    public int length(){

        // start at the head
        GenericNode <NodeType> currentNode = head;

        // set length to 0
        int length = 0;

        // go through each element
        while(currentNode != null){
            
            // increment length by 1
            length ++;
            
            // go to the next node
            currentNode = currentNode.getNext();

        } // end while
        
        // return length
        return length;
    } // end length

    public NodeType get(int i){

        // until I figure a way to handle negative indices like python, this will return null if i<0
        GenericNode <NodeType> currentNode = null;
        NodeType returnValue = null;
       
        // since it is possible for any result to be null and return an error, we will do some error handling to return a null
        try{
            if(i >= 0){
                
                // start at the head
                currentNode = head;

                // for loop to go through the list to find it
                for(int j = 0; j < i; j++){

                    // move the current node up
                    currentNode = currentNode.getNext();

                } // end for loop
                
                // after finding the right node, get the data from the node
                returnValue = currentNode.getData();

            } // end if statement
        } catch(Exception e){
            
            System.out.println("ERROR with .get(" + i + ").  Possibly an out of bounds value");
            System.out.println(e);

            returnValue = null;
        } 
        return returnValue;
    } // end get

    // note that for most cases, we want the value in the node
    // getNode is for when we want the actual node and don't really care (as much) about the data
    public GenericNode <NodeType> getNode(int i){
        
        // until I figure a way to handle negative indices like python, this will return null if i<0
        GenericNode <NodeType> currentNode = null;
        if(i >= 0){
            
            // start at the head
            currentNode = head;

            // for loop to go through the list to find it
            for(int j = 0; j < i; j++){
                
                // move the current node up
                currentNode = currentNode.getNext();

            } // end for loop
            
            // return the node at the i position
            // will return null if there is none

        } // end if statement
        return currentNode;
    } // end get
}// end GenericLL     
