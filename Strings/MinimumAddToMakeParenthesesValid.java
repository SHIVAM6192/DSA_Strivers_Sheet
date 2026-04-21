public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args){
        String expression = "())";
        System.out.println(minAddToMakeValid(expression));
    }
    public static int minAddToMakeValid(String s) {
        int openBracket = 0;
        int res = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                openBracket += 1;
            }
            else {
                openBracket -= 1;
                if(openBracket < 0) {
                    openBracket = 0;
                    res += 1;
                }
            }
        }

        return res + openBracket;
    }
}
