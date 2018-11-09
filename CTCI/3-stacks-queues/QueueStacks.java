public class QueueStacks {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public QueueStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int val) {
		stack1.push(val);
	}

	public void pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		stack2.pop();
	}

	public int peek() {
		return stack2.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}