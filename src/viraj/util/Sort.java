package viraj.util;

public class Sort {
	public static void main(String [] args) {
		int [] f= {15,5,4,9,7,6,3,1,12,64,87};
		for(int i=0;i<=f.length-1;i++) {
			System.out.println(f[i]);
		}
		System.out.println();
		selection(f);
	}
	
	public static int[] insertion(int [] numbers){
		int placeHolder=0;
		
		for(int i=0;i<=numbers.length-1;i++) {
			for(int j=i;j>0;j--) {
				if(numbers[j]<numbers[j-1]) {
					placeHolder=numbers[j];
					numbers[j]=numbers[j-1];
					numbers[j-1]=placeHolder;
				}
			}
		}
		return numbers;
	}
	
	public static int[] selection(int [] unsorted) {
		int counter=unsorted.length;
		int length=unsorted.length;
		int [] sorted = new int[length];
		int currentMin=10000000;
		
		for(int i=0;i<=unsorted.length-1;i++) {
			currentMin=1000000000;
			for(int q=unsorted.length-counter;q>=0;q--) {
				if(unsorted[q]<currentMin) {
					currentMin=unsorted[q];
				}
			}
			counter--;
			sorted[i]=currentMin;
			System.out.println(currentMin);
		}
		
		System.out.println("Sorted:");
		for(int i=0;i<=unsorted.length-1;i++) {
			System.out.println(sorted[i]);
		}
		return sorted;
	}
}
