package iterator;

/**
 * Represents an assignment with a topic.
 * @author Alex Chandarana
 */
public class Assignment {

    private String title;
    private String description;
    private Topic topic;
    
    /**
     * Constructs an Assignment.
     * @param title the assignment title
     * @param description the assignment description
     * @param topic the assignment topic
     */
    public Assignment(String title, String description, Topic topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    /**
     * Checks if the assignment matches a topic.
     * @param topic the topic to check
     * @return true if topics match
     */
    public boolean hasTopic(Topic topic) {
        if (topic == Topic.ALL) return true;
        return this.topic == topic;
    }

    /**
     * Returns the assignment as a string.
     * @return string representation
     */
    @Override
    public String toString() {
        return title + ":  " + description;
    }

}