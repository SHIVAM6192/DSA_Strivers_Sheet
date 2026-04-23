public class QueueMain {
    public static void main(String[] args) throws Exception{
        CustomQueue customQueue = new CustomQueue(5);
        customQueue.insert(45);
        customQueue.insert(89);
        customQueue.insert(10);
        customQueue.insert(15);
        customQueue.insert(20);

        System.out.println("Front: " + customQueue.front());
        customQueue.display();
        System.out.println("Removed Item: " + customQueue.remove());
        System.out.println("Front: " + customQueue.front());
        customQueue.display();
    }
}
