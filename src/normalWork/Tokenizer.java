package normalWork;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokenizer {
	public static void main(String [] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter in last, first, middle");
		String input = kb.nextLine();
		
		String delimiters = ",,";
		StringTokenizer names = new StringTokenizer(input,delimiters);
		
		String lName=names.nextToken();
		String fName = names.nextToken();
		String mName = names.nextToken();
		
		System.out.println(lName +" "+ fName +" "+ mName);
	}
}
