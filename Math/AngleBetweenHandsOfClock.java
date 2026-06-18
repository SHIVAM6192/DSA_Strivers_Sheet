
//https://leetcode.com/problems/angle-between-hands-of-a-clock

public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        int hours = 12;
        int minutes = 30;
        System.out.println(angleClock(hours, minutes));
    }

    public static double angleClock(int hour, int minutes) {
        float h = (hour%12 + (float)minutes/60) * 30;  // 1 hour = 30 degree
        float m = minutes * 6;  // 1 minute = 6 degree

        float angle = Math.abs(h-m);
        if (angle > 180)
            return 360 - angle;

        return angle;
    }
}
