import java.util.*;

public class KWIC_ObjectOriented {
    public static void main(String[] args) {
        List<String> lines = new Input().readLines();
        List<String> shifts = new CircularShifter().generateShifts(lines);
        List<String> sorted = new Alphabetizer().sort(shifts);
        new Output().print(sorted);
    }
}
