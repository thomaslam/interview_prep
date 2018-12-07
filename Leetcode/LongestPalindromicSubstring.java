public class LongestPalindromicSubstring {
	// Dynamic programming approach
	// Time complexity: O(n^2)
	// Space complexity: O(n^2)
	public String LongestPalindromicSubstring(String str) {
		int n = str.length();
		boolean[][] map = new boolean[n][n];

		int s, longest = 0, 1;
		for (int i = 0; i < n; i++) {
			map[i][i] = true;
		}

		for (int j = 1; j < n; j++) {
			if (str.charAt(j-1) == str.charAt(j)) {
				map[j-1][j] = true;
				s = j-1;
				longest = 2;
			}
		}

		for (int k = 3; k <= n; k++) {
			for (int start = 0; start < n-k+1; start++) {
				int end = start + k - 1;
				if (map[start+1][end-1] && str.charAt(start) == str.charAt(end)) {
					map[start][end] = true;
					s = start;
					longest = k;
				}
			}
		}

		return str.substring(s, s + longest);
	}

	// Another O(n^2) approach but O(1) space complexity
	// Start from midpoint of each substring (or 2 midpoints for even-length substrings)
	// and start expanding to left and right directions checking whether new substring formed is palindromic
	// by character comparisons at the start and end points and keep track of LPS so far
	public String LongestPalindromicSubstring(String str) {
		int n = str.length();
		int s, maxLen = 0, 1;

		int low, high;
		for (int i = 0; i < n-1; i++) {
			low, high = i, i;
			while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLen) {
					s = low;
					maxLen = high - low + 1;
				}
				low--;
				high++;
			}

			low, high = i, i+1;
			while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLen) {
					s = low;
					maxLen = high - low + 1;
				}
				low--;
				high++;
			}
		}

		return str.substring(s, s + maxLen);
	}

	// Optimal O(n) solution
	// Manacher algorithm

}