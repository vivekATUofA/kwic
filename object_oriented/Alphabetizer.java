import java.util.*;

class Alphabetizer {
    public List<String> sort(List<String> shifts) {
        Collections.sort(shifts, String.CASE_INSENSITIVE_ORDER);
        return shifts;
    }
}
