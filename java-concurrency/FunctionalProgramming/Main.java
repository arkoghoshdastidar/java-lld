public class Main{
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + ": running the MyThread class run function");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread("thread@01");
        thread.start();
    }
}