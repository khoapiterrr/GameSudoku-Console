package Basic;

import java.util.Scanner;

public class HelloJava {
	private static Scanner sc;

	public static void main (String [] args) {
		System.out.println("Hello javaaaaa");
		
		sc = new Scanner(System.in);
		int i = 0;
		i = sc.nextInt();
		System.out.println(i + 3);
		
	}

}
