package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Stores the number of items found at the store
		int items = scan.nextInt();
		
		// String array stores the name of each item in the store
		String itemName[] = new String[items];
		
		// Integer array stores the amount of each item purchased at the same index as its name in itemName[]
		int itemAmt[] = new int[items];
		
		// String array stores the name of the item bought by the current customer
		String pplItems[] = new String[items];
		
		// Integer array stores the number of people that purchased each item at the same index as its name in itemName[]
		int pplAmt[] = new int[items];
		
		// Loops through each item, stores its name in itemName and skips over its price
		for (int i = 0; i < items; i++) {
			itemName[i] = scan.next();
			scan.nextDouble();
		}
		
		// Stores the number of customers
		int ppl = scan.nextInt();
		
		// Loops through each customer, skips over their first and last name, adds the amount/type of items they bought to itemAmt[] and pplAmt[]
		for (int i = 0; i < ppl; i++) {
			
			// Skip first and last name
			scan.next();
			scan.next();
			
			// Stores the number of items the customer bought
			int count = scan.nextInt();
			
			// Loops through each item
			for (int j = 0; j < count; j++) {
				
				// Stores the amount of the item the customer bought
				int amt = scan.nextInt();
				
				// Stores the name of the item the customer bought
				String thing = scan.next();
				
				// Adds the name of the item to the array that holds the customer's purchased items
				pplItems[j] = thing;
				
				// Loops through the array that holds the name of each item found at the store
				for (int k = 0; k < itemName.length; k++) {
					
					// If the item present at the current index matches the one purchased by the customer, the amount of the item purchased is added to its amount stored in the itemAmt[] at the same index as its name in storeItems[]
					if (itemName[k].equals(thing)) {
						
						// Amount of the item is added to the current amount of that item in the array
						itemAmt[k] += amt;
						
						// If itemCheck returns true the amount of people that purchased this item is increased by 1--stored at the same index as the item name and amount
						if (itemCheck(pplItems, j, thing)) {
							pplAmt[k] += 1;
						}
						
						// Ends the loop to move on to the next item the customer has purchased
						k = itemName.length;
					}
				}
			}
			
		}
		
		// Closes scan
		scan.close();
		
		// Loops through each item in storeItems[] and prints desired output detailing how many people bought each item, the amount of item that was bought, and the item name -- all of these values occur at the same index in different arrays
		for (int n = 0; n < items; n++) {
			if (pplAmt[n] == 0) {
				System.out.println("No customers bought " + itemName[n]);
			} else {
				System.out.println(pplAmt[n] + " customers bought " + itemAmt[n] + " " + itemName[n]);
			}
		}
		
			
	}
	
	/* itemCheck
	 * 
	 * Cycles backwards through the customer's list of items purchased starting at the index of the current item and attempts to match the given item name with the previous items on the customers list
	 * In the case of one person having the same item twice on their list, this method prevents counting that person twice and falsely indicating that two separate people purchased that item when reporting the number of people that bought a certain item. 
	 * 
	 * Input: String array of the items the customer has purchased, integer that specifies the index at which this item occurs in the array that holds the items this customer has purchased, String of the item's name
	 * 
	 * Output: returns true if the item on this person's list is appearing for the first time, and returns false if it has already appeared
	 * 
	*/
	
	public static boolean itemCheck(String[] pplItems, int j, String thing) {
		for (int i = j - 1; i >= 0; i--) {
				if (pplItems[i].equals(thing)) {
					return false;
				} 
			}
		return true;
		}
}

