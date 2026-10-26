import java.util.function.Consumer;

public class SynchronizedBlock {

  public static void main(String[] args) {

    Consumer<String> func = (String param) -> {

      synchronized(SynchronizedBlock.class) {

        System.out.println(
            Thread.currentThread().getName() +
                    " step 1: " + param);

        try {
          Thread.sleep( (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
        System.out.println(
            Thread.currentThread().getName() +
                    " step 2: " + param);

    };


    Thread thread1 = new Thread(() -> {
        func.accept("Lodu");
    }, "Thread 1");

    Thread thread2 = new Thread(() -> {
        func.accept("Lalit");
    }, "Thread 2");

    thread1.start();
    thread2.start();
  }
}