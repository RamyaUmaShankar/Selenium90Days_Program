package day3_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid_Email_Address {
public static void main(String[] args) {
	
	//String str="balaji.c@tunatap.co.uk";
	String str="naveen e@tl.com";
	
	String s="[a-zA-Z0-9.]+@[a-z]+.[a-z.]{2,}";
	Pattern p = Pattern.compile(s);
	Matcher m = p.matcher(str);
	System.out.println(m.matches());
	
}
}
