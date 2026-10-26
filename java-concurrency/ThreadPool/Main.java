public class Main {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPool.execute(() -> {
                System.out.println("Executing the task " + taskNo + " through " + Thread.currentThread().getName());
            });
        }

        if(threadPool.waitTillAllTasksFinished()) {
            threadPool.doStop();
        }
    }
}