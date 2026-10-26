public class BoundedSemaphore {
    private int signal = 0;
    private int bound = 1;

    public BoundedSemaphore(int bound) {
        this.bound = bound;
    }

    public synchronized void acquire() throws InterruptedException {
        while(this.signal == this.bound) wait();
        this.signal++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while(this.signal == 0) wait();
        this.signal--;
        notify();
    }
}