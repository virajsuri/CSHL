package viraj.util;

public class Arrays {
	public static void print3DArray(String[][][] array) {
		
		for (int x = 0; x <= array.length - 1; x++) {
			for (int y = 0; y <= array.length - 1; y++) {
				for (int z = 0; z <= array.length - 1; z++) {
					System.out.print(array[x][y][z]);
					// System.out.print(" "+(x+1)+" "+(y+1)+" "+(z+1)+" ");
				}
				System.out.println("");
			}
			System.out.println();

		}
	}
	
	public static void print3DArray(int [][][] array) {
		for (int x = 0; x <= array.length - 1; x++) {
			for (int y = 0; y <= array.length - 1; y++) {
				for (int z = 0; z <= array.length - 1; z++) {
					System.out.print(array[x][y][z]);
					// System.out.print(" "+(x+1)+" "+(y+1)+" "+(z+1)+" ");
				}
				System.out.println("");
			}
			System.out.println();

		}
	}
	
	public static void print2DArray(String [][] array) {
		for(int i=0;i<=array.length-1;i++) {
			for(int x=0;x<=array.length-1;x++) {
				System.out.println(array[i][x]);
			}
		}
	}
	
	public static void print2DArray(int [][] array) {
		for(int i=0;i<=array.length-1;i++) {
			for(int x=0;x<=array.length-1;x++) {
				System.out.println(array[i][x]);
			}
		}
	}
}
