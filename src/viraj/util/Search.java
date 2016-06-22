package viraj.util;

import javax.swing.JOptionPane;

public class Search {
	public static void main(String [] args) {
		Search object = new Search();
		int arraysize=10000;
		int searchInt = Integer.parseInt(JOptionPane.showInputDialog("number?"));
		int [] arrays = new int[arraysize];
		arrays[0]=searchInt;
		for(int i=1;i<=arraysize-1;i++) {
			arrays[i]=viraj.util.Maths.randomIntBetween(0, 100);
		}
		
		long starTime = System.currentTimeMillis();
		object.binary(arrays, searchInt);
		long finTime = System.currentTimeMillis()-starTime;
		System.out.println("Elapsed time for binary: "+finTime+" milliseconds.");
		
		long starTime1 = System.currentTimeMillis();
		object.linear(arrays, searchInt);
		long finTime1 = System.currentTimeMillis()-starTime1;
		System.out.println("Elapsed time for linear: "+finTime1+" milliseconds.");
		
	}
	
	public void binary(int [] array, int searchInt) {
		for(int i=0;i<=array.length-1;i++) {
			System.out.println(array[i]);
		}
		array=viraj.util.Sort.insertion(array);
		
		int upperbound = array.length;
		int lowerbound = 1;
		int mid = array[array.length/2];
		
		int counter=0;
		boolean found=false;
		
		
//		System.out.println(mid);
		while(!found) {
			mid=lowerbound+(upperbound-lowerbound)/2;
			System.out.println("Step "+counter);
			if(array[mid] == searchInt) {
				found=true;
				System.out.println("found "+searchInt+" in "+counter+" steps");
				break;
				
			}
			else if (array[mid]>searchInt) {
				upperbound=mid-1;
			}
			else if(array[mid]<searchInt) {
				lowerbound=mid+1;
			}
			counter++;

		}
	}

	public void linear(int [] array, int searchInt) {
		for(int i=0;i<=array.length-1;i++) {
			if(array[i]==searchInt) {
				System.out.println("Found "+searchInt+" in spot "+i);
				break;
			}
		}
	}
}
