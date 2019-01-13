package Basic;

import java.util.Scanner;

public class PhuongTrinhBac2 {
	@SuppressWarnings("resource")
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		//Khai báo biến 
		double a = 0, b = 0, c = 0;
		
		System.out.println("Enter the number of a, b, c: ");
		//Nhập dữ liệu tính toán
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		//Thực hiện nghiệp vụ
		double delta = b*b - 4*a*c;
		
		
		if(delta == 0) {
			if (a != 0) {
				System.out.println("x = " + c/2*a);
			}
			else {
				System.out.println("Pt vo so nghiem");
			}
		}
		else if(delta < 0) {
			//do something
		}
	}
}
