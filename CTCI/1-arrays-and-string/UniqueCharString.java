public class UniqueCharString {
	// SOLUTION 1: Use external HashSet. O(n) time
	public boolean uniqueCharString(String str) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (set.contains(c)) {
				return false;
			} else {
				set.add(c);
			}
		}
		return true;
	}
}