import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
    private int limit = 10;
    private List<Object> queue = new LinkedList<Object>();

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object o) throws InterruptedException {
        while(this.queue.size() == limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(o);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while(this.queue.size() == 0) {
            wait();
        }
        if(this.queue.size() == limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}