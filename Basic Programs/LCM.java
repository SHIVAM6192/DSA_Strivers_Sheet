public class LCM {
    public static void main(String[] args) {
        System.out.println(LeastCommonMultiple(15, 25));
    }
    public static int LeastCommonMultiple(int a, int b){
        int x;
        if(a < b){
            x = a;
        }
        else {
            x = b;
        }

        while(true){
            if(x % a == 0 && x % b == 0)
                break;
            x++;
        }
        return x;
    }
}
