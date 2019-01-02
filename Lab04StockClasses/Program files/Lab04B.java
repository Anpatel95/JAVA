import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//An Patel
//2/22/2017
//It will get data from another class, with calculated stock value and anual dividend
//crating object, and reference a method from a class
public class Lab04B {
	

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub

		
			
			String ticker = null;// string of tickers
			double StockPrice = 0.0 ;//price of stock
			double NumShares = 0;// number of shares
			double dividend = 0;//double value divided
			
		
		//	Lab04Objects LabB = new Lab04Objects(ticker, StockPrice, NumShares, dividend);
			
			String[] stockname = new String[30];//create array for stock name
			String[] tickerarray = new String[30];//create array for ticker
			String  Stockname; //variable for stockname in the array
			String arrayticker;// variable for ticker in the array
			String takeStockName;//to get stockname form method
			int count =0;  //increace count to save in subscript
			
			//heading of the report
			String heading = "Stock    Name                   Price   Shares   Value   Dividend  Yield";
			
			//output variable
			double Stockval ;//gives stock value
			double yielddiv;//double yield dividend
			double total = 0;//total value
			
			
			//it will scan the date from input file
			Scanner fileStockIn = new Scanner(new FileReader("F:\\workspace Java 2\\CISC122\\Lab04Input.txt"));
			//it will scan the array input file
			Scanner fileStockArr = new Scanner(new FileReader("F:\\workspace Java 2\\CISC122\\Lab04ArrayFile.txt"));
			
			//it generate the text file for output
			PrintWriter reportFile = new PrintWriter("F:\\workspace Java 2\\CISC122\\Lab04Report.txt");

			while(fileStockArr.hasNext()){
				
				//reading data from array file
				tickerarray[count]= fileStockArr.next().trim();
				stockname[count]= fileStockArr.nextLine().trim();

			//printing the array
				System.out.printf("%-5s", tickerarray[count]);
				System.out.printf("%-5s", stockname[count]);
				System.out.println("");
				//Increment the counter
				count++;
			}//while loop ends
			
			
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
				
				
				//creating object and constoctor
				
				Lab04Objects LabStock = new Lab04Objects(ticker, StockPrice, NumShares, dividend);
				
			
				
				
				
				
				
				//calculate total
				total = total + LabStock.calStockValue();
				
				//search for stockname
				takeStockName = getStockname(stockname, tickerarray, ticker ); 
				
				//getting data from object (mutator)
				reportFile.printf("%-9s",LabStock.getTicker());
				reportFile.printf("%-20s",takeStockName);//founded array
				
				reportFile.printf("%8.2f",LabStock.getStockPrice());
				reportFile.printf("%8.2f",LabStock.getNumStock());
				reportFile.printf("%10.2f", LabStock.calStockValue());
				reportFile.printf("%8.2f", LabStock.getDividend());
				reportFile.printf("%8.2f", LabStock.calyielddivi());
				reportFile.print("%");
				
					reportFile.println("");
				
				
			}//while ends
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
			Desktop.getDesktop().edit(new File("F:\\workspace Java 2\\CISC122\\Lab04Report.txt"));
			System.exit(0);
			
		}//main method ends
		
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
			
				
			}//method ends
			public static void makefence(PrintWriter reportFile){
				for(int x = 80; x >= 0; x--){
					
					reportFile.print("-");
					
				}
			}//method ends
		
	}


