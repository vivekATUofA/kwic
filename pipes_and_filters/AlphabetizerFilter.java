import java.util.*;
import java.util.concurrent.BlockingQueue;

class AlphabetizerFilter implements Runnable {
    private final BlockingQueue<String> in, out;

    public AlphabetizerFilter(BlockingQueue<String> in, BlockingQueue<String> out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            List<String> buffer = new ArrayList<>();
            while (true) {
                String shift = in.take();
                if (shift.equals("EOF")) break;
                buffer.add(shift);
            }
            Collections.sort(buffer, String.CASE_INSENSITIVE_ORDER);
            for (String sorted : buffer) {
                out.put(sorted);
            }
            out.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
