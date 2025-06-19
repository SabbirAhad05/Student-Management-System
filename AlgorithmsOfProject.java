package project207;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlgorithmsOfProject {
	StudentNode start;
	//COMSTRUCTOR: 
	AlgorithmsOfProject(){
		start=null;
		
	}
	//GET NODE FUNCTION: 
	public StudentNode getNode(){
		Scanner input=new Scanner(System.in);
		StudentNode sn=new StudentNode();
		 boolean continueInput = true;
		 do {
			 try {
		 
		System.out.println("****************************");
		System.out.println("Enter Name of student: ");
		sn.name=input.nextLine();
		sn.roll=(int)(Math.random()*1000);
		System.out.println("Course which is enrolled: ");
		sn.course=input.nextLine();
		System.out.println("Enter Marks: ");
		sn.mark=input.nextDouble();
		System.out.println("Enter total CGPA: ");
		sn.cgpa=input.nextDouble();
		sn.left=null;
		sn.right=null;
		System.out.println("****************************");
		continueInput=false;
			 }
			 catch(InputMismatchException ex) {
				 System.out.println("Try again...Incorrect input");
				 input.nextLine();
			 }
			 
		 }
		 while (continueInput);
		 return sn;
	}
	
	//INSERT STUDENTS: 
	void insertRecord() {
		StudentNode sn=getNode();
		 StudentNode temp = start;
		if(start==null) {
			start=sn;
		}
		else {   
			boolean flag=true;
			while(flag) {
			
			if(sn.roll<temp.roll) {
				if(temp.left==null) {
					temp.left=sn;
				flag=false;
					
				}else {
					temp=temp.left;
				}
			}
			else if(sn.roll>temp.roll) {
				if(temp.right==null) {
					temp.right=sn;
					flag=false;
					
				}else {
					temp=temp.right;
				}
			}else {
				System.out.println("Invalid");
				break;
				
			}
		}
		
		        }
		}

	// SEARCH STUDENT: 
	void SearchStudent(int item) {
		 StudentNode temp = start; 
		 if(temp==null) {
			 System.out.println("Not funded");
		 }else {
		 boolean flag=true;
		    while (flag) {
		    	if(temp==null) {
		    		System.out.println("Not Found");
		    		break;
		    	}
		    	else if (item == temp.roll) {
		             print(temp);
		             flag=false;
		            
		        } else if (item < temp.roll) {
		            temp = temp.left; 
		        } else {
		            temp = temp.right; 
		        }
		    }
		    
		 }
	}
	//Printing functonN: 
	void print(StudentNode temp) {
		System.out.println("****************************");
		System.out.println("The name is: "+temp.name);
		System.out.println("The roll no. is: "+temp.roll);
		System.out.println("The course he Enrolled: "+temp.course);
		System.out.println("The marks is: "+temp.mark);
		System.out.println("The CGPA is: "+temp.cgpa);
		System.out.println("****************************");
	}
	
	//Print ROLL INORDER: 
	void printInorder(StudentNode temp) {
		if(temp!=null) {
			printInorder(temp.left);
			System.out.print(temp.roll+" ");
			printInorder(temp.right);
			
		}
	
		
	}
	//Print POSTORDER: 
	void printPostorder(StudentNode temp) {
		if(temp!=null) {
			printPostorder(temp.left);
			printPostorder(temp.right);
			print(temp);
			
		}
	
		
	}
	//Print PREORDER: 
	void printPREorder(StudentNode temp) {
		if(temp!=null) {
			print(temp);
			printPREorder(temp.left);
			printPREorder(temp.right);
			
		}
	
		
	}
	//PRINT INORDER:
		void printAll(StudentNode temp) {
			if(temp!=null) {
				printAll(temp.left);
				print(temp);
				printAll(temp.right);
				
			}
		}

		 // Method to delete a student record by roll number
		 public int delete(int rollNumber) {
			 start = deleteRec(start, rollNumber); 
		     if(start !=null) {
		    	 return 0;
		     }else {
		    	 return -1;
		     }
		 }

		 
		  StudentNode deleteRec(StudentNode start, int rollNumber) {
		     if (start == null) {
		         return start; 
		     }
		     if (rollNumber < start.roll) {
		    	 start.left = deleteRec(start.left, rollNumber); 
		     } else if (rollNumber > start.roll) {
		    	 start.right = deleteRec(start.right, rollNumber); 
		     } else {
		        
		         if (start.left == null) {
		             return start.right; 
		         } else if (start.right == null) {
		             return start.left; 
		         }

		         
		         start.roll = minValue(start.right); 
		         start.right = deleteRec(start.right, start.roll);
		     }
		     return start; 
		 }

		 
		 private int minValue(StudentNode start) {
		     int minValue = start.roll;
		     while (start.left != null) { 
		         minValue = start.left.roll;
		         start = start.left;
		     }
		     return minValue; 
		 }

}
