package code;

import java.util.Stack;

public class QueueUsing2Stacks {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
		}

		public T peek() {
			if(stackOldestOnTop.isEmpty())
			while (!stackNewestOnTop.isEmpty())
				stackOldestOnTop.push(stackNewestOnTop.pop());

			return stackOldestOnTop.peek();

		}

		public T dequeue() {
			if(stackOldestOnTop.isEmpty())
			while (!stackNewestOnTop.isEmpty())
				stackOldestOnTop.push(stackNewestOnTop.pop());

			return stackOldestOnTop.pop();

		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		int n = 10;
		int index = 0;
		int a[] = { 1, 2, 1, 3, 1, 3, 1, 1, 2, 2 };
		// int data[] = { 10, 20, 30, 40, 50, 60,70 };
		int data[] = { 42, 14, 28, 60, 78 };
		for (int i = 0; i < n; i++) {
			int operation = a[i];
			if (operation == 1) { // enqueue
				System.out.println("ENQUEUEING: " + data[index]);
				queue.enqueue(data[index++]);
			} else if (operation == 2) { // dequeue
				System.out.println("DEQUEUED: " + queue.dequeue());
			} else if (operation == 3) { // print/peek
				System.out.println("PEEK: " + queue.peek());
			}
		}
	}
}
