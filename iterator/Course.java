package iterator;

/**
 * Represents a course containing assignments.
 * @author Alex Chandarana
 */
public class Course {

    private Assignment[] assignments;
    private int count;
    private String name;
    private String title;

    /**
     * Constructs a Course.
     * @param name the course name
     * @param title the course title
     */
    public Course(String name, String title) {
        this.name = name;
        this.title = title;
        this.assignments = new Assignment[1];
        this.count = 0;
    }

    /**
     * Adds an assignment to the course.
     * @param title the assignment title
     * @param description the assignment description
     * @param topic the assignment topic
     */
    public void addAssignment(String title, String description, Topic topic) {
        if (count == assignments.length) {
            assignments = growArray(assignments);
        }
        assignments[count] = new Assignment(title, description, topic);
        count++;
    }

    /**
     * Creates an iterator for assignments by topic.
     * @param topic the topic filter
     * @return an AssignmentIterator
     */
    public AssignmentIterator createIterator(Topic topic) {
        return new AssignmentIterator(assignments, topic);
    }

    /**
     * Grows the assignment array.
     * @param first the original array
     * @return the larger array
     */
    private Assignment[] growArray(Assignment[] first) {
        Assignment[] larger = new Assignment[first.length + 1];
        for (int i = 0; i < first.length; i++) {
            larger[i] = first[i];
        }
        return larger;
    }

    /**
     * Returns the course as a string.
     * @return string representation
     */
    @Override
    public String toString() {
        return name + ":  " + title;
    }
}