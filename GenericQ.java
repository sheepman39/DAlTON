// GenericQ.java

public class GenericQ <NodeType> {

    // mark that there should be a head and a tail here
    GenericNode <NodeType> head;
    GenericNode <NodeType> tail;

    public static void main(String[] args){

        // test code
        GenericQ <String> stringQ = new GenericQ<String>();

        stringQ.append("A");
        stringQ.append("B");
        stringQ.append("C");

        stringQ.iterate();
        System.out.println();

        GenericNode<String> poppedNode = stringQ.pop();

        String data = poppedNode.getData();
        
        // should be A
        System.out.println(data);
    
        System.out.println();

        System.out.println("Length: " + stringQ.length());
        System.out.println("0 index" + stringQ.get(0).getData());
        System.out.println("1 index" + stringQ.get(1).getData());
        System.out.println("2 index (should be null)" + stringQ.get(2));

        GenericQ<Integer> emptyQ = new GenericQ<Integer>();
        System.out.println("Length: " + emptyQ.length());
        System.out.println("0 Index: " + emptyQ.get(0));
    } // end main

    public GenericQ(){
        
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

    public GenericNode <NodeType> pop(){

        // pop the head to return the node to the user
        GenericNode <NodeType> poppedNode = null;

        // if the queue is empty, return null
        if(this.head != null){

            // set the return node to head
            // set the head to the next item
            poppedNode = this.head;
            this.head = poppedNode.getNext();

        } // end if

        // return the node
        return poppedNode;
    
    } // end pop

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

    public GenericNode <NodeType> get(int i){
        
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
}// end GenericQ     
