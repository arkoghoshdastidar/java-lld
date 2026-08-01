import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class ThreadPool {
    private boolean isStopped = false;
    private BlockingQueue<Runnable> queue = null;
    private ArrayList<RunnableThread> runnables = null;

    public ThreadPool(int numberOfThreads, int numberOfTasks) {
        this.queue = new ArrayBlockingQueue<Runnable>(numberOfTasks);
        this.runnables = new ArrayList<RunnableThread>(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            RunnableThread r = new RunnableThread(this.queue);
            this.runnables.add(r);
        }

        for(RunnableThread runnable: runnables) {
            runnable.run();
        }
    };

    public synchronized void execute(Runnable r) {
        if(isStopped) {
            throw new IllegalStateException("The threadPool is shutdown");
        }
        try{
            this.queue.offer(r);
        }catch(Exception e) {
            System.out.println("Error while pushing task to the task queue");
            System.out.println(e.getMessage());
        }
    }

    public synchronized void doStop() {
        this.isStopped = true;
        for (RunnableThread runnable : runnables) {
            runnable.stop();
        }
    }

    public synchronized boolean waitTillAllTasksFinished() {
        while (this.queue.size() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return true;
    }

}