package multithreading;

// Fig. 23.19: SSynchronizedBuffer.java
// SynchronizedBuffer synchronizes access to a single shared integer.
public class SSynchronizedBuffer implements Buffer {

    private int buffer = -1; // shared by producer and consumer threads
    private boolean occupied = false; // count of occupied buffers

    // place value into buffer
    public synchronized void set(int value) {
        try {
            // while there are no empty locations, place thread in waiting state
            while (occupied) {
                // output thread information and buffer information, then wait
                System.out.println("Producer tries to write.");
                displayState("Buffer full. Producer waits.");
                wait();
            } // end while
            buffer = value; // set new buffer value
            // indicate producer cannot store another value
            // until consumer retrieves current buffer value
            occupied = true;
            displayState("Producer writes " + buffer);
            notify(); // tell waiting thread to enter runnable state
        } // end try
        catch (InterruptedException exception) {
            exception.printStackTrace();
        } // end catch
    } // end method set; releases lock on SynchronizedBuffer

    // return value from buffer
    public synchronized int get() {
        int readValue = 0; // initialize value read from buffer
        try {
            // while no data to read, place thread in waiting state
            synchronized (this) {
                while (!occupied) {
                    // output thread information and buffer information, then wait
                    System.out.println("Consumer tries to read.");
                    displayState("Buffer empty. Consumer waits.");
                    wait();
                } // end while
                // indicate that producer can store another value
                // because consumer just retrieved buffer value
                occupied = false;
                readValue = buffer; // store value in buffer
                displayState("Consumer reads " + readValue);
                notify(); // tell waiting thread to enter runnable state
            }
        } // end try
        catch (InterruptedException exception) {
            exception.printStackTrace();
        } // end catch

        return readValue;
    } // end method get; releases lock on SynchronizedBuffer

    // display current operation and buffer state
    public void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer,
                occupied);
    } // end method displayState
} // end class SynchronizedBuffer

