package day12_May_29;

public class Transpose_Matrix {
	public static void main(String[] args) {
		int[][] m1= {{1,2,3},{4,5,6},{7,8,9}};
		int size=m1.length;
				
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				
				System.out.print(m1[j][i] + " ");
			}
			System.out.println("\n");
		}
		
	}
}

