package AVL;

public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();

        for(int i = 0; i< 5; i++){
            avl.insert(i);
        }
        System.out.println(avl.height());

//        avl.display();
    }
}
