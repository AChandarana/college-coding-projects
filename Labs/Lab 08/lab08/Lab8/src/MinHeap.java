// Copyright 2025 Alex Chandarana

public class MinHeap<T extends Comparable<T>> {

	private T[] heap;
	public static final int SIZE = 128;
	private int lastInd;

	public MinHeap() {
		init(SIZE);
	}

	public MinHeap(int size) {
		init(size);
	}

	private void init(int size) {
		if (size > 0) {
			heap = (T[])(new Comparable[size]);
			lastInd = 0;
		} else {
			init(SIZE);
		}
	}

	public void add(T aData) {
		if (lastInd >= heap.length) {
			return;
		}
		heap[lastInd] = aData;
		rise();
		lastInd++;
	}

	private void rise() {
		int ind = lastInd;
		while (ind > 0 && heap[(ind - 1) / 2].compareTo(heap[ind]) > 0) {
			T temp = heap[(ind - 1) / 2];
			heap[(ind - 1) / 2] = heap[ind];
			heap[ind] = temp;
			ind = (ind - 1) / 2;
		}
	}

	public T remove() {
		if (lastInd == 0) {
			return null;
		}
		T ret = heap[0];
		heap[0] = heap[lastInd - 1];
		heap[lastInd - 1] = null;
		lastInd--;
		sink();
		return ret;
	}

	private void sink() {
		int ind = 0;
		while (ind * 2 + 1 < lastInd) {
			int smallInd = ind * 2 + 1;
			if (ind * 2 + 2 < lastInd && heap[ind * 2 + 1].compareTo(heap[ind * 2 + 2]) > 0) {
				smallInd = ind * 2 + 2;
			}
			if (heap[ind].compareTo(heap[smallInd]) > 0) {
				T temp = heap[ind];
				heap[ind] = heap[smallInd];
				heap[smallInd] = temp;
			} else {
				break;
			}
			ind = smallInd;
		}
	}
}
