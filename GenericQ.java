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

        stringQ.iterate();

    } // end main

    public GenericQ(){
        
        // set the head to null for now
        this.head = null;

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
} // end GenericQ     
