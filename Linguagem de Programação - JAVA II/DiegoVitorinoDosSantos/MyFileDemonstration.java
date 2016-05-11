/**
 * @author Diego Vitorino dos Santos
 */

import java.io.File;

public class MyFileDemonstration {
	
	private int numPastas = 0;
	private int numArquivos = 0;
		
	public void analyzePath(String caminho){
		
		File nome = new File(caminho);
		if (nome.exists()) {	
			
			System.out.printf( 
					"%s\n%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s",
					(nome.getName() != "" ? nome.getName() + " exists" : "is not exists"),
					(nome.isFile() ? "is a file" : "is not a file" ),
					(nome.isDirectory() ? "is directory" : "is not a directory"),
					("Lenght: "+(nome.length()/1048576.0)+" Mb"),
					(nome.isAbsolute() ? "is absolute path" : "is not absolute path"),
					"Last modified: ", nome.lastModified(), 
					"Absolute path: ", nome.getAbsolutePath(),
					"Parent: ", nome.getParent());
			
			if (nome.isDirectory()){
				System.out.println("\n\n     Tamanho em MB: "+ tamanhoDiretorio(nome)/1048576.0);
				System.out.println("  Numero de Pastas: "+ numPastas);
				System.out.println("Numero de Arquivos: "+ numArquivos);


			}
		}
		
	}
	
	private long tamanhoDiretorio(File diretorio){
		long sum = 0;
        for (File dir : diretorio.listFiles()) {
	            if (dir.isDirectory()) {
	            	numPastas += 1;
	            	sum += tamanhoDiretorio (dir);
	            } else {
	            	numArquivos += 1;
	            	sum += dir.length();
	            }
        }
		return sum;
	}	

}

// 1 MB = 1.048.576 bytes