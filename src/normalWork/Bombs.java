package normalWork;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import viraj.util.*;

public class Bombs {
	public static void main(String[] args) {
//		System.out.println(viraj.util.Primes.primesBetweenTwoNumbers(1, 15));

		
		int[][] bombs = new int[6][6];

		for (int[] row : bombs) {
			Arrays.fill(row, 0);
		}
		System.out.println();
		
		for(int i=0;i<=6;i++) {
			Random gen = new Random();
			bombs[gen.nextInt(5)][gen.nextInt(5)]=1;
		}

		
		for (int[] row : bombs) {
			System.out.println(Arrays.toString(row));
		}
		
		Scanner kb = new Scanner(System.in);
		for(int i=0;i<=8;i++) {
			System.out.println("X?");
			int x = kb.nextInt();
			System.out.println("Y?");
			int y = kb.nextInt();
			if(bombs[x][y]==1) {
				System.out.println("You found a bomb");
			}
		}
		
		
		
		
	}
}
