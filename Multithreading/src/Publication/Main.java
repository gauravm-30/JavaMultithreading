package Publication;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EventSource source = new EventSource();
        ThisEscape escape = new ThisEscape(source);
    }
}

class EventSource {
    private final List<EventListener> listeners = new ArrayList<>();

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    // Other methods to trigger events
}

 interface EventListener {
    void onEvent(Event e);
}

 class Event {
    // Event details
}


