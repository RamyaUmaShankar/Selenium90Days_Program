package day2_class;

public class No_Of_Uppercase_LC_Space {
	public static void main(String[] args) {
		
		String str="1. It is Work from Home  not Work for Home";
		int upperCase=0, lowerCase=0, space=0, num=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(Character.isLowerCase(str.charAt(i)))
			{
				lowerCase++;
			} else if(Character.isUpperCase(str.charAt(i)))
			{
				upperCase++;
			}else if(Character.isDigit(str.charAt(i)))
			{
				num++;
			}else
			{
				space++;
			}
				
		}
		
		System.out.println("No.of.Lowercase: " + lowerCase);
		System.out.println("No.of.Uppercase: "+ upperCase);
		System.out.println("No.of.Digits: " + num);
		System.out.println("No.of.Spaces: " + space);

	}

}
