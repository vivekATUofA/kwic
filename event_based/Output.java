import java.util.*;

class Output {
    public Output(EventManager em) {
        em.register("sorted_ready", data -> {
            System.out.println("KWIC Index:");
            for (String line : (List<String>) data) {
                System.out.println(line);
            }
        });
    }
}
