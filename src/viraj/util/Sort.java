package viraj.util;

public class Sort {
	public static void main(String [] args) {
		int [] f= {15,5,4,9,7,6,3,1,12,64,87};
		for(int i=0;i<=f.length-1;i++) {
//			System.out.println(f[i]);
		}
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
				for(int q=0;q<=numbers.length-1;q++) {
					System.out.println(numbers[q]);
				}
				System.out.println();
			}
		}
		for(int i=0;i<=numbers.length-1;i++) {
			System.out.println(numbers[i]);
		}
		return numbers;
	}
	
	public static int[] selection(int [] unsorted) {
		int counter=unsorted.length;
		int length=unsorted.length;
		
	
		
		for(int i=unsorted.length-1; i>=1; i--) {
			int highest=unsorted[0];
			int spot = 0;
			
			for(int q=1;q<=i;q++) {
				if(unsorted[q]>highest) {
					highest=unsorted[q];
					spot=q;
				}
			}
			//swap
			int temp= unsorted[i];
			unsorted[i]=highest;
			unsorted[spot]=temp;
		}
		
		System.out.println("Sorted:");
		for(int i=0;i<=unsorted.length-1;i++) {
			System.out.println(unsorted[i]);
		}
		return unsorted;
	}
}
