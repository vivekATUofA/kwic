import java.util.*;

class CircularShifter {
    List<String> shifts = new ArrayList<>();

    public CircularShifter(EventManager em) {
        em.register("line_added", data -> {
            String line = (String) data;
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < words.length; j++) {
                    sb.append(words[(i + j) % words.length]).append(" ");
                }
                shifts.add(sb.toString().trim());
            }
        });
        em.register("line_added", data -> em.trigger("shifts_generated", shifts));
    }
}
