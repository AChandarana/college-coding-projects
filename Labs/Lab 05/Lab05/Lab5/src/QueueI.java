// Copyright 2025 Alex Chandarana
public interface QueueI <T> {
	
	// Neccessary funtions
	public void enqueue(T data);
	public T dequeue();
	public T peek();
	public void print();
}
