package event;

import java.io.Serializable;

public abstract class DomainEvent implements Serializable {

    private final long sequenceId;
    private final long createdTime;
    private final String eventClassName;
    private boolean realTime = true;

    /**
     * Instantiates a new Domain event.
     *
     * @param sequenceId the sequence id
     * @param createdTime the created time
     * @param eventClassName the event class name
     */
    public DomainEvent(long sequenceId, long createdTime, String eventClassName) {
        this.sequenceId = sequenceId;
        this.createdTime = createdTime;
        this.eventClassName = eventClassName;
    }

    /**
     * Gets sequence id.
     *
     * @return the sequence id
     */
    public long getSequenceId() {
        return sequenceId;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     * Is real time boolean.
     *
     * @return the boolean
     */
    public boolean isRealTime() {
        return realTime;
    }

    /**
     * Sets real time.
     *
     * @param realTime the real time
     */
    public void setRealTime(boolean realTime) {
        this.realTime = realTime;
    }

    /**
     * Process.
     */
    public abstract void process();

    /**
     * Gets event class name.
     *
     * @return the event class name
     */
    public String getEventClassName() {
        return eventClassName;
    }
}
