import static java.lang.Thread.sleep;

public class Runner implements Runnable {


    private int usage = 50;
    private final int due;

    public Runner(int due, int usage) {
        this.usage = usage;
        this.due = due;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            if (current - start > due * 1000) {
                Thread.currentThread().interrupt();
                return;
            }

            boolean timeout = false;
            long s = System.currentTimeMillis();
            while (!timeout) {
                long c = System.currentTimeMillis();
                if (c - s > usage * 10) {
                    timeout = true;
                }
            }

            try {
                sleep((100 - usage) * 10);
            } catch (InterruptedException e) {

            }

            long end = System.currentTimeMillis();
            changeUsage(start, end);
        }
    }

    private void changeUsage(long start, long end) {
        this.usage = (int) (50 + Math.sin((end - start) / 1000 * 3.14159 / 20) * 50);
    }

}
