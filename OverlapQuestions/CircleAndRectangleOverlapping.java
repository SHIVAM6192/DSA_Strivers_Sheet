// https://leetcode.com/problems/circle-and-rectangle-overlapping
public class CircleAndRectangleOverlapping {
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // nearest point
        int xi;
        int yi;

        if(x1 > xCenter){
            xi = x1;
        }
        else if(x2 < xCenter){
            xi = x2;
        }
        else{
            xi = xCenter;
        }

        if(y1 > yCenter){
            yi = y1;
        }
        else if(y2 < yCenter){
            yi = y2;
        }
        else{
            yi = yCenter;
        }

        int distance = (int)Math.sqrt((xi - xCenter)*(xi - xCenter) +
                (yi - yCenter)*(yi - yCenter));

        return distance <= radius;
    }
    public static void main(String[] args) {
        int radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        System.out.println(checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}
