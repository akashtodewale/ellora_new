

import org.testng.annotations.Test;

public class RevString {
@Test
public static void main(String[] args) {
		// TODO Auto-generated method stub
    String Test = "Akash Todewale";
    String reversed = "";
		for (int i=Test.length()-1; i>=0; i--)
		{
			
			reversed += Test.charAt(i);
		}
		
		System.out.println("Reversed string is" +  reversed);
	}

}
