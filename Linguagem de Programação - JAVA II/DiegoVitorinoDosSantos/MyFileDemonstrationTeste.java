/**
 * @author Diego Vitorino dos Santos
 */

import java.util.Scanner;

public class MyFileDemonstrationTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Scanner input = new Scanner( System.in );
	      MyFileDemonstration myApplication = new MyFileDemonstration();

	      System.out.print( "Enter file or directory name here: " );	    
	      myApplication.analyzePath(input.nextLine());
	}

}
