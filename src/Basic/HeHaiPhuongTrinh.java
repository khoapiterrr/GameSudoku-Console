package Basic;

import java.awt.Point;

public class HeHaiPhuongTrinh {
    static void divide(int a, int b, int result, int remainder) {
        result = a / b;
        remainder = a % b;
        System.out.println(a +"/"+ b + " = "+ result + 
               " r " + remainder);
    }
    public static void main(String[] args) {
    	Point ok = new Point(9,9);
    	System.out.println(ok);
    	ok.setLocation(13,4);
    	System.out.println(ok);
    }
}
