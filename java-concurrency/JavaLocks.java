public class JavaLocks {

    public static class Locks {
        private boolean isLocked = false;

        public synchronized void lock() throws InterruptedException {
            while(isLocked) {
                wait();
            }
            isLocked = true;
        }

        public synchronized void unLock() {
            isLocked = false;
            notifyAll();
        }
    }

    public static class Counter {
        public int counter = 0;
        private Locks lock = new Locks();

        public int inc() throws InterruptedException {
            lock.lock();
            counter++;
            lock.unLock();
            return counter;
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            try {
                c.inc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                c.inc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();

        System.out.println(c.counter);
    };

};