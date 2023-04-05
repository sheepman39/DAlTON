// GenericNode.java

public class GenericNode <NodeType>{

    // for max compatability, each node will have a previous and anext
    NodeType data;
    GenericNode <NodeType> previous;
    GenericNode <NodeType> next;
    
    public static void main(String[] args){
        // test code

    } // end main

    public GenericNode(){
        
        // set everything as null to begin with 
        this.data = null;
        this.previous = null;
        this.next = null;

    } // end constructor
    
    public void setData(NodeType data){

        // set the data to the provided object
        this.data = data;
    
    } // end setData

    public NodeType getData(){

        // return the data to the user
        return this.data;
    
    } // end NodeType

    public GenericNode <NodeType> getNext(){
        
        // return the next node to the user
        return this.next;

    } // end getNext

    public void setNext(GenericNode <NodeType> next){

        // set the next data to the node provided
        this.next = next;

    } // end setNext

    public GenericNode <NodeType> getPrevious(){

        // return the previous node to the user
        return this.previous;

    } // end getPrevious

    public void setPrevious(GenericNode <NodeType> previous){

        // set the previous element to the node provided
        this.previous = previous;

    } // end setPrevious

} // end GenericNode
