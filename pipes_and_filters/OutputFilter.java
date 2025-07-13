import java.util.concurrent.BlockingQueue;

class OutputFilter implements Runnable {
    private final BlockingQueue<String> in;

    public OutputFilter(BlockingQueue<String> in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("KWIC Index:");
            while (true) {
                String sorted = in.take();
                if (sorted.equals("EOF")) break;
                System.out.println(sorted);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
