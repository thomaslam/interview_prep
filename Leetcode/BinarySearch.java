public class BinarySearch {
	public int binarySearch(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		return binarySearchHelper(arr, val, low, high);
	}

	public int binarySearchHelper(int[] arr, int val, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == val) {
				return mid;
			}

			if (arr[mid] > val) {
				return binarySearchHelper(arr, val, low, mid-1);
			}

			return binarySearchHelper(arr, val, mid+1, high);
		}
		return -1;
	}
}