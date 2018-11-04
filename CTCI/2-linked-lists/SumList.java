public class SumList {
	public Node addLists(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		int value = carry;
		if (l1 != null) { value += l1.data; }
		if (l2 != null) { value += l2.data; }

		Node newNode = new Node(value % 10);
		if (l1 != null || l2 != null) {
			Node nextNode = addLists(l1 == null ? null : l1.next, 
									l2 == null ? null : l2.next,
									value >= 10 ? 1 : 0);
			newNode.next = nextNode;
		}
		return newNode;
	}
}