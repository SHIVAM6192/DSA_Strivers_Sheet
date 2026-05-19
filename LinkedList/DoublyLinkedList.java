public class DoublyLinkedList {
    private Node head;

    public void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){     // if list is empty
            node.next = null;
            node.prev = null;
            head = node;
        }
        else {                // if list is not empty
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        Node last = head;
        while(last.next != null){      // it will go till last element from head
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        node.next = null;
    }


    public void insertAfter(int after, int val){
        if(head == null){
            System.out.println("LinkedList is empty...");
            return;
        }
        Node p = find(after);
        if(p == null){
            System.out.println(after + " does not exist...");
            return;
        }

        Node node = new Node(val);
        if(p.next != null){       // check p is not at last
            node.next = p.next;
            p.next.prev = node;
        }
        else {
            node.next = null;
        }
        p.next = node;
        node.prev = p;
    }

    public Node find(int value) {
        if(head == null){
            System.out.println("LinkedList is empty..");
            return null;
        }
        Node node = head;
        while(node != null){
            if(node.val == value){
                System.out.println("Value "+ value + " if found!");
                return node;
            }
            node = node.next;
        }

        System.out.println("Value "+ value +" not found...");
        return null;
    }


    public void display(){
        if(head == null){  // return if list is empty
            System.out.println("LinkedList is empty...");
            return;
        }
        Node node = head;
        Node last = null;  // this of print the linkedlist in reverse order
        while (node != null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("In reverse order...");
        // print in reverse order
        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }


    private class Node{
        int val;
        Node next;
        Node prev;


        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(12);
        dll.insertFirst(18);
        dll.insertFirst(12);
        dll.insertFirst(4);
        dll.insertLast(56);

        dll.display();
        dll.insertAfter(5, 26);
        dll.display();
    }
}
