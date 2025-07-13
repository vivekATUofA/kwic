import java.io.*;
import java.util.*;

class Input {
    public Input(EventManager em) {
        em.register("start", data -> {
            try (Scanner scanner = new Scanner(new File("input.txt"))) {
                while (scanner.hasNextLine()) {
                    em.trigger("line_added", scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
