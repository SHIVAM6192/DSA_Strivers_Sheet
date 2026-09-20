package ArrayQuestions;

import java.util.TreeMap;

public class MyCalendarI {
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendarI(){}

    public static boolean book(int startTime, int endTime) {
        // Find next event
        Integer next = map.ceilingKey(startTime);

        // check overlap with next event
        if(next != null && next < endTime){
            return false;
        }

        // Find previous event
        Integer prev = map.floorKey(startTime);

        // Check overlap with previous event
        if (prev != null && map.get(prev) > startTime) {
            return false;
        }

        // Add event
        map.put(startTime, endTime);

        return true;
    }

    public static void main(String[] args) {

        System.out.println(book(10,20));
        System.out.println(book(15,25));
        System.out.println(book(20,30));
        System.out.println(book(30,35));
    }
}
