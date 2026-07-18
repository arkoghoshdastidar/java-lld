public class ThreadSignalling {

    public static class referenceClass {
    }

    public static class waitNotify {
        private boolean hasBeenNotified;
        private referenceClass referenceObject = new referenceClass();

        public waitNotify() {
            System.out.println("Instantiating waitNotify object");
            hasBeenNotified = false;
        }

        public void doWait() {
            synchronized (referenceObject) {
                while (!hasBeenNotified) {
                    try {
                        System.out.println("waiting..." + Thread.currentThread().getName());
                        referenceObject.wait();
                        System.out.println("continuing..." + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                hasBeenNotified = false;
            }
        }

        public void doNotify() {
            try {
                System.out.println("sleeping..." + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("awaken..." + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            synchronized (referenceObject) {
                hasBeenNotified = true;
                referenceObject.notify();
            }
        }
    }

    public static void main(String[] args) {
        waitNotify waitNotifyObj = new waitNotify();

        Thread t1 = new Thread(waitNotifyObj::doWait);
        Thread t2 = new Thread(waitNotifyObj::doNotify);

        t1.start();
        t2.start();
    }
}