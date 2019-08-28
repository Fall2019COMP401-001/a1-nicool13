package a1;

import java.text.DecimalFormat;
import java.util.Scanner;


public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Stores number of items found in the store
		int items = scan.nextInt();
		
		// Creates string array that holds the name of each number
		String storeItems[] = new String[items];
		
		// Creates double array that holds the price of each number at index that corresponds to the item name in the previous array
		double itemCost[] = new double[items];
		
		// Scans through each item name and price to create both arrays
		for (int i = 0; i < items; i++) {
			storeItems[i] = scan.next();
			itemCost[i] = scan.nextDouble();
			}
		
		// Stores number of customers 
		int ppl = scan.nextInt();
		
		// String array holds the name of each customer 
		String pplName[] = new String[ppl];
		
		// Double array holds the amount of money each person spends at index that corresponds with their name in the previous array
		double pplPay[] = new double[ppl];
		
		// Loops through each customer to create name array and determine the amount of money they spent to create the pplPay array
		for (int i = 0; i < ppl; i++) {
			
			// Scans each person's first and last name and stores it in the string array
			pplName[i] = scan.next() + " " + scan.next();
			
			// Stores the number of items each person bought
			int count = scan.nextInt();
			
			// For loop cycles through each item
			for (int j = 0; j < count; j++) {
				
				// Stores the amount of that item the person bought 
				int multiple = scan.nextInt();
				
				// Stores the item's name
				String thing = scan.next();
				
				// For loop cycles through the string array of the names of items found in the store to find the item that the person has bought and determine its index
				for (int k = 0; k < storeItems.length; k++) {
					
					// Checks if the item at this index matches the item the customer is buying
					if (storeItems[k].equals(thing)) {
						
						// If the item at this index does match the customer's item, this variable finds the cost of that item in the itemCost array at the same index that its name is found at in the itemName array
						double cost = itemCost[k];
						
						// The amount of money the person has spent is determined by multiplying the cost of the item by the quantity of the item that the customer bought and adding it to however much money they have already spent
						pplPay[i] += multiple * cost;
						
						// The if statement at line 61 cannot be true more than once so this line terminates the for loop by assigning to k a value that is outside of the for loop's range
						k = storeItems.length;
					}
				}
				
			}
		}
		
		// Closes scan
		scan.close();
		
		
		// Helper methods that determine the biggest/smallest spenders and the average amount of money spent and print the desired output
		biggest(pplName, pplPay);
		smallest(pplName, pplPay);
		average(pplPay, ppl);
		
	}	
	
	/* biggest
	 * 
	 * Determines the biggest spender by comparing each value of a double array that holds how much each customer spent and storing the index at which the greatest value occurs
	 * 
	 * Input: String array of customer names, double array of customer's spending totals
	 * 
	 * Output: Prints a line that states the customer's name and their spending total at the determined index
	 * 
	*/
	static void biggest(String[] names, double[] pays) {
	
		int i = 1;
		int person = 0;
		while (i <= names.length - 1) {
			if (pays[i] < pays[person]) {
				i++;
			} else {
				person = i;
				i++;
			} 
		}
	
		DecimalFormat df2 = new DecimalFormat("0.00");
	
		System.out.println("Biggest: " + names[person] + " (" + df2.format(pays[person]) + ")");
	
	}
	
	/* smallest
	 * 
	 * Determines the smallest spender by comparing each value of a double array that holds how much each customer spent and storing the index at which the smallest value occurs
	 * 
	 * Input: String array of customer names, double array of customer's spending totals
	 * 
	 * Output: Prints a line that states the customer's name and their spending total at the determined index
	 * 
	*/
	
	 static void smallest(String[] names, double[] pays) {
		
		int i = 1;
		int person = 0;
		while (i <= names.length - 1) {
			if (pays[i] > pays[person]) {
				i++;
			} else {
				person = i;
				i++;
			}
		}
		
		DecimalFormat df2 = new DecimalFormat("0.00");

		
		System.out.println("Smallest: " + names[person] + " (" + df2.format(pays[person]) + ")");
		
		
		}
	 
	 	/* average
		 * 
		 * Determines the average amount of money spent by customers by determining the sum of all of the customers' spending totals and dividing by the number of customers
		 * 
		 * Input: double array of customer's spending totals, integer number of customers
		 * 
		 * Output: Prints a line that states the average spending between all of the customers
		 * 
		*/
	 
	 static void average(double[] pays, int ppl) {
		 double sum = 0;
		 for (int i = 0; i < pays.length; i++) {
			 sum += pays[i];
		 }
		 
		 DecimalFormat df2 = new DecimalFormat("0.00");
		 
		 System.out.println("Average: " + df2.format(sum/ppl));
	 }
	
}
			
