package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int items = scan.nextInt();
		String itemName[] = new String[items];
		int itemAmt[] = new int[items];
		String pplItems[] = new String[items];
		int pplAmt[] = new int[items];
		for (int i = 0; i < items; i++) {
			itemName[i] = scan.next();
			scan.nextDouble();
		}
		
		
		int ppl = scan.nextInt();
		for (int i = 0; i < ppl; i++) {
			scan.next();
			scan.next();
			int count = scan.nextInt();
			for (int j = 0; j < count; j++) {
				int amt = scan.nextInt();
				String thing = scan.next();
				pplItems[j] = thing;
				for (int k = 0; k < itemName.length; k++) {
					if (itemName[k].equals(thing)) {
						itemAmt[k] += amt;
						if (ItemCheck(pplItems, j, thing)) {
							pplAmt[k] += 1;
						}
						k = itemName.length;
					}
				}
			}
			
		}
		
		scan.close();
		
		for (int n = 0; n < items; n++) {
			if (pplAmt[n] == 0) {
				System.out.println("No customers bought " + itemName[n]);
			} else {
				System.out.println(pplAmt[n] + " customers bought " + itemAmt[n] + " " + itemName[n]);
			}
		}
		
			
	}
	
	public static boolean ItemCheck(String[] pplItems, int j, String thing) {
		for (int i = j - 1; i >= 0; i--) {
				if (pplItems[i].equals(thing)) {
					return false;
				} 
			}
		return true;
		}
		}

