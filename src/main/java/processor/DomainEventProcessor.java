package processor;

import event.DomainEvent;

public class DomainEventProcessor {

    private final JsonFileJournal processorJournal = new JsonFileJournal();

    /**
     * Process.
     *
     * @param domainEvent the domain event
     */
    public void process(DomainEvent domainEvent) {
        domainEvent.process();
        processorJournal.write(domainEvent);
    }

    /**
     * Reset.
     */
    public void reset() {
        processorJournal.reset();
    }

    /**
     * Recover.
     */
    public void recover() {
        DomainEvent domainEvent;
        while (true) {
            domainEvent = processorJournal.readNext();
            if (domainEvent == null) {
                break;
            } else {
                domainEvent.process();
            }
        }
    }
}
