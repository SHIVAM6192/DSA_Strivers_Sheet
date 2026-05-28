
// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];
        for(int i = 0; i < numRows; i++){
            ans[i] = "";
        }

        int i = 0;
        while(i < s.length()){
            for(int index = 0; index < numRows && i < s.length(); index++){
                ans[index] = ans[index] + s.charAt(i);
                i++;
            }
            for(int index = numRows - 2; index > 0 && i < s.length(); index--){
                ans[index] = ans[index] + s.charAt(i);
                i++;
            }
        }
        String res = "";
        for(String str : ans){
            res += str;
        }

        return res;

    }

    public static void main(String[] args) {
        ZigzagConversion con = new ZigzagConversion();

        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(con.convert(s, numRows));
    }
}
