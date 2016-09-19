package multithreading;

// Fig. 23.18: RandomCharacters.java
// Class RandomCharacters demonstrates the Runnable interface
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Renato Pradebon
 */
public class RandomCharacters extends JFrame implements ActionListener {

    private final static int SIZE = 5; // number of threads
    private JCheckBox checkboxes[]; // array of JCheckBoxes
    private Lock lockObject = new ReentrantLock(true); // single lock
    // array of RunnableObjects to display random characters
    private RunnableObject[] randomCharacters = new RunnableObject[SIZE];

    // set up GUI and arrays
    public RandomCharacters() {
        checkboxes = new JCheckBox[SIZE]; // allocate space for array
        setLayout(new GridLayout(SIZE, 3, 15, 15)); // set layout

        // create new thread pool with SIZE threads
        ExecutorService runner = Executors.newFixedThreadPool(SIZE);

        // loop SIZE times
        for (int count = 0; count < SIZE; count++) {
            JLabel outputJLabel = new JLabel(); // create JLabel
            outputJLabel.setBackground(Color.ORANGE); // set color
            outputJLabel.setOpaque(true); // set JLabel to be opaque
            this.add(outputJLabel); // add JLabel to JFrame

            // create JCheckBox to control suspend/resume state
            checkboxes[count] = new JCheckBox("Suspended");

            // add listener which executes when JCheckBox is clicked
            checkboxes[count].addActionListener(this);
            this.add(checkboxes[count]); // add JCheckBox to JFrame
            
            // label para o contador
            JLabel labelContadorTempo = new JLabel(); // create JLabel
            labelContadorTempo.setBackground(Color.BLUE); // set color
            labelContadorTempo.setOpaque(true); // set JLabel to be opaque
            this.add(labelContadorTempo); // add JLabel to JFrame
            
            // create a new RunnableObject
            randomCharacters[count] = new RunnableObject(lockObject, outputJLabel, 10, labelContadorTempo, checkboxes[count]);

            // execute RunnableObject
            runner.execute(randomCharacters[count]);
        } // end for

        setSize(500, 200); // set size of window
        setVisible(true); // show window

        runner.shutdown(); // shutdown runner when threads finish
    } // end RandomCharacters constructor

    // handle JCheckBox events
    public void actionPerformed(ActionEvent event) {
        // loop over all JCheckBoxes in array
        for (int count = 0; count < checkboxes.length; count++) {
            // check if this JCheckBox was source of event
            if (event.getSource() == checkboxes[count]) {
                try {
                    randomCharacters[count].toggle(); // toggle state
                } catch (InterruptedException ex) {
                    Logger.getLogger(RandomCharacters.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } // end for
    } // end method actionPerformed

    public static void main(String args[]) {
        // create new RandomCharacters object
        RandomCharacters application = new RandomCharacters();

        // set application to end when window is closed
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } // end main
} // end class RandomCharacters


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
