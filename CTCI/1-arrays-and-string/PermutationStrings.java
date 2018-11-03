public class PermutationStrings {
	// SOLUTION 1: Sort the strings and compare the sorted strings.
	// O(nlogn) where n is length of each string
	// if they have different lengths, we know they are not permutations of each other
	public String sort(String str) {
		char[] result = str.toCharArray();
		java.util.Arrays.sort(result);
		return new String(result);
	}

	public boolean permutationStrings(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		return sort(str1).equals(sort(str2));
	}
}