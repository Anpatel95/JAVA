import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//An Patel
	//4/10/2017
//It does bubble sorting for average of the students. 
public class Lab07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int[] tests = new int[10];//intialize 10 elements array for test
		Students[] studentArray = new Students[16];//StudentArray
		
		
		int studentId = 0;//int student ID
        String StudentName;//name of student
		int count = 0;// it count how many students are there
		
		//it will scan the date from input file
		Scanner fileStudentsIn = new Scanner(new FileReader("Lab07StudentFile.txt"));
				
		//it generate the text file for output
		PrintWriter reportFile2 = new PrintWriter("Lab07Report.txt");
		
		//text results
		reportFile2.printf("%55s%n", " Results");
		//makes fence 
		makefence(reportFile2);	
		
		//heading student no.
		reportFile2.print("Student#");
		
      reportFile2.print("    Name         ");
		
		//heading 10 "test"
		for(int n = 1; n<=10; n++){
			reportFile2.printf("Test%-2s" , n );
		}
		
		
		//heading for Total adjust total and average
		reportFile2.printf("%10s"," Total  Adj  Avg");
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
			studentArray[count] = report;			
		
			
			
			count++;
		}//hint end loop
		
		//sorting
		bubblesort(studentArray);
		
		
		
		
		
		
		
		
      
      for(int x1 = 0 ; x1<studentArray.length;x1++){
			
			//creating new object
		Students report2 = new Students();
		   //setting equals to array of objects 
			report2 = studentArray[x1];
			
         //single instance of test scores
         tests = report2.getStudentGradeArray();
         
		   //getting the student name from method
         StudentName =  getName(report2.getStudentId());
       
			
         
         //display from all using the single instance
			reportFile2.printf("%-5s ",report2.getStudentId());
			reportFile2.printf("%-18s ", StudentName);
			
			
			//loop to display the scores
			for(int a = 0 ; a<10; a++){
			reportFile2.printf("%5s ", tests[a]);
		
			}//inner for loop
			
			
			
			reportFile2.printf("%5s",report2.getTotal());
			reportFile2.printf("%6s",report2.adjusttotal());
			reportFile2.printf("%5s",report2.getAvg());
			
			reportFile2.println("");
			
			

		 
		
			
		
	}//end output for loop

				
		makefence(reportFile2);
		
		reportFile2.printf("Total Students:- %5s%n", count);
		
		reportFile2.printf("%20s%n", "Report produced by: An Patel");
		
		System.out.print("Report generating process has be COMPLETED");
		//closing file
		fileStudentsIn.close( );
		reportFile2.close( );
		
		//it will open the file automatically
		Desktop.getDesktop().edit(new File("Lab07Report.txt"));
		System.exit(0);

		
		
	
	}//end main

	public static void bubblesort(Students[] studentArray) {
		// TODO Auto-generated method stub
				
				Students temps;//temperary object to store
				
		
				int max = studentArray.length - 2;
				int sub;
				while(max >= 0){
					sub = 0;
					
					while(sub <= max){
						
						if (studentArray[sub].getAvg() < studentArray[sub+1].getAvg()){
							
							temps = studentArray[sub];
							studentArray[sub]= studentArray[sub+1];
							studentArray[sub+1] = temps;
							
							
						}//end if statment
						sub++;//increase by one
						
					}//inner while
					
					max--;
					
				}//outer while
	}

			
			
			
			
			
			//display the "-"
			public static void makefence(PrintWriter reportFile){
					for(int x = 100; x >= 0; x--){
	
						reportFile.print("-");
	
					}
					reportFile.println("");

			}//end method
			
         
         public static String getName(int studentidPara) throws  IOException{
        
        //scan the student name file
        Scanner fileStudentsName = new Scanner(new FileReader("Lab07Names.txt"));
			//returning string
			String Studentname = " Invalid";
			boolean found = false;//
         
			while(fileStudentsName.hasNext()){
				//read the ID
			int StudentId = fileStudentsName.nextInt(); 
         //reading the name
			String name = fileStudentsName.nextLine();
         
        //comparing the student ID  
			if(studentidPara == StudentId &&  found == false){
				Studentname = name;
				found = true;
			}
				
				
			}
			//closing file and returning the name
			fileStudentsName.close();
			return Studentname;
			
			
		}

}//end class
