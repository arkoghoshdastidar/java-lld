import java.util.concurrent.BlockingQueue;

class RunnableThread implements Runnable {
    private BlockingQueue<Runnable> queue = null;
    private boolean isStopped = false;
    private Thread thread = null;

    public RunnableThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }
    
    public void setThread(Thread t) {
        this.thread = t;
    }

    @Override
    public void run() {
        while(!this.isStopped) {
            try{
                Runnable r = this.queue.take();
                r.run();
            }catch(Exception e) {
                System.out.println("Error while popping out a task from the common task queue, thread: " + Thread.currentThread().getName());
                System.out.println(e.getMessage());
            }
        }
    }

    public synchronized void stop() {
        this.isStopped = true;
        this.thread.interrupt();
    }
}