package day11_May_28;

public class Fibonacci {
public static void main(String[] args) {
	
    int n = 10, t1 = -1, t2 = 1;
    int res[]=new int[n];
    
  for (int i = 0; i < n; i++)
    
    {
        int sum = t1 + t2;
        t1 = t2;
        t2 = sum;
        res[i]=sum;
    }

  for (int i = res.length-1; i>=0; i--) {
	  System.out.print(res[i] + " ");
	
}
}
}
