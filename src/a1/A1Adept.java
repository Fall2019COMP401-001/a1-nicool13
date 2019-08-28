package a1;

import java.text.DecimalFormat;
import java.util.Scanner;


public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int items = scan.nextInt();
		String storeItems[] = new String[items];
		double itemCost[] = new double[items];
		for (int i = 0; i < items; i++) {
			storeItems[i] = scan.next();
			itemCost[i] = scan.nextDouble();
			}
		
		int ppl = scan.nextInt();
		String pplName[] = new String[ppl];
		double pplPay[] = new double[ppl];
		for (int i = 0; i < ppl; i++) {
			pplName[i] = scan.next() + " " + scan.next();
			int count = scan.nextInt();
			for (int j = 0; j < count; j++) {
				int multiple = scan.nextInt();
				String thing = scan.next();
				for (int k = 0; k < storeItems.length; k++) {
					if (storeItems[k].equals(thing)) {
						double cost = itemCost[k];
						pplPay[i] += multiple * cost;
						k = storeItems.length;
					}
				}
				
			}
		}
		
		
		scan.close();
		
		
		
		biggest(pplName, pplPay);
		smallest(pplName, pplPay);
		average(pplPay, ppl);
		
	}	
	
	
 static void biggest(String[] names, double[] pays) {
	
	int i = 0;
	int person = 0;
	while (i < names.length - 1) {
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
	
	 static void smallest(String[] names, double[] pays) {
		
		int i = 0;
		int person = 0;
		while (i < names.length - 1) {
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
	 
	 static void average(double[] pays, int ppl) {
		 double sum = 0;
		 for (int i = 0; i < pays.length; i++) {
			 sum += pays[i];
		 }
		 
		 DecimalFormat df2 = new DecimalFormat("0.00");
		 
		 System.out.println("Average: " + df2.format(sum/ppl));
	 }
	
}
			
