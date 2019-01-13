package Basic;

import java.util.Scanner;

public class BangCuuChuong {
	public static Boolean checkTam(float x, float y, float z) {
		return x + y > z && x + z > y && y + z > x;
	}
	public static void main(String[] args) {

//		int n = 1;
//		Scanner sc = new Scanner(System.in);
//		
//		int arr[] = new int[5];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sc.nextInt();
//		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.printf("%d\t", arr[i]);
//		}
//		int[][] a;
		float a=3,b=4,c=55;
		if(checkTam(a, b, c)) {
			System.out.println("hehehheeh");
		}
		else {
			System.out.println("khong phai tam giac");
		}
		
		
		
	}

}
