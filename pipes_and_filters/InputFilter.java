import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

class InputFilter implements Runnable {
    private final BlockingQueue<String> out;

    public InputFilter(BlockingQueue<String> out) {
        this.out = out;
    }

    public void run() {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                out.put(scanner.nextLine());
            }
            out.put("EOF");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
