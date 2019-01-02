import java.util.Scanner;
//Lab01 Template

//Written by: An PAtel
//Date written: 1/24/17

//Purpose of program: To find stock price and yield dividend

//this makes available all extra utilities from Java library including scanner
public class LAb01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Name;
		
		String StockName;
		String Stockticker;
		double StockPrice;
		double Shareowned;
		double annualdividend;
		
		double StockValue;
		double yielddividend;
		
		Scanner keyboard = new Scanner(System.in);
		// assigns "keyBoard" to keyboard


  		//System.out displays on the monitor


	//Variables and defined constants go here - add comments for each variable
	//Data Dictionary
	


		
		
	//instructions start here

	//input: input prompts and input of data go here
		System.out.printf("%-25s", " Enter your name:- " );
		Name = keyboard.nextLine();
		System.out.println();
		
		System.out.printf("%-25s"," Enter Stock name:- ");
		StockName = keyboard.nextLine();
		
		System.out.printf("%-25s"," Enter Stock ticker:- ");
		Stockticker = keyboard.nextLine();
		
		System.out.printf("%-25s"," Enter Stock price:- ");
		StockPrice =keyboard.nextDouble();
		
		System.out.printf("%-25s"," Enter Shares owned:- ");
		Shareowned = keyboard.nextDouble(); 
		
		System.out.printf("%-25s"," Enter annual dividend:- ");
		annualdividend = keyboard.nextDouble();
		System.out.println();


	//process: calculations, process or calls to methods go here
		//example:
		//To round stockPrice to the nearest thousandth (three decimal places)
	

	//output: monitor display goes here
		
	StockValue=	setStockValue(StockPrice, Shareowned);
	yielddividend = setdividend(annualdividend, StockPrice);
	printMsg(" Stock value:- " , StockValue, ',');
	printMsg(" Dividend yield:- " , yielddividend, '%');
	System.out.println();
	System.out.println(" Program completed, Thanks " + Name);
	
	}//end of main

//methods go here
	public static double setStockValue(double SPrize, double Shareown){
		double Stockval ;
		Stockval = Shareown * SPrize;
		Stockval = Math.round (Stockval * 100.0) / 100.0;
		
		
		return Stockval;
		
		
		}
	
	public static double setdividend(double annualdivided, double StockPrize){
		
		double yield ;
		yield = annualdivided/StockPrize;
		double peryield;
		peryield = yield*100;
		peryield= Math.round (peryield * 100.0) / 100.0;
		
		
		return peryield;
		
	}
	public static void printMsg(String word, double amount, char x){
		
		System.out.printf("%-23s", word );
		System.out.printf("%8.2f", amount);
		System.out.print(x);
		System.out.print("\n");
		
		
		
	}
	
	
	

}//end of class
