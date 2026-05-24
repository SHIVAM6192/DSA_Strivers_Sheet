public class Comparison {
    public static void main(String[] args){
        String a = "Shivam";
        String b = "Shivam";
        System.out.println(a == b);

        String x = new String("Shivam");
        String y = new String("Shivam");
        System.out.println(x == y); // false
        System.out.println(x.equals(y)); // true
        System.out.println(x.charAt(0));
    }
}
