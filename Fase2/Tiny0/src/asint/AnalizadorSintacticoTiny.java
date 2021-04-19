package asint;

import java.io.IOException;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;
import errores.GestionErroresTiny0;

public class AnalizadorSintacticoTiny {

	private UnidadLexica anticipo;
	private AnalizadorLexicoTiny alex;
	private GestionErroresTiny0 errores;

	public AnalizadorSintacticoTiny(Reader input) {
		errores = new GestionErroresTiny0();
		try {
			alex = new AnalizadorLexicoTiny(input);
			alex.fijaGestionErrores(errores);
			sigToken();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void Programa() {

	}

	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}
}
