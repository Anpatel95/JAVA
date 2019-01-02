

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Node {
	//Initialize all variables and node
	Node head;
	Node next;
	private String fName;
	private String lName;
	private int stdnum1;
    private int[] tst;
    private int size;
	


	     public Node(int num, String fN, String lN, int[] scr) {
					// TODO Auto-generated constructor stub
				
	    	    head = null;
				fName = fN;                 // initialize data
			    lName = lN;   
			    tst = scr;
			    stdnum1 = num;
			   }

	     public boolean isEmpty()       // true if list is empty
	      {
	      return (head==null);
	      }

	/* Inserts a new Node at front of the list. */
			public void push( int num, String fN, String lN, int[] src)
			{
			/* 1 & 2: Allocate the Node &
					Put in the data*/
			  Node new_node = new Node(num, fN, lN, src);
		
			/* 3. Make next of new Node as head */
			  new_node.next = head;
		
			/* 4. Move the head to point to new Node */
			  head = new_node;
			  size++;
		   }

/* Given a reference (pointer to pointer) to the head of a list
and a position, deletes the node at the given position */
			public	void deleteNode(int position)
				{
					// If linked list is empty
					if (head == null)
						return;
				
					// Store head node
					Node temp = head;
				
					// If head needs to be removed
					if (position == 0)
					{
						head = temp.next; // Change head
						return;
					}
				
					// Find previous node of the node to be deleted
					for (int i=0; temp!=null && i<position-1; i++)
						temp = temp.next;
				
					// If position is more than number of ndoes
					if (temp == null || temp.next == null)
						return;
				
					// Node temp->next is the node to be deleted
					// Store pointer to the next of node to be deleted
					Node next = temp.next.next;
				
					temp.next = next; // Unlink the deleted node from list
				}

/* This function prints contents of linked list starting from
	the given node */
			public void printList()
			{
				Node tnode = head;
				int count = 1;
				
				
				while (tnode != null)
				{
					
					System.out.print("   \t"+tnode.stdnum1+" \t  "+  tnode.lName+", \t\t "+ tnode.fName  +", " );
					
					for(int y = 0; y<tnode.tst.length; y++) {
						
				    	  System.out.print("\t "  + "  ("+count+ ")  ".trim()  +tnode.tst[y]);
				    	  count++;
				      }
					System.out.println("");
					tnode = tnode.next;
					count = 1;
				}//end while
			}//end print list
			
			
			//will find index of the key
			public int indexof(Object key) {
				Node tnode = head;
				
				for(int x = 0; x < size; x++) {
					
						if(key.equals(tnode.stdnum1)) {
							return x;
						}
					
				
				tnode = tnode.next;
				}
				return -1;
				
			}
			
			//find the first name
			 public String fnames() {
				   String first;
				   Scanner  Keyboard =new Scanner(System.in); 
				   System.out.println("Enter students first Name:-");
				   first = Keyboard.nextLine();
				return first;
				   
			   }
			 
			 //finding the last name
			   public String lnames() {
				   String  last;
				   Scanner  Keyboard = new Scanner(System.in); 
				   System.out.println("Enter students last Name:-");
				   last = Keyboard.nextLine();
				 
				return last;
				   
			   }
			   //getting the test scores
			   public int[] scores() {
				   int[] test = new int[3];
				   int score;
				   Scanner  Keyboard =new Scanner(System.in);
				   int counter = 1;
				   for(int x = 0; x < test.length; x++) {
					  
		 			  System.out.println("Enter the test score " + counter + ": -");
		 			  score = Keyboard.nextInt();
		 			  test[x] = score; 
		 			  counter++;
		 		  }
				   counter = 1;
				return test;
			
			   }
			
			
}//end class
