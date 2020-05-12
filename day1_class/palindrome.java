package day1_class;

public class palindrome {
	
	public static void main(String[] args) {
		
		 String str="malayalam", reverse = "";
	      for ( int i = str.length()- 1; i >= 0; i-- )
	         reverse = reverse + str.charAt(i);
	      if (str.equals(reverse))
	         System.out.println("Yes, Palindrome");
	      else
	         System.out.println("No, not a palindrome");
 
	}
	

}
