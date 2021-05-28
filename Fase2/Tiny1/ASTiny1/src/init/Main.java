package init;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import conCup.alex.AnalizadorLexicoTiny;
import conCup.asint.AnalizadorSintacticoTiny;

import conCup.asint.*;
import descendente.Descendente;
import procesamiento.Impresion;
import procesamiento.TinyASint.Prog;

public class Main {

	public static void main(String[] args) throws Exception {
		/*if (args.length != 2) {
			System.out.println(
					"2 argumentos requeridos: I: archivo a analizar; II: desc (analisis descendente)/ asc (analisis ascendente).");
		} else {
			System.out.println("Resultado del analizador " + args[1] + ":");
			if (args[1].equals("desc")) {
				Descendente des = new Descendente(args[0]);
				des.init();
			} else if (args[1].equals("asc")) {
				Ascendente asc = new Ascendente(args[0]);
				asc.init();
			} else
				System.out.println(
						"El segundo argumento debe ser desc (analisis descendente) o asc (analisis ascendente).");
		}*/
		
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
	     AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	     AnalizadorSintacticoTiny constructorast = new AnalizadorSintacticoTiny(alex);
	     Prog p = (Prog) constructorast.parse().value;
	     
	     int a = 1;
	     p.procesa(new Impresion());
	     //constructorast.debug_parse();
	}

}
