package asint;

import java.io.IOException;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
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
		Decs();
		Separacion();
		Instrs();
		empareja(ClaseLexica.EOF);
	}

	private void Decs() {
		switch(anticipo.clase()) {
		case DEC:
			Dec();
			RestoDec();
			break;		
		default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                ClaseLexica.INT, ClaseLexica.BOOL, ClaseLexica.REAL); 
		}
	}
	
	private void RestoDec() {
		switch(anticipo.clase()) {
		case PTOCOMA:
			Dec();
			Decs();
			break;	
		case SEPAR: break;
		default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                ClaseLexica.INT, ClaseLexica.BOOL, ClaseLexica.REAL); 
		}
	}

	private void Separacion() {
		
	}

	private void Instrs() {
		
		
	}
	
	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), claseEsperada);
	}

	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}
}
