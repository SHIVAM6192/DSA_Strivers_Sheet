import java.util.ArrayList;

public class StringSubsequence {
    public static void main(String[] args) {
//        subSeq("", "abc");
//        System.out.println(subSeqRet("", "abcd"));
        subSeqAscii("", "abc");
    }

    static void subSeq(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        subSeq(processed, unprocessed.substring(1));
        subSeq(processed + ch, unprocessed.substring(1));
    }

    static ArrayList<String> subSeqRet(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        ArrayList<String> left = subSeqRet(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subSeqRet(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }

    static void subSeqAscii(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        subSeqAscii(processed, unprocessed.substring(1));
        subSeqAscii(processed + ch, unprocessed.substring(1));
        subSeqAscii(processed + (ch + 0), unprocessed.substring(1));
    }
}
