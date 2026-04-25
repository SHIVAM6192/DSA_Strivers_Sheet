import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println("Peek: " +obj.peek());
        System.out.println("Pop:"+obj.pop());
        System.out.println("Peek: "+obj.peek());
        System.out.println("Is empty: " + obj.empty());
        obj.push(9);
        System.out.println("Peek: " +obj.peek());
        System.out.println("Pop:"+obj.pop());


    }
}
class MyQueue {
    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
