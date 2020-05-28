package day11_May_28;

public class Armstrong_Number {
	public static void main(String[] args) {
		
        int n, t, sum = 0;
        System.out.println("Armstrong numbers from 1 to 1000:");
        for(int i = 1; i <= 1000; i++)
        {
            n = i;
            while(n > 0)
            {
                t = n % 10;
                sum = sum + (t*t*t);
                n = n / 10;
            }
            if(sum == i)
            {
                System.out.println(i+" ");
            }
            sum = 0;
        }
	}

}
