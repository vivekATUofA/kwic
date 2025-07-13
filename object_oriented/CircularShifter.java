import java.util.*;

class CircularShifter {
    public List<String> generateShifts(List<String> lines) {
        List<String> shifts = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < words.length; j++) {
                    sb.append(words[(i + j) % words.length]).append(" ");
                }
                shifts.add(sb.toString().trim());
            }
        }
        return shifts;
    }
}
