import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = "Shivam Sagar";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name.indexOf('m'));
        System.out.println(name.lastIndexOf('a'));
        System.out.println("     Shivam     ".strip());
        System.out.println(Arrays.toString(name.split(" ")));
    }
}
