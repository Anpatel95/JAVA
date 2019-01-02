import java.util.*;
public class palindrome
{
  public static void main(String[]args)
	{//beginning of main
 	Scanner keyIn = new Scanner(System.in);
  	String word;
 	System.out.println ("\n\n\nWelcome to the Palidrome program"); 
 	System.out.print ("Please enter a word(s) to see if it's a palindrome > ");
 	word = keyIn.nextLine();
	 if (wordIsPalidrome(word))
 		System.out.println("\n" + word + " is a palindrome");
 	else
 		System.out.println("\n" + word + " is not a palindrome");
	}//end of main
public static boolean wordIsPalidrome(String sWord)
	{
 	if (sWord.length() == 0 || sWord.length() == 1)
  		 return true;
	 if(sWord.charAt(0) == sWord.charAt(sWord.length()-1))
 		return wordIsPalidrome(sWord.substring(1, sWord.length()-1));
	return false;
	}
}