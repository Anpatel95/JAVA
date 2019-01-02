import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//An Patel
//This lab will generate two report. First report is sales by product, and second is sales by quarters. Using 2D Array
//Last LAB OF the Class; LAb 10.
public class Lab10 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Scanning the file
		Scanner filedata = new Scanner(new FileReader("Lab10Input.txt"));
	
		//it generate the text file for output
		PrintWriter reportFile = new PrintWriter("Lab10Report.txt");
		PrintWriter report2File = new PrintWriter("Lab10Report2.txt");
	
		
		int[] [] quarter = new int[9] [6];//creating 2D Array 
		double percent = 0;//variable for percentage
		
		//Heading for report 1.
		reportFile.println("                      Sales report by Product");
		reportFile.print("     Product    Qtr1      Qtr2      Qtr3      Qtr4     Total  Percentage");
		reportFile.println("");	
		reportFile.println("");
		
		//Loop to get all data from txt file.
		for(int raw = 0 ; raw < 8; raw++){
			
			for(int col = 0; col < 5; col++){
				
				quarter [raw][col] = filedata.nextInt(); 
				
			 
			}
			
		}
		
		//calculating total of all raw and column
		for(int raw = 0; raw < 8; raw++){
			for(int col  = 1; col < 5 ; col++){
			quarter[raw][5] += quarter[raw][col]; 
			quarter[8][col]   += quarter[raw][col];
			quarter[8][5] += quarter[raw][col];
			
		}
			
	}
		
		//Report 1
		//Nested Loop for FIRST REPORT BY PRODUCTS
		for(int raw = 0; raw < 9; raw++){
			for(int col = 0; col < 6; col++){
				
			//calculates percentage	
			percent = (float)(quarter[raw][5] * 100)/quarter[8][5];
		
	
			//printing all data
			if(raw == 8 && col == 0){
				reportFile.println("");
				reportFile.printf("%10s", "Total");
			}else{
				
					reportFile.printf("%10s",  quarter[raw][col]);
			}
				
		
				
				
				
			
			}//end inner loop
			reportFile.printf("%8.2f%%",percent);
			reportFile.println("");
		
		}//end outer loop
		reportFile.println("     Report By:- An Patel");
		
		
		
		
		//Report 2..
		//Nested Loop for SECOND REPORT BY QUARTER
		report2File.printf("%50s %n", "  Sales Report by Quarter" );
		
	for(int col = 0; col < 6; col++){//outer loop
			//labeling quarters
			if (col ==0){
			report2File.printf("%10s", "  Quarter" );
			}else if(col == 5){
				report2File.printf("%10s", "Total" );
			}else{
				report2File.printf("%10s", "Qtr"  + col);
			}
			
			
		for(int raw = 0; raw < 9; raw++){//inner loop
				//calculating percentage
				percent = (float)(quarter[8][col] * 100)/quarter[8][5];
			
			
	
			//printing all data
			if(col == 0 && raw == 8){
				
				report2File.printf("%7s", "Total");
				
				
			}else{
				
					report2File.printf("%7s",  quarter[raw][col]);
			}
				

			
			}//inner loop end
			
				//printing percentage
				if (col == 0){
					report2File.printf("%10s", "  Percentage" );
					report2File.println("");
				}
				else if (col == 4) {
					report2File.printf("%8.2f%%",percent);
					report2File.println("");
				}else{
					report2File.printf("%8.2f%%",percent);
				}
			
			
			report2File.println("");
			
		}//outer loop end

		report2File.println("     Report By:- An Patel");
		
			 
		
		
		
				
		//closing file
		filedata.close();
		reportFile.close();
		report2File.close();
		
		//it will open the file automatically
				Desktop.getDesktop().edit(new File("Lab10Report.txt"));
				Desktop.getDesktop().edit(new File("Lab10Report2.txt"));
				System.exit(0);
	}//end main
	
	

}//end class
