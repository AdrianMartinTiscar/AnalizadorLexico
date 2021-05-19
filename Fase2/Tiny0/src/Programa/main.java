
package Programa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import alex.UnidadLexica;
import asint.AnalizadorSintacticoTiny;
import procesamiento.Impresion;
import procesamiento.Procesamiento;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(input);
		try {
			asint.Programa();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
	     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	     asint.AnalizadorSintacticoTiny constructorast = new asint.AnalizadorSintacticoTiny(input);
	     constructorast.Programa().procesa((Procesamiento) new Impresion());
	}
}
