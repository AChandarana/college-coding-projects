package iterator;

import java.util.Iterator;

/**
 * Iterates over assignments filtered by topic.
 * @author Alex Chandarana
 */
public class AssignmentIterator implements Iterator<Assignment> {

    private Assignment[] assignments;
    private Topic topic;
    private int position;

    /**
     * Constructs an AssignmentIterator.
     * @param assignments the assignment array
     * @param topic the topic to filter by
     */
    public AssignmentIterator(Assignment[] assignments, Topic topic) {
        this.assignments = assignments;
        this.topic = topic;
        this.position = 0;
    }

    /**
     * Checks if a matching assignment exists.
     * @return true if another assignment exists
     */
    @Override
    public boolean hasNext() {
        while (position < assignments.length) {
            if (assignments[position] != null &&
                assignments[position].hasTopic(topic)) {
                return true;
            }
            position++;
        }
        return false;
    }

    /**
     * Returns the next matching assignment.
     * @return the next assignment
     */
    @Override
    public Assignment next() {
        if (!hasNext()) {
            return null;
        }
        return assignments[position++];
    }
}