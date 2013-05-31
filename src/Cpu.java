public class Cpu {
    public static void set(int due, int usage) {
        Thread thread1 = new Thread(new Runner(due, usage));
        Thread thread2 = new Thread(new Runner(due, usage));
        thread1.start();
        thread2.start();
    }
}

