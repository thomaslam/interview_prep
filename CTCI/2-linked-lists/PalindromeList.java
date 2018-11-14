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

	// Second solution using no extra storage
	public boolean isPalindrome(Node l) {
		Node fast = l;
		Node slow = l;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public Node reverse(Node head) {
		Node prev = null;
		while (head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}