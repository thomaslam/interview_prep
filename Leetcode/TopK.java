import java.util.PriorityQueue;

public class TopK {
	public static Integer[] getTopK(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			minHeap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			int min = minHeap.peek();

			if (arr[i] > min) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}

		Integer[] topK = new Integer[k];
		minHeap.toArray(topK);
		return topK;
	}

	public static void main(String[] args) {
		int[] arr = {8, 5, 7, 10, 9, 3, 2, 4, 1, 0, 6};
		Integer[] result = getTopK(arr, 5);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}