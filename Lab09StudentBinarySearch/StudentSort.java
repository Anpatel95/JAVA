
public class StudentSort {
	//start of class
	//AN PAtel
	//class fields
		private int studentSubscript;
		private String studentName;


	//class constructor method to store value into fields when object is created
	//*********************************************************************//
		public StudentSort(int inStudentSubscript, String inStudentName)
		{//begin method

		setStudentSub (inStudentSubscript);
		setStudentName (inStudentName);

		}//end method
				
	//class default constructor method to store default value into fields when object is created
	//*********************************************************************//
		public StudentSort()
		{//begin method

		setStudentSub (0);
		setStudentName (null);

		}//end method
				
	//class methods to store value into fields
	//*********************************************************************//
		public void setStudentSub (int inStudentSubscript)
		{//begin method

		studentSubscript = inStudentSubscript;

		}//end method
		
	//*********************************************************************//	
		public void setStudentName (String inStudentName)
		{//begin method

		studentName = inStudentName;

		}//end method
			

	//*********************************************************************//
		public int getStudentSub ( )
		{//begin method

		return studentSubscript;

		}//end method

			
	//*********************************************************************//	
		public String getStudentName ( )
		{//begin method

		return studentName;

		}//end method

	}//end of class
