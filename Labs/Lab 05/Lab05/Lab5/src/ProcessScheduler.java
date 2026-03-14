// Copyright 2025 Alex Chandarana
public class ProcessScheduler {
	
	public LLQueue<Process> Processes = new LLQueue();
	public Process currentProcess = null;
	public Process getCurrentProcess() {
		return currentProcess;
	}
	
	public void addProcess(Process p) {
		if (getCurrentProcess() == null) {
			currentProcess = p;
		} else {
			Processes.enqueue(p);
		}
	}

	public void runNextProcess() {
		currentProcess = Processes.dequeue();
	}

	// Accomplishes same thing as runNextProcess, redid the way it's handle to more clearly show it's purpose.
	public void cancelCurrentProcess() {
		currentProcess = Processes.peek();
		Processes.dequeue();
	}

	public void printProcessQueue() {
		Processes.print();
	}

}
