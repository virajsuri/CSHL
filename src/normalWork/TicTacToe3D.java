package normalWork;
import java.util.Scanner;
import java.util.StringTokenizer;
import viraj.util.*;

public class TicTacToe3D {
	public static void main(String[] args) {
		String[][][] bombs = new String[3][3][3];
		boolean gameOver = false;

		for (int x = 0; x <= bombs.length - 1; x++) {
			for (int y = 0; y <= bombs.length - 1; y++) {
				for (int z = 0; z <= bombs.length - 1; z++) {
					bombs[x][y][z] = "*";
					System.out.print(bombs[x][y][z]);
//					System.out.print(" " + (x) + " " + (y) + " " + (z) + "    ");
					 System.out.print(" "+(x+1)+"|"+(y+1)+"|"+(z+1)+" ");

				}
				System.out.println("");
			}
			System.out.println();
		}

		String delimiters = ",,";
		int counter=0;
		while (!gameOver) {
			Scanner kb = new Scanner(System.in);

			if(counter%2==0) {
			System.out.println("Player 1 where do you wanna place your X");
			String input = kb.nextLine();
			StringTokenizer names = new StringTokenizer(input, delimiters);
			bombs[Integer.parseInt(names.nextToken()) - 1][Integer.parseInt(names.nextToken()) - 1][Integer
					.parseInt(names.nextToken()) - 1] = "X";
			
			}else {
				System.out.println("Player 2 where do you wanna place your O");
				String input = kb.nextLine();
				StringTokenizer names = new StringTokenizer(input, delimiters);
				bombs[Integer.parseInt(names.nextToken()) - 1][Integer.parseInt(names.nextToken()) - 1][Integer
						.parseInt(names.nextToken()) - 1] = "O";
			}
			Arrays.print3DArray(bombs);

			if (checkIfWinner(bombs)) {
				gameOver = true;
			}
			counter++;
		}

	}

	public static boolean checkIfWinner(String[][][] bombs) {
		boolean fdfa = false;
		for (int z = 0; z <= 2; z++) {
			for (int i = 0; i <= 2; i++) {

				if (bombs[z][i][0] == bombs[z][i][1] && bombs[z][i][0] == bombs[z][i][2] && (bombs[z][i][0] == "X" || bombs[z][i][0] == "O")) {
					fdfa = true;
					System.out.println("Youve won");
				} else
					if (bombs[z][0][i] == bombs[z][1][i] && bombs[z][i][0] == bombs[z][2][i] && (bombs[z][i][0] == "X" || bombs[z][i][0] == "O")) {
					fdfa = true;
					System.out.println("Youve won");
				}
			}
		}

		return fdfa;
	}
}
