public class Sine {
    private final int periodic;
    private final int coreNumber;

    public Sine(int periodic, int coreNumber) {
        this.periodic = periodic;
        this.coreNumber = coreNumber;
    }

    public void draw() {
        for (int i = 0; i < this.coreNumber; i++) {
            Thread thread = new Thread(new Runner(this.periodic));
            thread.start();
        }
    }
}

