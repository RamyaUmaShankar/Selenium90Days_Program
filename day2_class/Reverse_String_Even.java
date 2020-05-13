package day2_class;

public class Reverse_String_Even {
	public static void main(String[] args) {

		String str="When the world realise its own mistake, corona will dissolve automatically";
		
		String[] words = str.split(" ");
		String reverseString="";
		String r=words[0];
		
		for(int i=1; i<words.length;i++)
		{
			String word=words[i];
			String reverseWord= "";
						
			if((i%2)==1)
			{
			
			for (int j = word.length()-1; j >= 0; j--) 
			{
				reverseWord = reverseWord + word.charAt(j);
				
			}
			reverseString = reverseString + reverseWord + " ";
		
			}
			else
			{
				reverseString = reverseString + word + " ";
			
			}
			
		}
	
		System.out.println(str);
		System.out.println(r + " " + reverseString);

	}

}


