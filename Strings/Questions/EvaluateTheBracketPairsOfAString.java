package Questions;

import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string
public class EvaluateTheBracketPairsOfAString {
    public static String evaluate(String s, List<List<String>> knowledge) {
        // Store key-value pairs for O(1) lookup
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge){
            map.put(pair.get(0), pair.get(1));
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < s.length()){
            if(s.charAt(i) != '('){
                sb.append(s.charAt(i));
                i++;
            }
            else{
                i++; // Skip '('

                StringBuilder key = new StringBuilder();

                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }

                i++; // Skip ')'

                String value = map.getOrDefault(key.toString(), "?");
                sb.append(value);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = List.of(List.of("name", "bob"),
                List.of("age", "two"));

        System.out.println(evaluate(s, knowledge));
    }
}
