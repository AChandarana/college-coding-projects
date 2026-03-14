// Copyright 2025 Alex Chandarana

public class GenLL<T> {
	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T d, ListNode l) {
			data = d;
			link = l;
		}
	}

	private ListNode head, current;
	private int size; // for creating arrays for easier sorting etc

	public GenLL() {
		head = current = null;
		this.size = 0;
	}

	public void add(T d) {
		ListNode nNode = new ListNode(d, null);
		if (head == null) { // for the case of an empty list
			head = current = nNode;
		} else {
			ListNode t = head;
			while (t.link != null) {
				t = t.link;
			}
			t.link = nNode;
		}
		this.size++; // increases size for array
		if (current == null) {
			return; // null pointer exception fix
		}
		current = current.link;
	}

	public void gotoNext() {
		current = current.link;
	}

	public T getData() {
		if (current == null) {
			return null;
		}
		return current.data;
	}

	public void reset() {
		current = head;
	}

	public int getSize() {
		return this.size;
	}
}