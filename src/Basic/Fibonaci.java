package Basic;

import java.util.Scanner;
public class Fibonaci {
	static long FibonaciDQ(int n) {
		if (n < 2) return 1;
		return FibonaciDQ(n-1) + FibonaciDQ(n-2);
	}
	private static long Fibo[] = new long[2000];
	static void unit() {
		for (int i = 0; i < 2000; i++) {
			Fibo[i] = -1;
		}
	}
	
	static long FibonaciQHD(int n) {
		if(Fibo[n] < 0) {
			if(n <= 1) Fibo[n] = 1;
			else 
				Fibo[n] = FibonaciQHD(n-1) + FibonaciQHD(n-2);
		}
		return Fibo[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unit();
		Scanner sc = new Scanner(System.in);
		long a = 0, b = 1, c=1;
		for (int i = 1; i <= 1000 ; i++) {
			a = b;
			b = c;
			c = a + b;
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		for (int i=1;i<100;i++);
		
		System.out.println(FibonaciQHD(97));
		System.out.println(FibonaciQHD(98));
		
	}

}
