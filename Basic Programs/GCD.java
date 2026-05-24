public class GCD {
    public static void main(String[] args) {
        System.out.println(GreatestCommonDivisor(20,30));
    }
    public static int GreatestCommonDivisor(int a, int b){
        int i;
        if(a < b)
            i = a;
        else
            i = b;

        for(int j = i; j > 0; j--){
            if(a % j == 0 && b % j == 0){
                return j;
            }
        }
        return 1;
    }
}
