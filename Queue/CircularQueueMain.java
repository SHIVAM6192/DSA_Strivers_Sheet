public class CircularQueueMain {
    public static void main(String[] args) throws Exception {
//        CircularQueue queue = new CircularQueue(5);
//        queue.insert(89);
//        queue.insert(10);
//        queue.insert(45);
//        queue.insert(15);
//        queue.insert(20);
//
//        System.out.println("Front: " + queue.front());
//        queue.display();
//        System.out.println("Removed Item: " + queue.remove());
//        System.out.println("Front: " + queue.front());
//        queue.display();
//        System.out.println("Insert Item: " + queue.insert(4));
//        System.out.println("Front: " + queue.front());
//        queue.display();
//        System.out.println("Front: " + queue.front());
//        System.out.println("Front: " + queue.front());
//        queue.display();


        DynamicQueue queue = new DynamicQueue(5);
        queue.insert(89);
        queue.insert(10);
        queue.insert(45);
        queue.insert(15);
        queue.insert(20);
        queue.insert(72);
        queue.insert(99);

        System.out.println("Front: " + queue.front());
        queue.display();
        System.out.println("Removed Item: " + queue.remove());
        queue.insert(88);
        queue.insert(46);
        System.out.println("Front: " + queue.front());
        queue.display();



    }
}
