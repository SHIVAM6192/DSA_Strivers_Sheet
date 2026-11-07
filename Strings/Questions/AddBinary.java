package Questions;

// https://leetcode.com/problems/add-binary
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

//        while(i >= 0 || j >= 0 || carry == 1){
//            if(i >= 0)
//                carry += a.charAt(i--) - '0';
//            if(j >= 0)
//                carry += b.charAt(j--) - '0';
//            sb.append(carry % 2);
//            carry /= 2;
//        }

        while (i >= 0 || j >= 0 || sum == 1){
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            sum /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String a = "1010", b = "1011";

        System.out.println(ab.addBinary(a, b));
    }
}
