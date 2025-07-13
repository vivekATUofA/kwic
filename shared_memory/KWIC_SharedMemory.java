import java.io.*;
import java.util.*;

public class KWIC_SharedMemory {
    static List<String> lines = new ArrayList<>();
    static List<String> shifts = new ArrayList<>();

    public static void main(String[] args) {
        input();
        circularShift();
        alphabetize();
        output();
    }

    static void input() {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void circularShift() {
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                StringBuilder shift = new StringBuilder();
                for (int j = 0; j < words.length; j++) {
                    shift.append(words[(i + j) % words.length]).append(" ");
                }
                shifts.add(shift.toString().trim());
            }
        }
    }

    static void alphabetize() {
        Collections.sort(shifts, String.CASE_INSENSITIVE_ORDER);
    }

    static void output() {
        System.out.println("KWIC Index:");
        for (String shift : shifts) {
            System.out.println(shift);
        }
    }
}
