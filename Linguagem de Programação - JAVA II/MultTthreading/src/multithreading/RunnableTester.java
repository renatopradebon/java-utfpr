package multithreading;

// Fig. 23.5: RunnableTester.java
// Impressão de múltiplas threads em diferentes intervalos.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class RunnableTester {

    public static void main(String[] args) {
        // cria e nomeia cada executável
        PrintTask task1;//declaracao
        task1 = new PrintTask("thread1");//instanciacao.
        PrintTask task2 = new PrintTask("thread2");
        PrintTask task3 = new PrintTask("thread3");
        PrintTask task4 = new PrintTask("thread4");
        PrintTask task5 = new PrintTask("thread5");
        
        task1.run();
        task2.run();
        task3.run();
        task4.run();
        task5.run();
        
        System.out.println("Starting threads");

        /*
        // cria ExecutorService para gerenciar threads
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        
        //ExecutorService threadExecutor = Executors.newCachedThreadPool();

        // inicia threads e coloca no estado executável
        threadExecutor.execute(task1); // inicia task1
        threadExecutor.execute(task2); // inicia task2
        threadExecutor.execute(task3); // inicia task3
        threadExecutor.execute(task4); // inicia task3
        threadExecutor.execute(task5); // inicia task3

        threadExecutor.shutdown(); // encerra as threads trabalhadoras
*/
        System.out.println("Threads started, main ends\n");
    } // fim do main
} // fim da classe RunnableTester 


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