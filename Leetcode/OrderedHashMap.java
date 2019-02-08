public class OrderedHashMap {
	class Node {
		int val;
		Node next;
		Node prev;

		public Node(int val, Node next, Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}

	Map<Integer, Node> map;
	Node head;
	Node tail;

	public OrderedHashMap() {
		map = new HashMap<Integer, Node>();
		head = null;
		tail = null;
	}

	public int get(int k) {
		Node n = map.get(k);
		if (n == null) return -1;
		return n.val;
	}

	public void insert(int k, int val) {
		Node n = map.get(k);
		if (n == null) {
			Node n = new Node(val, null, tail);
			map.add(k, n);
			if (head == null) {
				head = n;
				tail = n;
			} else {
				tail.next = n;
				tail = n;
			}
		} else {
			n.val = val;
			Node next = n.next;
			Node prev = n.prev;

			if (next == null) { // tail
				return;
			} else if (prev == null) { // head node
				next.prev = null;
				head = next;
			} else {
				prev.next = next;
				next.prev = prev;
			}

			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}

	public void remove(int k) {
		Node n = map.get(k);
		if (n == null) return;
		Node next = n.next;
		Node prev = n.prev;
		if (next == null && prev == null) { // only node
			head = null;
			tail = null;
		} else if (next == null) { // tail node
			prev.next = null;
			tail = prev;
		} else if (prev == null) { // head node
			next.prev = null;
			head = next;
		} else {
			prev.next = next;
			next.prev = prev;
		}
		map.remove(k);
	}

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
}