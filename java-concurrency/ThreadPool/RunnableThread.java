import java.util.concurrent.BlockingQueue;

public class RunnableThread implements Runnable {
    BlockingQueue queue = null;
    boolean isStopped = false;

    public RunnableThread(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while(!this.isStopped) {
            Runnable r = this.queue.pop();
            r.run();
        }
    }

    public void stop() {
        this.isStopped = true;
        this.currentThread.interrupt();
    }
}