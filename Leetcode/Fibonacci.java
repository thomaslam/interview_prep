public class Fibonacci {
	
	// Normal recursive solution (DP without memoization)
	public int fib(int n) {
		if (n == 0 || n == 1) return n;
		return fib(n-1) + fib(n-2);
	}

	// Top-down recursive solution (DP with memoization)
	public int fib(int n) {
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		return helper(n, arr);
	}

	public int helper(n, int[] arr) {
		if (n == 0 || n == 1) return n;
		if (arr[n] == 0) {
			arr[n] = helper(n-1, arr) + helper(n-2, arr);
		}
		return arr[n];
	}

	// Bottom-up solution (no recursion i.e. iterative, DP with memoization)
	public int fib(int n) {
		if (n == 0 || n == 1) return n;
		int a = 0;
		int b = 1;
		int c;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}