public class LinkedList {
    private Node head;
    private Node tail;

    private int size;
    public LinkedList(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if(index > size || index < 0){
            System.out.println("Index out of bound...");
            return;
        }

        if(head == null){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size += 1;
    }

    // Insert using recursion
    public void insertRecursion(int val, int index){
        if(index > size || index < 0){
            System.out.println("Index out of bound...");
            return;
        }
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public int deleteFirst(){
        if(head == null){
            System.out.println("LinkedList is empty..");
            return -1;
        }

        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }

        size -= 1;
        return val;
    }

    public int deleteLast(){
        if(head == null){
            System.out.println("LinkedList is empty..");
            return -1;
        }
        int val = tail.value;
        Node node = get(size - 2);
        tail = node;
        node.next = null;
        size -= 1;
        return val;
    }

    public int delete(int index){
        if(head == null){
            System.out.println("LinkedList is empty..");
            return -1;
        }

        if(index > size || index < 0){
            System.out.println("Index out of bound...");
            return -1;
        }

        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        size -= 1;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i = 1; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        if(head == null){
            System.out.println("LinkedList is empty..");
            return null;
        }
        Node node = head;
        while(node != null){
            if(node.value == value){
                System.out.println("Value "+ value + " if found!");
                return node;
            }
            node = node.next;
        }

        System.out.println("Value "+ value +" not found...");
        return null;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node{
        private int value;
        Node next;

        public Node(){}
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node node){
            this.value = value;
            this.next = node;
        }

    }


    // Leetcode Questions
    // Q. 83
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    // linked list values are sorted in ascending order

    public void deleteDuplicate(){
        Node node = head;

        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            } else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // Q. 21 - Merge Two Sorted Lists

    public static LinkedList mergeSortedList(LinkedList list1, LinkedList list2){
        Node first = list1.head;
        Node second = list2.head;

        LinkedList answer = new LinkedList();

        while (first != null && second != null){
            if(first.value < second.value){
                answer.insertLast(first.value);
                first = first.next;
            }
            else{
                answer.insertLast(second.value);
                second = second.next;
            }
        }

        while (first != null){
            answer.insertLast(first.value);
            first = first.next;
        }

        while (second != null){
            answer.insertLast(second.value);
            second = second.next;
        }
        return answer;
    }

    // Q. 141 - Linked List Cycle
    // https://leetcode.com/problems/linked-list-cycle/description/

//    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while(fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(fast == slow){
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertLast(1);
        l1.insertLast(3);
        l1.insertLast(5);

        LinkedList l2 = new LinkedList();
        l2.insertLast(1);
        l2.insertLast(2);
        l2.insertLast(6);
        l2.insertLast(9);

        LinkedList list = mergeSortedList(l1, l2);

        list.display();
    }

}
