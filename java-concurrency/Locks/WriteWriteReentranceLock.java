import java.util.Map;
import java.util.HashMap;

public class WriteWriteReentranceLock {
    private class WriteLock {
        private int writeRequests = 0;
        private Map<Thread, Integer> readers = new HashMap<Thread, Integer>();
        private Map<Thread, Integer> writer = new HashMap<Thread, Integer>();

        public synchronized void lock() throws InterruptedException {
            writeRequests++;
            Thread callingThread = Thread.currentThread();
            while(!canGiveWriteAccess(callingThread)) {
                wait();
            }
            writeRequests--;
            writer.put(callingThread, writer.getOrDefault(callingThread, 0) - 1);
        }

        public synchronized void unLock() {
            Thread callingThread = writer.keySet().stream().findFirst().orElse(null);
            if(callingThread != null) {
                int count = writer.get(callingThread);
                if(count == 1) writer.remove(callingThread);
                else writer.put(callingThread, count-1);
            }
            notifyAll();
        }

        public synchronized boolean canGiveWriteAccess(Thread callingThread) {
            if(readers.size() > 0) return false;
            else if(writer.containsKey(callingThread) || writer.size() == 0) return true;
            return false;
        }
    }


    public static void main(String[] args) { 
        System.out.println("write-write-reentrance-lock program");
    }
}