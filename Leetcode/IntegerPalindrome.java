public class IntegerPalindrome {
	// Idea: construct a reverse number of x and check if they are same number
	// Note: check half of digits of x (i.e. avoiding overflow issue)
	public static boolean isPalindrome(int x) {
		if (x < 0 || (x > 0 && x % 10 == 0)) return false; // if x is negative or if x ends in 0 (e.g. 13420) then x is not palidrome
		int rev = 0;
		while (x > rev) {
			rev = rev*10 + x%10;
			x = x / 10;
		}
		// if x is palindrome and has odd number of digits then x == rev/10
		// e.g. 121, after while loop, x = 1, rev = 12
		return x == rev || (x == rev/10); 
	}
}