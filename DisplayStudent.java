package project207;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayStudent {

	public static void main(String[] args){
		AlgorithmsOfProject aop=new AlgorithmsOfProject();
		Scanner input=new Scanner(System.in);
		 boolean continueInput = true;
		 do {
			 try {
		
		boolean flag=true;
		while(flag) {
			System.out.println("Press 1: To Insert");
			System.out.println("Press 2: Print All student");
			System.out.println("Press 3: To Search");
			System.out.println("Press 4: To delete");
			System.out.println("Press 0: Exit");
			int userInput=input.nextInt();
			if(userInput==1) {
				aop.insertRecord();
				
			}
			else if(userInput==2) {
				if(aop.start==null) {
					System.out.println("Record is Empty");
				}else {
				System.out.println("All Students Information in InOrder: ");
				aop.printAll(aop.start);
				System.out.println(" ");
				System.out.println("All Students Information in PreOrder: ");
				aop.printPREorder(aop.start);
				System.out.println(" ");
				System.out.println("All Students Information in PostOrder: ");
				aop.printPostorder(aop.start);
			}
			}
             else if(userInput==3) {
            	 if(aop.start==null) {
            		 System.out.println("Record is Empty");
            	 }else {
            	 System.out.println("\nRoll numbers of students");
            	 aop.printInorder(aop.start);

            	 System.out.println("\nEnter the roll for details: ");
         		int c=input.nextInt();
         		aop.SearchStudent(c);
            	 }
			}
             else if(userInput==4) {
            	 if(aop.start==null) {
          			System.out.println("Record is Empty");
          		}else {
            	 System.out.println("\nRoll numbers of students");
            	 aop.printInorder(aop.start);
            	 System.out.println("\nGive the roll no. want to delete: ");
         		int b=input.nextInt();
     
         		aop.delete(b);
         		if(aop.delete(b)==0) {
         	    System.out.println("Record Deleted Successfully");
         		}else {
         			System.out.println("Wrong roll");
         		}
   
         	}

 		}else 
 		   flag=false;
 			}
		}
		 
		 catch(InputMismatchException ex) {
			 System.out.println("Incorrect input!!! Try Again..");
			 input.nextLine();
		 }
		 
	 }
	 while (continueInput);
		
	}
}


