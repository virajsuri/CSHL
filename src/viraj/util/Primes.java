package viraj.util;

import javax.swing.JOptionPane;

public class Primes {
	public static boolean isPrime(int x) {
		boolean wonderprime = false;
		if (x % 2 == 0)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i != 0) {
				wonderprime = true;
			} else {
				wonderprime = false;
				break;
			}
		}
		return wonderprime;
	}
	
	public static String primesBetweenTwoNumbers(int firstInt, int secondInt) {
		String result = "Primes between "+firstInt +" and "+ secondInt + "\n";

		if (firstInt > secondInt) {
			System.out.println(firstInt + " " + secondInt);
			int temp = firstInt;
			firstInt = secondInt;
			secondInt = temp;
			System.out.println(firstInt + " " + secondInt);
		}
		for (int i = firstInt; i <= secondInt; i++) {
			if (isPrime(i)) {
				result += (i) + "\n";
			}
		}
		
		return result;
	}

	public static void factorize(int input) {
		String result = "";
		try {
			
			if (input < 0) {
				JOptionPane.showMessageDialog(null, "Number can only be positive. Try again.");
//				factorize();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You didnt enter in a number. Try again.");
//			factorize();
		}
		int temp = input;
		if (isPrime(input)) {
			JOptionPane.showMessageDialog(null, "Number is prime, cant factorize it");
			System.exit(0);
		}
		while (input != 1) {
			for (int i = 2; i <= input; i++) {
				if (input % i == 0) {
					input /= i;
					result += "*" + i;
				}
			}
		}
		result = result.substring(1);
		System.out.println("Prime factorization of " + temp + ": " + result);
	}
}
