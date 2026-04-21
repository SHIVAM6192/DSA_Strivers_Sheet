public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(){
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full...");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Cannot pop from am empty stack!!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()){
            throw new Exception("Cannot peek from am empty stack!!");
        }
        return data[ptr];
    }


    private boolean isFull() {
        return ptr == data.length - 1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    public static void main(String[] args) throws Exception {
        CustomStack customStack = new CustomStack(5);
        customStack.push(45);
        customStack.push(89);
        customStack.push(41);
        customStack.push(11);
        customStack.push(10);

        System.out.println("Peek item :" + customStack.peek());
        System.out.println("Pop item: " + customStack.pop());

        while(!customStack.isEmpty()){
            System.out.println(customStack.pop());
        }
    }
}
