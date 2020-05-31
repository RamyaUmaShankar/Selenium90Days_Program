package day12_May_29;

public class Add_Two_Matrices {
	public static void main(String[] args) {
		
		int[][] m1= {{1,2,3},{4,5,6},{7,8,9}};
		int[][] m2= {{9,8,7},{6,5,4},{3,2,1}};
		int size=m1.length;
		int[][] res=new int[size][size];
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				res[i][j]=m1[i][j]+m2[i][j];
				System.out.print(res[i][j] + " ");
			}
			System.out.println("\n");
		}
		
		
	}

}
