//This code is made by Emmitt Murray. It is a custom stack or queue without using the library java methods.
import java.util.Scanner;

public class stackQ {

	// Array-backed stack for names
	static class NameStack {
		private String[] data;
		private int top;

		NameStack(int capacity) {
			data = new String[Math.max(2, capacity)];
			top = -1;
		}

		void push(String s) {
			if (top + 1 == data.length) resize();
			data[++top] = s;
		}

		String pop() {
			if (top < 0) return null;
			String r = data[top];
			data[top--] = null;
			return r;
		}

		boolean isEmpty() {
			return top < 0;
		}

		private void resize() {
			String[] n = new String[data.length * 2];
			System.arraycopy(data, 0, n, 0, data.length);
			data = n;
		}
	}

	// Array-backed circular queue for names
	static class NameQueue {
		private String[] data;
		private int head, tail, size;

		NameQueue(int capacity) {
			data = new String[Math.max(2, capacity)];
			head = 0; tail = 0; size = 0;
		}

		void enqueue(String s) {
			if (size == data.length) resize();
			data[tail] = s;
			tail = (tail + 1) % data.length;
			size++;
		}

		String dequeue() {
			if (size == 0) return null;
			String r = data[head];
			data[head] = null;
			head = (head + 1) % data.length;
			size--;
			return r;
		}

		boolean isEmpty() {
			return size == 0;
		}

		private void resize() {
			String[] n = new String[data.length * 2];
			for (int i = 0; i < size; i++) n[i] = data[(head + i) % data.length];
			data = n;
			head = 0;
			tail = size;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose mode: type 'stack' or 'queue' (or 's' / 'q').");
		String modeLine = sc.nextLine().trim().toLowerCase();
		boolean useStack;
		if (modeLine.startsWith("s")) useStack = true;
		else if (modeLine.startsWith("q")) useStack = false;
		else {
			System.out.println("Unrecognized input; defaulting to 'stack'.");
			useStack = true;
		}

		System.out.println("Enter names. Press Enter on an empty line when done.");

		// Use stack or queue based on user choiceq
        
		NameStack ns = null;
		NameQueue nq = null;
		if (useStack) ns = new NameStack(8);
		else nq = new NameQueue(8);

		while (true) {
			System.out.print("Name: ");
			String ln = sc.nextLine();
			if (ln == null) break;
			ln = ln.trim();
			if (ln.isEmpty()) break;
			if (useStack) ns.push(ln);
			else nq.enqueue(ln);
		}

		System.out.println();
		if (useStack) {
			System.out.println("Stack output (LIFO):");
			while (!ns.isEmpty()) System.out.println(ns.pop());
		} else {
			System.out.println("Queue output (FIFO):");
			while (!nq.isEmpty()) System.out.println(nq.dequeue());
		}

		sc.close();
	}

}

