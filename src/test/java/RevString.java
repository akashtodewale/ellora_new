

import org.testng.annotations.Test;

public class RevString {

public static void main(String[] args) {
		// TODO Auto-generated method stub
    String Test = "Akash Todewale";
    String reversed = "";
    String rev= "";
		for (int i=Test.length()-1; i>=0; i--)
		{
			
			reversed += Test.charAt(i);
		}
		
		System.out.println("Reversed string is  " +  reversed);
		
		//by using simple for loop instead of reverse for loop
		
		for (int j=0; j<Test.length();j++) {
			
			rev = Test.charAt(j)+ rev;
		}
		System.out.println("Reversed string is  " +  rev);
	}




}
