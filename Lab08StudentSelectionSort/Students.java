
//Student Class
public class Students {
	//class constructor 

	private int[] studentGrades = new int[10]; //create an array
	private int studentId;// student ID
	
	
	
	//class constructor 
	  
	  
	   public Students(int inStudentId, int []inStudentGrades)
	   {//begin method
	   
	   setStudentId(inStudentId);
	   setStudentGradeArray(inStudentGrades);
	
	   }//end method  

	//class default constructor    
	  public Students(){//begin method
	  int tempArray [ ] = {0,0,0,0,0,0,0,0,0,0};
	  setStudentId (0);
	  setStudentGradeArray(tempArray);
	  }//end method

	   public  void setStudentGradeArray (int [ ] inStudentGrades)
	   {//begin method
		   
		   
		   for(int c = 0; c< 10; c++)
		   {
		  studentGrades [c]=inStudentGrades[c];
	   
		   }
	   }//end method
	   //return the array of the tests
	   public int[] getStudentGradeArray(){
		 
		   return studentGrades;// returning the array of the tests
	   }
	   
	   //set studentId 
	   public void setStudentId(int studentNum){
		 
		   studentId = studentNum;
		 }
	   
	   //getting or returning student ID
	   public int getStudentId(){
		   return studentId;//returning student id
		   }
	   
	   //return the total
	   public int getTotal(){
		   int total = 0;
		   
		   for(int x= 0; x<studentGrades.length; x++){
			   
			   total += studentGrades[x];   
		   }
		   return total;//returning total
	   }
	   
	   
	   //return adjusted total the main using logic
	   public int adjusttotal(){
		   int sub = 0;
		   int high = 0;
		   int low = 100;
		   
		
		   //while loop to get highest and lowest from the array then subtract from the total
		   while(sub <studentGrades.length){
			   if (studentGrades[sub] > high){
				   high = studentGrades[sub];
			   }
			   if(studentGrades[sub]< low){
				   
				   
				   low = studentGrades[sub];
			   }
			   sub++;
			   
			   
		   }
		   
		   return  getTotal() - low + high;//returning the adj total
	   }
	   
	   //return the average to main 
	   public  int getAvg(){
		   int average;//creating variable name average
		   double avgx;
		   //cal of the average
		   avgx = adjusttotal() / 10.0;
		   avgx = Math.round(avgx);
		   average = (int)avgx;
		   
		   
		   return average;//returning average
		   
	   }
}
