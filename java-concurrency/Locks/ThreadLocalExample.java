import java.lang.ThreadLocal;

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {
        ThreadLocal<Integer> threadLocalInstance = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocalInstance.set((int) (Math.random()*100));

            try{

            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println(threadLocalInstance.get());
        }
    };

    public static void main(String[] args) {
        MyRunnable tl = new MyRunnable();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);


        t1.start();
        t2.start();
    };
}