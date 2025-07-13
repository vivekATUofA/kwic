import java.util.*;

public class KWIC_EventBased {
    public static void main(String[] args) {
        EventManager events = new EventManager();
        new Input(events);
        new CircularShifter(events);
        new Alphabetizer(events);
        new Output(events);
        events.trigger("start", null);
    }
}
