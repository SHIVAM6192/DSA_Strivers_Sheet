public class DynamicStack extends CustomStack {

    public DynamicStack(){
        super();  // it will call constructor CustomStack()
    }

    public DynamicStack(int size){
        super(size);  // it will call constructor CustomStack(int size)
    }

    @Override
    public boolean push(int item){
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for (int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }

        return super.push(item);
    }

    public static void main(String[] args) throws Exception {
        DynamicStack dynamicStack = new DynamicStack(5);
        dynamicStack.push(45);
        dynamicStack.push(89);
        dynamicStack.push(41);
        dynamicStack.push(11);
        dynamicStack.push(10);
        dynamicStack.push(4);
        dynamicStack.push(18);

        System.out.println("Peek item :" + dynamicStack.peek());
        System.out.println("Pop item: " + dynamicStack.pop());



        while(!dynamicStack.isEmpty()){
            System.out.println(dynamicStack.pop());
        }
    }

}
