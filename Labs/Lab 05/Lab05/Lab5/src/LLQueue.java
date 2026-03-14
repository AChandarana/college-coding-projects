// Copyright 2025 Alex Chandarana
public class LLQueue <T> implements QueueI<T> {
	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T d, ListNode l) {
			data = d;
			link = l;
		}
	}

	private ListNode head, tail;
	private int size;
	public LLQueue() {
		head = tail = null;
	}

	public void enqueue(T data) {
		ListNode nNode = new ListNode(data, null);
		if(head == null) {
			head = tail = nNode;
			return;
		}
		tail.link = nNode;
		tail = tail.link;
	}

	public T dequeue() {
		if (head == null) return null;
		T ref = head.data;
		head = head.link; // Shifts head forward, removing an item
		return ref;
	}

	public T peek() {
		if (head == null) return null; // if list is empty
		return head.data;
	}

	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.data);
		}
	}
}
