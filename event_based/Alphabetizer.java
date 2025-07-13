import java.util.*;

class Alphabetizer {
    List<String> sorted = new ArrayList<>();

    public Alphabetizer(EventManager em) {
        em.register("shifts_generated", data -> {
            sorted = new ArrayList<>((List<String>) data);
            Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
            em.trigger("sorted_ready", sorted);
        });
    }
}
