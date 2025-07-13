import java.util.concurrent.BlockingQueue;

class CircularShiftFilter implements Runnable {
    private final BlockingQueue<String> in, out;

    public CircularShiftFilter(BlockingQueue<String> in, BlockingQueue<String> out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            while (true) {
                String line = in.take();
                if (line.equals("EOF")) {
                    out.put("EOF");
                    break;
                }
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < words.length; j++) {
                        sb.append(words[(i + j) % words.length]).append(" ");
                    }
                    out.put(sb.toString().trim());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
