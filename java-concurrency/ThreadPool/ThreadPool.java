import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import RunnableThread;

public class ThreadPool {
    private boolean isStopped = false;
    private BlockingQueue queue = null;
    private ArrayList<RunnableThread> runnables = null;

    public ThreadPool(int numberOfThreads, int numberOfTasks) {
        queue = new BlockingQueue(numberOfTasks);
        runnables = new ArrayList<RunnableThread>(numberOfThreads);

        for(RunnableThread runnable: runnables) {
            runnable.run();
        }
    };

    public void execute(Runnable r) {
        if(isStopped) {
            throw new Error("The executor has been stopped");
        }
        this.queue.push(r);
    }

    public void doStop() {
        this.isStopped = true;
        for(RunnableThread runnable: runnables) {
            runnable.stop();
        }
    }

}