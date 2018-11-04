public class PalindromeList {
	public boolean isPalindrome(Node l) {
		Stack<Node> stack = new Stack<Node>();
		Node fast = l;
		Node slow = l;

		while (fast != null && fast.next != null) {
			stack.push(slow);
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) { // linkedlist is odd sized.
			slow = slow.next;
		}

		while (slow != null) {
			if (stack.pop().data != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}