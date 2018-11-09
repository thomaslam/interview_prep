public class LongestPalindromicSubstring {
	public String LongestPalindromicSubstring(String str) {
		int n = str.length;
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
}