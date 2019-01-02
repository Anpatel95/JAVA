//Lab03 Template

//Written by: An Patel
//Date written:2/13/17

//Purpose of program: Making two array and inputing data in array, and also sorting and searching in an array. 
 
//this makes available all extra utilities from Java library including scanner
import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab03 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// start of main method
				
				String ticker;// string of tickers
				double StockPrice = 0.0 ;//price of stock
				double NumShares;// number of shares
				double dividend;//double value divided
				
				
				String[] stockname = new String[30];//create array for stock name
				String[] tickerarray = new String[30];//create array for ticker
				String  Stockname; //variable for stockname in the array
				String arrayticker;// variable for ticker in the array
				String takeStockName;//to get stockname form method
				int count =0;  //increace count to save in subscript
				
				String heading = "Stock    Name                   Price   Shares   Value   Dividend  Yield";
				
				//output variable
				double Stockval ;//gives stock value
				double yielddiv;//double yield dividend
				double total = 0;//total value
				//it will scan the date from input file
				Scanner fileStockIn = new Scanner(new FileReader("Lab03Input.txt"));
				//it will scan the array input file
				Scanner fileStockArr = new Scanner(new FileReader("Lab03ArrayFile.txt"));
				
				//it generate the text file for output
				PrintWriter reportFile = new PrintWriter("Lab03Report.txt");

				while(fileStockArr.hasNext()){
					
					//reading data from array file
					arrayticker = fileStockArr.next().trim();
					Stockname= fileStockArr.nextLine().trim();
					
					
					stockname[count]= Stockname;
					tickerarray[count]= arrayticker;
			
					
					
					

				//printing the array
					System.out.printf("%-5s", tickerarray[count]);
					System.out.printf("%-5s", stockname[count]);
					System.out.println("");
					//Increment the counter
					count++;
				}
				
				
				
				
		  		//System.out displays on the monitor
			
			//Variables and defined constants go here
				reportFile.printf("%45s%n", "Stock Report");
				
				//It print 80 "-" to look better
				makefence(reportFile);
				
				//start new line
				reportFile.println("");
				//printing heading
				reportFile.printf("%-10s%n", heading);
				
				//It print 80 "-" to look better
				makefence(reportFile);
				
				
				//start new line
				reportFile.println("");
			while(fileStockIn.hasNext())    //while loop to stay in loop while there are more records
			{//begin while
				
				
				// it set set data to variables
					StockPrice = fileStockIn.nextDouble();
					NumShares = fileStockIn.nextDouble();
					dividend = fileStockIn.nextDouble();
					ticker = fileStockIn.nextLine().trim();
					
					
					
					
					//passing value to method
					Stockval=	setStockValue(StockPrice, NumShares);
					yielddiv = setdividend(dividend, StockPrice);
					
					
					
					//calculate total
					total = total + Stockval;
					
					
					
					//search for stockname
					
					takeStockName = getStockname(stockname, tickerarray, ticker ); 
					
							
							
					//printing data in file
					//array to print
						
					reportFile.printf("%-9s",ticker);
					reportFile.printf("%-20s",takeStockName);//founded array
					
					reportFile.printf("%8.2f",StockPrice);
					reportFile.printf("%8.2f",NumShares);
					reportFile.printf("%10.2f", Stockval);
					reportFile.printf("%8.2f",dividend);
					reportFile.printf("%8.2f",yielddiv);
					reportFile.print("%");
						
				
						
					
						reportFile.println("");
			
			}//end while
			
			
			
			
			//It print 80 "-" to look better
			makefence(reportFile);
			
			//print total
			reportFile.println("");
			reportFile.printf( "              Total :-                        $%.2f%n", total);
			
			
			
			reportFile.printf("%20s%n", "Report produced by: An Patel");
			
			System.out.print("Report generating process has be COMPLETED");
			//closing file
			fileStockIn.close( );
			reportFile.close( );
			
			//it will open the file automatically
			Desktop.getDesktop().edit(new File("Lab03Report.txt"));
			System.exit(0);
			}
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
			
			
			
			
				public static String getStockname(String name[], String ticker[], String stockTicker){
				boolean found = false;//boolean that conform the founded ticker
				int sub = 0;// for incrementing the subscript
				String saveitem= "Invalid"; // return string that are found
				
			
				//to find stockname in the array
				
				while( found == false && sub  < ticker.length){
					
					if ((stockTicker.equals(ticker[sub]))){
							found =true;//it will turn to true when ticker is found in the array
							saveitem = name[sub];
							
							
						}
							sub++;//increment subscript
							
							
				}
				
				return saveitem;//return the ticker
				
					
				}
				public static void makefence(PrintWriter reportFile){
					for(int x = 80; x >= 0; x--){
						
						reportFile.print("-");
						
					}
				}
				
				
		
				
				
	

}
