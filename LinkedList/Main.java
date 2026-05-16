public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(4);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(1);




        list.display();
        list.deleteDuplicate();
        list.display();

    }
}
