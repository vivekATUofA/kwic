import java.util.*;

interface EventListener {
    void handle(Object data);
}

class EventManager {
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    public void register(String event, EventListener listener) {
        listeners.computeIfAbsent(event, k -> new ArrayList<>()).add(listener);
    }

    public void trigger(String event, Object data) {
        if (listeners.containsKey(event)) {
            for (EventListener l : listeners.get(event)) {
                l.handle(data);
            }
        }
    }
}
