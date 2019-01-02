import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//An PAtel
//It has selection sorting which prints student name in acending order.
//Lab08
public class Lab08 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] tests = new int[10];//intialize 10 elements array for test
		Students[] studentArray = new Students[16];//StudentArray
		StudentSort[] nameArray =  new StudentSort[16];//Studentsort array object
		
		
		
		
		int studentId = 0;// int student ID
		int count = 0;// it count how many students are there
		
		//it will scan the date from input file
		Scanner fileStudentsIn = new Scanner(new FileReader("Lab08StudentFile.txt"));
				
		//it generate the text file for output
		PrintWriter reportFile2 = new PrintWriter("Lab08Report.txt");
		
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
			StudentSort nameObj = new StudentSort(count, getName(report.getStudentId()));
			
			
			//putting data into array object
			studentArray[count] = report;
			nameArray[count] = nameObj;

			count++;
			}//hint end loop
      
		
		
		selectionSort(nameArray);
		
		
		
		
		
		
		 for(int x1 = 0 ; x1< studentArray.length;x1++){
			
			//creating new object
		 Students report2 = new Students();
		 StudentSort nameObj2 = new StudentSort();
		 
			nameObj2 = nameArray[x1];
			//get the sub
			int sub = nameObj2.getStudentSub();
			//print the score as sub has
			report2 = studentArray[sub];
			
			
			//single instance of test scores
			tests = report2.getStudentGradeArray();
   
			
         
			//display from all using the single instance
			reportFile2.printf("%-5s ", report2.getStudentId());
			reportFile2.printf("%-18s ", nameObj2.getStudentName());
			
			
			
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
		Desktop.getDesktop().edit(new File("Lab08Report.txt"));
		System.exit(0);

		
		
	
	}//end main

	public static void selectionSort(StudentSort[] nameArray) {
		// TODO Auto-generated method stub
		
				int max = nameArray.length  - 1;
				int next  = 0;
				
				while(max >= next){
					
					StudentSort high = nameArray[next];
					int highsub = next;
					int sub  = next + 1;
					 
					while(sub <= max){
						if (nameArray[sub].getStudentName().compareTo(high.getStudentName()) < 0 ){
						//saving sub
							high = nameArray[sub];
							highsub = sub;
							
						}
						
						sub++;
						
					}//outer sub
					
					if (high.getStudentName().compareTo(nameArray[next].getStudentName() ) < 0){
						
						//swap the name
						StudentSort temp = nameArray[next];
						nameArray[next] = nameArray[highsub];
						nameArray[highsub ] = temp;
						
					}
					
					next++;
				
				}//inner sub
				
			}//end of method
	
	
			//display the "-"
			public static void makefence(PrintWriter reportFile){
					for(int x = 100; x >= 0; x--){
	
						reportFile.print("-");
	
					}
					reportFile.println("");

			}//end method
			
         
         public static String getName(int studentidPara) throws  IOException{
        
        //scan the student name file
        Scanner fileStudentsName = new Scanner(new FileReader("Lab08Names.txt"));
			//returning string
			String Studentname = " ZZZ Invalid";
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


	}//class ends

