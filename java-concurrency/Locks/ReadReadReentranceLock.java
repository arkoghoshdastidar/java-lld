import java.util.Map;
import java.util.HashMap;

public class ReadReadReentranceLock{
    private static class ReadLock{
        private int writers = 0;
        private int writeRequests = 0;
        Map<Thread, Integer> readers = new HashMap<Thread, Integer>();
        
        public synchronized void lock() throws InterruptedException {
            Thread callingThread = Thread.currentThread();
            while(!canGiveReadAccess(callingThread)){
                wait();
            }
            readers.put(callingThread, readers.getOrDefault(callingThread, 0) + 1);
        }

        public synchronized void unLock(){
            Thread callingThread = Thread.currentThread();
            Integer count = readers.get(callingThread);
            if(count == 1) readers.remove(callingThread);
            else readers.put(callingThread, count-1);
            notifyAll();
        }

        public synchronized boolean canGiveReadAccess(Thread callingThread){
            if(writers > 0) return false;
            else if(readers.containsKey(callingThread)) return true;
            else if(writeRequests > 0) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Read-Read-Reentrance-Lock Program");
    }
}