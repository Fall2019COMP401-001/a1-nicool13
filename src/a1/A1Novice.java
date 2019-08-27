package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);


		// Your code follows here.
		
		
		
		// Count holds the number of people the outer "for" loop will cycle through.
		int count = scan.nextInt();
		
		// Outer for loop cycles through each customer and prints a line for each one.
		for (int i = 0; i < count; i++) {
		
			// Variable holds first character of the first name.
			char firstInitial = scan.next().charAt(0);
			
			// Variable holds last name
			String lastName = scan.next();
			
			// Declare and initialize variable to hold total cost of all the items for each person
			double total = 0.00;
			
			// Variable holds the amount of items the inner loop will cycle through  
			int items = scan.nextInt();
			
			// Inner loop cycles through each item and adds their cost to the total 
			for (int j = 0; j < items; j++) {
				
				// Holds the quantity of each item
				int multiple = scan.nextInt();
				
				// Skips the item name 
				scan.next();
				
				// Multiplies the cost of each item by its amount and add it to the total
				total += multiple * scan.nextDouble();

			}
			  
			// Creates decimal format of two decimal places
			DecimalFormat df2 = new DecimalFormat("0.00");
			
			// Prints the first initial, last name, and money paid for each person
			System.out.println(firstInitial + ". " + lastName + ": " + df2.format(total));
			
		}
		
		// Closes scan
		scan.close();
		
	}
}
