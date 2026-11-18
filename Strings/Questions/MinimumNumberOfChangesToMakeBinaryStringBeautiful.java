package Questions;

// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
//    public static int minChanges(String s) {
//        int n = s.length();
//        int count = 0;
//        int changes = 0;
//        char ch = s.charAt(0);
//
//        for (int i=0; i<n; i++){
//            if (ch == s.charAt(i)){
//                count++;
//                continue;
//            }
//
//            if (count % 2 == 0){
//                count = 1;
//            }
//            else {
//                changes += 1;
//                count = 0;
//            }
//
//            ch = s.charAt(i);
//        }
//
//        return changes;
//    }

    public static int minChanges(String s) {
        int n = s.length();
        int changes = 0;

        for (int i=0; i<n; i+=2){
            if (s.charAt(i) != s.charAt(i+1))
                changes++;
        }

        return changes;
    }

    public static void main(String[] args) {
        String s = "1001";
        System.out.println(minChanges(s));
    }
}
