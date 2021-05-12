package init;

import conCup.asint.*;
import descendente.Descendente;

public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
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
		}

	}

}
