public class CircularList {
	public boolean isCircular(Node l) {
		Node fast = l;
		Node slow = l;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}