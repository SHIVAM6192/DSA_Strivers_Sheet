import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-balloons/description
public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> mapFreq = new HashMap<>();

        for (char ch : text.toCharArray()){
            mapFreq.put(ch, mapFreq.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        String balloon = "balloon";

        while (true){
            for (char ch : balloon.toCharArray()){
                if (mapFreq.getOrDefault(ch, 0) > 0){
                    mapFreq.put(ch, mapFreq.get(ch) - 1);
                }
                else {
                    return count;
                }
            }
            count++;
        }
    }
}
