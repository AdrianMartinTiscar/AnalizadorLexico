package init;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import conCup.alex.AnalizadorLexicoTiny;
import conCup.asint.AnalizadorSintacticoTiny;

import conCup.asint.*;
import descendente.ConstructorAST1;
import procesamiento.Impresion;
import procesamiento.TinyASint.Prog;

public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println(
					"2 argumentos requeridos: I: archivo a analizar; II: desc (analisis descendente)/ asc (analisis ascendente).");
		} else {
			System.out.println("Resultado del analizador " + args[1] + ":");
			Prog pro = null;
			if (args[1].equals("desc")) {
				pro = ejecuta_descendente(args[0]);
			} else if (args[1].equals("asc")) {
				pro = ejecuta_ascendente(args[0]);
			} else
				System.out.println(
						"El segundo argumento debe ser desc (analisis descendente) o asc (analisis ascendente).");
		pro.procesa(new Impresion());
		}		
	}

	private static Prog ejecuta_ascendente(String in) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(in));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny constructorast = new AnalizadorSintacticoTiny(alex);
		return (Prog) constructorast.parse().value;
	}

	private static Prog ejecuta_descendente(String in) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(in));
		descendente.ConstructorAST1 constructorast = new descendente.ConstructorAST1(input);
		return constructorast.ProgramaPrev();
	}

}
