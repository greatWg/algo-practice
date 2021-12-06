public class ALinkedList {
    Node head ;

    public ALinkedList (Node head ){
        this.head= null;
    }

    void addFirst( int value){
        Node newNode  = new Node(value);
        if (this.head != null){
            newNode.next= head;
        }
        head = newNode;
    }

    void addLast(int value){
        Node newNode  = new Node(value);
        Node currentNode = head;

        while(currentNode.next != null){
            currentNode= currentNode.next;
        }
        currentNode.next= newNode;
    }

    void clear(){
        this.head= null;
    }

    int indexOf(int value){
        int index=0 ;
        Node currentNode= head;
        while (currentNode.next != null){
            if (currentNode.value == value){
                return index;
            }else{
                currentNode= currentNode.next;
                index++;
            }
        }
        if( currentNode.value== value) {
            return index;
        }
        return -1 ;
    }
}
