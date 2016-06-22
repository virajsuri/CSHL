package normalWork;

public class nameSort {
	
	public static void main(String [] args) {
		String [] names = {"Megan","Shaun","Vuh","Viraj","William","Reed","Daraius","Zee"};
		
		
		selection(names);
		
	}
	
	public static String[] selection(String [] unsorted) {

		String temp;
		for(int i=0;i<=unsorted.length-1; i++) {
			for(int q=i+1;q<=unsorted.length-1;q++) {
				if(unsorted[i].compareToIgnoreCase(unsorted[q])>0) {
					temp= unsorted[i];
					unsorted[i]=unsorted[q];
					unsorted[q]=temp;
				}
			}
			//swap
			
		}
		
		System.out.println("Sorted:");
		for(int i=0;i<=unsorted.length-1;i++) {
			System.out.println(unsorted[i]);
		}
		return unsorted;
	}
}
