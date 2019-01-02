import java.util.*;
public class factorial
{
 
 public static void main(String[]args)
	{
 	Scanner keyIn = new Scanner(System.in);
  	int factNumber;	//number to apply factorial
	int factorial;

 	System.out.println ("\n\n\nWelcome to the Factorial program"); 
 	System.out.print ("Please enter a number to see its factorial > ");
 
	factNumber = keyIn.nextInt();

	factorial = getFactorial (factNumber);	 
	System.out.println("\n" + factNumber+ "! = "  + factorial);
 
	}

public static int getFactorial (int f)
	{
 	if (f <= 1)
		return 1;
	else
		return f * getFactorial(f -1 );

	}
}