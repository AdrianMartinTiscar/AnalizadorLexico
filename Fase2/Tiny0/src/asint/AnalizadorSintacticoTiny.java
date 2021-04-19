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
		Dec();
		RestoDec();
	}

	private void RestoDec() {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Decs();
			break;
		case SEPAR:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.SEPAR);
		}
	}

	private void Dec() {
		switch (anticipo.clase()) {
		case INT:
			empareja(ClaseLexica.INT);
			empareja(ClaseLexica.ID);
			break;
		case BOOL:
			empareja(ClaseLexica.BOOL);
			empareja(ClaseLexica.ID);
			break;
		case REAL:
			empareja(ClaseLexica.REAL);
			empareja(ClaseLexica.ID);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.BOOL, ClaseLexica.REAL);
		}

	}

	private void Separacion() {
		empareja(ClaseLexica.SEPAR);
	}

	private void Instrs() {
		Instr();
		restoIns();
	}

	private void Instr() {
		switch (anticipo.clase()) {
		case ID:
			empareja(ClaseLexica.ID);
			igual();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.ID);
		}
	}

	private void restoIns() {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Instrs();
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.EOF);
		}
	}

	private void igual() {
		switch (anticipo.clase()) {
		case IGUAL:
			empareja(ClaseLexica.IGUAL);
			//expr();
			E0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.IGUAL);
		}

	}

	/*
	 * private void expr() { switch (anticipo.clase()) { case NENTERO:
	 * empareja(ClaseLexica.NENTERO);
	 * 
	 * break; case NREAL: empareja(ClaseLexica.NREAL);
	 * 
	 * break; case ID: empareja(ClaseLexica.ID);
	 * 
	 * break; case TRUE: empareja(ClaseLexica.TRUE);
	 * 
	 * break; case FALSE: empareja(ClaseLexica.FALSE);
	 * 
	 * break; default: errores.errorSintactico(anticipo.fila(), anticipo.columna(),
	 * anticipo.clase(), ClaseLexica.NENTERO, ClaseLexica.NREAL, ClaseLexica.ID,
	 * ClaseLexica.TRUE, ClaseLexica.FALSE); }
	 * 
	 * }
	 */

	private void E0() {
		switch (anticipo.clase()) {
		case NENTERO: case NREAL: case ID: case TRUE: case FALSE: case PAP: case NOT: case RESTA: 
			E1();
			RE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.NENTERO,
					ClaseLexica.NREAL, ClaseLexica.ID, ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.PAP, 
					ClaseLexica.PAP, ClaseLexica.NOT, ClaseLexica.RESTA);
		}
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
