package Sudoku;

import java.awt.Point;
import java.util.Scanner;


public class Sudoku {
	
	static int[][] grid = { { 2, 0, 0, 0, 0, 0, 8, 5, 3 },
			  { 0, 0, 0, 8, 0, 0, 0, 0, 4 },
			  { 0, 0, 8, 2, 0, 3, 0, 6, 9 },
			  { 5, 7, 4, 0, 0, 2, 0, 0, 0 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 0, 9, 0, 0, 6, 3, 7 },
			  { 9, 4, 0, 1, 0, 8, 5, 0, 0 },
			  { 7, 0, 0, 0, 0, 6, 0, 0, 0 },
			  { 6, 8, 2, 0, 0, 0, 0, 9, 0 } };
	
	//khai bao kich thuoc ma tran choi game
	static int dim = 9;
	//La mot o trong null
	static int Blank = 0;
	static String Line = "|";
	static String NEW_ROW = "-------------------------------------";
	//point la kieu lu~ lieu diem trong java
	static Point CheckWinGame = new Point(9,9);
	
	//Ham in ra ma tran tro choi
	static void print_game(int grid[][]) {
		for (int i = 0; i < dim; i++) {
			System.out.println("\t\t\t");
			System.out.println(NEW_ROW);
			System.out.print(Line);
			for (int j = 0; j < dim; j++) {
				System.out.print(" ");
				if (grid[i][j] == Blank) {

					System.out.print(" ");
				} else {
					System.out.print(grid[i][j]);
				}
				System.out.print(" " + Line);
			}

		}
		System.out.println("\n" + NEW_ROW + "\n");
	}
	
	//Du lieu tra ve true-false 
	//Cho biet vi tri gan tren 1 hang du lieu co bang` voi gia tri khong
	static boolean CheckRows(int grid[][], int row, int num) {
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == num)
				return true;
		}
		return false;
	}

	
	//Du lieu tra ve true-false 
	//Cho biet vi tri gan tren 1 cot du lieu co bang` voi gia tri khong
	static boolean CheckCols(int grid[][], int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == num)
				return true;
		}
		return false;
	}

	
	//Du lieu tra ve true-false 
	//Cho biet vi tri gan tren 1 hop 3*3 du lieu co bang` voi gia tri khong
	static boolean CheckBoxs(int grid[][], int row, int col, int num) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + row - row % 3][j + col - col % 3] == num)
					return true;
			}
		}
		return false;
	}
	
	//Du lieu tra ve true-false 
	// Kiem tra thoai man dieu kien tro choi theo hang, cot, hop khong?
	static boolean isSafe(int grid[][], int row, int col, int num) {
		return !CheckBoxs(grid, row, col, num) && !CheckCols(grid, col, num) && !CheckRows(grid, row, num);
	}
	
	//Tim diem con trong trong tro choi
	static Point getBankLocation(int grid[][]) {
		
	    for (int i = 0; i < dim; i++) {
	    	for (int j = 0; j < dim; j++) {
	    		if(grid[i][j] == Blank) {
	    			return new Point(i,j);
	    		}
	    	}	  
	    }
	    return CheckWinGame;
	}

	
	static boolean ResultGame(int grid[][]) {
		
		//Kiem tra neu khong con vi tri trong thi You will
		if(CheckWinGame == getBankLocation(grid)) {
			return true;
		}
		
		Point row_col = getBankLocation(grid);
		int row = row_col.x;
		int col = row_col.y;
		
		//kiem tra lan luot 1->9 cho  blank location
		for (int num = 1; num <= 9; num++) {
			if(isSafe(grid, row, col, num)) {
				
				grid[row][col] = num;
				if(ResultGame(grid)) {
					return true;
				}
				
				grid[row][col] = Blank;
				
			}
			
		}
		return false;
	}
	
	//Kiem tra nguoi choi chon dap an dung chua?
	static boolean isValid(int row, int col, int value) {
		return grid[row][col] == value;
	}
	
	static boolean ValidLocation(int row, int col) {
		return ( row < 10 && col < 10 && row >= 0 && col >= 0);
		
	}
	
	public static void main(String[] args) {

		//Khai bao bien lay du lieu ban dau cho nguoi dung choi
		int[][] matrix = new int[9][9];
		print_game(grid);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				matrix[i][j] = grid[i][j];
			}
		}
		
		Scanner sc = new Scanner(System.in);
		ResultGame(grid);
		while(CheckWinGame == getBankLocation(matrix)) {
			int i, j, value;
			do {
				System.out.print("Row:");
				i = sc.nextInt();
				System.out.print("Col:");
				j = sc.nextInt();
				System.out.print("Value:");
				value = sc.nextInt();
			}while(ValidLocation(i, j) == false);
			
			if(matrix[i][j] != 0) {
				break;
			}
			
			if (isValid(i, j, value)) {
				System.out.println("Gioi lam!! Choi tiep de ban :000");
				matrix[i][j] = value;
				print_game(matrix);
			}
			else {
				System.out.println("Sai cmnr -.- Ban choi ngu vchg");
			}
			
			
			
		}
		
		
		
		
		
		

	}

}
