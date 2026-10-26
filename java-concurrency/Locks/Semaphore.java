public class Semaphore {
    private boolean signal;

    public Semaphore() {
        this.signal = false;
    }

    public synchronized void acquire() throws InterruptedException {
        this.signal = true;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while(!this.signal) wait();
        this.signal = false;
    }
}