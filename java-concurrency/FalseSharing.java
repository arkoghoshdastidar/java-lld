public class FalseSharing {
    private static class Counter {
        public volatile int count1 = 0;

        public volatile int count2 = 0;
    }

    public static void main(String args[]) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        long iterations = 1_000_000_000;

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter1.count1 += 1;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("thread1 duration: " + (endTime - startTime));
        });

        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter2.count2 += 1;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("thread2 duration: " + (endTime - startTime));
        });

        thread1.start();
        thread2.start();
    }
}