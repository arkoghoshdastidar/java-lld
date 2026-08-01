import ThreadPool;

public class Main {

    public static void main(String[] args) {
        ThreadPool tp = new ThreadPool(3, 10);

        for(int i=0; i<10; i++) {
            tp.execute(() -> {
                System.out.println("Task no: executed by the ThreadPool" + i);
            })
        }
    }
}