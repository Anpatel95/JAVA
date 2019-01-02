//Lab02 Template

//Written by: An Patel
//Date written:1/29/17

//Purpose of program:It gives the stock report in .txt file. 
 
//this makes available all extra utilities from Java library including scanner
import java.util.*;

//this makes available all extras from Java library needed for files
import java.io.*;
import java.awt.*;
public class Lab02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// start of main method
				Scanner keyboard = new Scanner(System.in);
				// assigns "keyboard" to keyboard
				String ticker;
				double StockPrice = 0.0 ;
				double NumShares;
				double dividend;
				
				
				//output variable
				double Stockval ;
				double yielddiv;
				double total = 0;
				
				//it will read the file "Lab02Input"
				Scanner fileStockIn = new Scanner(new FileReader("Lab02Input.txt"));
				//Output folder
				PrintWriter reportFile = new PrintWriter("Lab02Report.txt");

				
				
				
		  		//System.out displays on the monitor
			
			//Variables and defined constants go here
				reportFile.printf("%35s%n", "Stock Report");
				
				//It print 65 "-" to look better
				for(int x = 65; x >= 0; x--){
				
					reportFile.print("-");
					
				}
				String tic = "Ticker";
				reportFile.println("");
				reportFile.printf("%-13s", "Ticker");
				reportFile.printf("%-8s", "Price");
				reportFile.printf("%-9s", "Shares");
				reportFile.printf("%-8s", "Values");
				reportFile.printf("%-10s", "Dividend");
				reportFile.printf("%-10s%n%n", "Yield");
				

			while(fileStockIn.hasNext())    //while loop to stay in loop while there are more records
			{//begin while
				
				
				
					StockPrice = fileStockIn.nextDouble();
					NumShares = fileStockIn.nextDouble();
					dividend = fileStockIn.nextDouble();
					ticker = fileStockIn.nextLine();
					
					//passing value to method
					Stockval=	setStockValue(StockPrice, NumShares);
					yielddiv = setdividend(dividend, StockPrice);
					
					
					
					
					//calculate total
					total = total + Stockval;
					total = Math.round (total * 100.0) / 100.0;
					
					
					reportFile.printf("%-10s",ticker.trim());
					reportFile.printf("%8.2f",StockPrice);
					reportFile.printf("%8.2f",NumShares);
					reportFile.printf("%10.2f", Stockval);
					reportFile.printf("%8.2f",dividend);
					reportFile.printf("%8.2f",yielddiv);
					reportFile.print("%");
					reportFile.println("");
					
				
				
			
				
				
				
			
			}//end while
			//It print 65 "-" to look better
			for(int x = 65; x >= 0; x--){
			
				reportFile.print("-");
				
			}
			//print total
			reportFile.println("");
			reportFile.printf( "          Total :-         $%.2f%n", total);
			
			
			
			reportFile.printf("%20s%n", "Report produced by: An Patel");
			
			System.out.print("Report generating process has be COMPLETED");
			//closing file
			fileStockIn.close( );
			reportFile.close( );
			
			//it will open the file automatically
			Desktop.getDesktop().edit(new File("F:\\workspace\\CISC122\\Lab02Report.txt"));
			System.exit(0);
			}//end of main
		
	//methods
	public static double setStockValue(double SPrize, double Shareown){
		//calculate stock value
		double Stockval ;
		Stockval = Shareown * SPrize;
		Stockval = Math.round (Stockval * 100.0) / 100.0;
		
		
		return Stockval;
		
		
		}
	
	public static double setdividend(double annualdivided, double StockPrize){
		// calculate yield dividend
		double yield ;
		yield = annualdivided/StockPrize;
		double peryield;
		peryield = yield*100;
		peryield= Math.round (peryield * 100.0) / 100.0;
		
		
		return peryield;
		
	}
		



		}//end of class


