import java.util.ArrayList;

public class Casting {
    public static void main(String[] args){
        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        System.out.println('a' + 3);
        System.out.println((char)('a' + 3));
        System.out.println("a" + 1);
        System.out.println("shivam" + new ArrayList<>());
        String ans = Integer.valueOf(04) + "" + new ArrayList<>();
        System.out.println(ans);

    }
}
