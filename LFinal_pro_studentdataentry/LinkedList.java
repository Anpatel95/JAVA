import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LinkedList {

		public static void main(String[] args) throws IOException
		{
			/* Start with the empty list */
			Node theList = new Node(0, null, null, null);
						
			
		      int[] test = new int[3];
		      int std = 0, stdnum;
		      boolean info = true;
		      
		      Scanner  Keyboard =new Scanner(System.in);
		   
		      
		      
		      String rec = userchoi();
			     
		      while(info == true) {
		    	  
		      if(rec == "done") {
		    	  System.out.println("Thank You!");
		    	  info = false;
		    	  break;
		      }
		      else {
		    	    
		      switch(rec){
		      case "ins" : //insert students information
		    	
		    	  System.out.println("How many students you want to insert");
		    	  
		    	  std = Keyboard.nextInt();
		    	 
		    	
			  
			      
		    	  for(int y = 1; y<=std; y++) {
		    		  stdnum = (int) (Math.random() * 100);
		    	      String fname =  theList.fnames();
			    	  String lname =  theList.lnames();
			    		 
			    		  
			    		  
			    		test = theList.scores();
			    		  
			    		  System.out.println("Your data is successfully inserted");
			    		  theList.push(stdnum , fname,   lname, test);
			    		 
		    	  } 
		    	  break;
		      case "del" : //to delete students information
		    	  	int key;
			         System.out.println("Enter Student nu. who want to delete: - ");    
			         key = Keyboard.nextInt();
			         int indx = theList.indexof(key);
			         System.out.println("Deleted");
			         theList.deleteNode(indx);
			        
		    	  break;   	  
		    	  
		      case "dis" :	//displaying case
		    	 
		    	  
		    	  if(!theList.isEmpty()) {
		    		  System.out.println("Student No" + "    Last Name "  + "   First Name" +"             1st to 3rd test Scores"   );
		    		  theList.printList();
		    	  }else {
		    		  System.out.println("No student data is inserted");
		    	  }//ends if else
		    	  break;
		    	  
		    	  
		    	  
		    	  
		      case "done" : //to exit 
		    	  System.out.println("Thank You!");
		    	  info = false;
		    	  break;
		      }//end case
		      }//end if
		       
		      rec = userchoi();
		     
		  }//end while
			
			
		}//end main
		
		
		public static String userchoi() {
			Scanner  Keyboard =new Scanner(System.in);  
			
			String user1, user2;
			System.out.print("Hey there, what would you like to do; type, Ins for Insert, Del to delete, "
	                  + "Edt to Edit, Dis to display, or type Done if nothing else you what to do    ");
			user1 = Keyboard.nextLine();
			user2 = user1.toLowerCase();
			return user2;
			
		}
}//end class