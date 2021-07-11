package ucf.assignments;

import javafx.event.Event;
import javafx.event.EventType;

class ItemEvent extends Event {

    public static final EventType<ItemEvent> ANY = new EventType<>(Event.ANY, "ANY");

    public static final EventType<ItemEvent> ADD_ITEM = new EventType<>(ANY, "ADD_ITEM");

    public static final EventType<ItemEvent> DELETE_ITEM = new EventType<>(ANY, "DELETE_ITEM");

    public ItemEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public int itemId;
}