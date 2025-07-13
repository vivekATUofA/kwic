import java.io.*;
import java.util.*;

class Input {
    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
