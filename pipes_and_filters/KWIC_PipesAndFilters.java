import java.util.concurrent.*;

public class KWIC_PipesAndFilters {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> inputToShift = new LinkedBlockingQueue<>();
        BlockingQueue<String> shiftToSort = new LinkedBlockingQueue<>();
        BlockingQueue<String> sortToOutput = new LinkedBlockingQueue<>();

        Thread input = new Thread(new InputFilter(inputToShift));
        Thread shift = new Thread(new CircularShiftFilter(inputToShift, shiftToSort));
        Thread sort = new Thread(new AlphabetizerFilter(shiftToSort, sortToOutput));
        Thread output = new Thread(new OutputFilter(sortToOutput));

        input.start();
        shift.start();
        sort.start();
        output.start();

        input.join();
        shift.join();
        sort.join();
        output.join();
    }
}
