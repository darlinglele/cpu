import static java.lang.Thread.sleep;

public class Runner implements Runnable {

    private final int periodic;
    private int usage = 50;

    public Runner(int periodic) {
        this.periodic = periodic;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {
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
        this.usage = (int) (50 + Math.sin((end - start) / 1000 * 2 * 3.14159 / periodic) * 50);
    }

}
