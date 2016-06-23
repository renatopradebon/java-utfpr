package multithreading;

// Fig. 23.17: RunnableObject.java
// Runnable that writes a random character to a JLabel
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class RunnableObject implements Runnable {

    private static Random generator = new Random(); // for random letters
    private Lock lockObject; // application lock; passed in to constructor
    private Condition suspend; // used to suspend and resume thread
    private boolean suspended = false; // true if thread suspended
    private JLabel output; // JLabel for output

    public RunnableObject(Lock theLock, JLabel label) {
        lockObject = theLock; // store the Lock for the application
        suspend = lockObject.newCondition(); // create new Condition
        output = label; // store JLabel for outputting character
    } // end RunnableObject constructor

    // place random characters in GUI
    public void run() {
        // get name of executing thread
        final String threadName = Thread.currentThread().getName();
        while (true) // infinite loop; will be terminated from outside
        {
            try {
                // sleep for up to 1 second
                Thread.sleep(generator.nextInt(1000));
                lockObject.lock(); // obtain the lock
                try {
                    while (suspended) // loop until not suspended
                    {
                        suspend.await(); // suspend thread execution
                    } // end while
                } // end try
                finally {
                    lockObject.unlock(); // unlock the lock
                } // end finally
            } // end try
            // if thread interrupted during wait/sleep
            catch (InterruptedException exception) {
                exception.printStackTrace(); // print stack trace
            } // end catch

            // display character on corresponding JLabel
            Runnable objr = new Runnable() {
                        // pick random character and display it
                        public void run() {
                            // select random uppercase letter
                            char displayChar = (char) (generator.nextInt(26) + 65);
                            // output character in JLabel
                            output.setText(threadName + ": " + displayChar);
                            //output.setForeground(Color.);
                        } // end method run
                    }; // end inner class
            SwingUtilities.invokeLater(objr); // end call to SwingUtilities.invokeLater
        } // end while
    } // end method run

    // change the suspended/running state
    public void toggle() {
        suspended = !suspended; // toggle boolean controlling state

        // change label color on suspend/resume
        output.setBackground(suspended ? Color.RED : Color.GREEN);

        //if (suspended){
        //    output.setBackground(Color.RED);
        //}else{
        //    output.setBackground(Color.GREEN);
        //}

        lockObject.lock(); // obtain lock
        try {
            if (!suspended) // if thread resumed
            {
                suspend.signal(); // resume thread
            } // end if
        } // end try
        finally {
            lockObject.unlock(); // release lock
        } // end finally
    } // end method toggle
} // end class RunnableObject

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
