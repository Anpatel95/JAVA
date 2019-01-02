import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//An Patel
//3/8/2017
//This program will read the data from the file and then find the total of the all test, adjust the total, and average of all.
//LAB05
public class Lab05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//it will scan the date from input file
		// TODO Auto-generated method stub
	
		
				int[] tests = new int[10];//intialize 10 elements array for test
				int studentId;// int student ID
				int count=0;// it count how many students are there
				
				//it will scan the date from input file
				Scanner fileStudentsIn = new Scanner(new FileReader("Lab05StudentFile.txt"));
						
						
						
				//it generate the text file for output
				PrintWriter reportFile2 = new PrintWriter("Lab05Report.txt");
				
				//text results
				reportFile2.println("                                    Results");
				//makes fence 
				makefence(reportFile2);
				
				//heading student no.
				reportFile2.print("Student#");
				
				
				//heading 10 "test"
				for(int n = 1; n<=10; n++){
					reportFile2.printf("Test%-2s" , n );
				}
				
				
				//heading for Total adjust total and average
				reportFile2.printf("%10s","   Total  Adj Total  Avg");
				reportFile2.println("");
				
				//make fence look good
				makefence(reportFile2);
				
				//loop to read data 
				while(fileStudentsIn.hasNext()){
					
					
					//read the student Id
					studentId = fileStudentsIn.nextInt();
				//it creates the array 
					  for (int y = 0; y<10; y++){
					      
					tests[y] = fileStudentsIn.nextInt();
					  }//end for loop
					  
					  //send the test array and student ID to Class.
					Students report = new Students(studentId, tests);
					
					
						// get the 10 element array form the class
						int[] catchingArray = report.getStudentGradeArray();
						reportFile2.printf("%-2s ",report.getStudentId() );
						
						
						//display the array
						for(int a = 0; a<10;a++){
						reportFile2.printf("%6s",  catchingArray[a]);
						}
						
						
						
						
						//Display the Total of the test score
						reportFile2.printf("%10s", report.getTotal());
						//display the adjust total
						reportFile2.printf("%8s", report.adjusttotal());
						//display the average.
						reportFile2.printf("%9s", report.getAvg());
						
						reportFile2.println("");
					 
					
						
					count++;
					 
				}//end while
				
				
				makefence(reportFile2);
				
				reportFile2.printf("Total Students:- %5s%n",count);
				
				reportFile2.printf("%20s%n", "Report produced by: An Patel");
				
				System.out.print("Report generating process has be COMPLETED");
				//closing file
				fileStudentsIn.close( );
				reportFile2.close( );
				
				//it will open the file automatically
				Desktop.getDesktop().edit(new File("Lab05Report.txt"));
				System.exit(0);

				
				
			
			}//end main
	
	//display the "-"
	public static void makefence(PrintWriter reportFile){
		for(int x = 95; x >= 0; x--){
			
			reportFile.print("-");
			
		}
		reportFile.println("");

	}//end method
	

}
