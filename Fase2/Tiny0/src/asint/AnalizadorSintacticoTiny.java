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

	public AnalizadorSintacticoTiny(Reader input) throws IOException {
		errores = new GestionErroresTiny0();

		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();

	}

	public void Programa() {
		Decs();
		Separacion();
		Instrs();
		empareja(ClaseLexica.EOF);
	}

	private void Decs() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
		case REAL:
			Dec();
			RestoDec();
			break;
		case SEPAR:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.BOOL, ClaseLexica.INT, ClaseLexica.REAL);

		}
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
		switch (anticipo.clase()) {
		case SEPAR:
			empareja(ClaseLexica.SEPAR);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.SEPAR);
		}
	}

	private void Instrs() {
		switch (anticipo.clase()) {
		case ID:
			Instr();
			restoIns();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.ASIG);

		}
	}

	private void Instr() {
		switch (anticipo.clase()) {
		case ID:
			empareja(ClaseLexica.ID);
			empareja(ClaseLexica.IGUAL);
			E0();
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

	private void RestoE0() {
		switch (anticipo.clase()) {
		case RESTA:
			empareja(ClaseLexica.RESTA);
			E1();
			break;
		case SUMA:
			empareja(ClaseLexica.SUMA);
			E0();
			break;
		case EOF:
		case PTOCOMA:
		case PCIE:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.SUMA);
		}
	}

	private void E0() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			E1();
			RestoE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.EXPRES);
		}
	}

	private void Rest2E1() {
		switch (anticipo.clase()) {
		case AND:
		case OR:
			op1AI();
			E2();
			Rest2E1();
			break;
		case EXPRES:
		case NENTERO:
		case NREAL:
		case ID:
		case EOF:
		case PTOCOMA:
		case PCIE:
		case SUMA:
		case RESTA:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR);
		}
	}

	private void E1() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			E2();
			Rest2E1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.EXPRES);
		}
	}

	private void Rest2E2() {
		switch (anticipo.clase()) {
		case MAY:
		case MEN:
		case EQUIV:
		case DIST:
		case MENEQ:
		case MAYEQ:
			op2AI();
			E3();
			Rest2E2();
			break;
		case EXPRES:
		case NENTERO:
		case NREAL:
		case ID:
		case EOF:
		case PTOCOMA:
		case PCIE:
		case SUMA:
		case RESTA:
		case AND:
		case OR:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAY,
					ClaseLexica.MEN, ClaseLexica.EQUIV, ClaseLexica.DIST, ClaseLexica.MENEQ, ClaseLexica.MAYEQ);
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			E3();
			Rest2E2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.EXPRES);
		}
	}

	private void RestE3() {
		switch (anticipo.clase()) {
		case MUL:
		case DIV:
			op3NA();
			E4();
			break;
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case EOF:
		case PCIE:
		case SUMA:
		case RESTA:
		case PTOCOMA:
		case AND:
		case OR:
		case MAY:
		case MEN:
		case EQUIV:
		case DIST:
		case MENEQ:
		case MAYEQ:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV, ClaseLexica.EXPRES, ClaseLexica.PAP);

		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			E4();
			RestE3();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NOT, ClaseLexica.RESTA);

		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case NOT:
			E4();
			break;
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
			E5();
			break;
		case SUMA:
			empareja(ClaseLexica.SUMA);
			E5();
		case RESTA:
			empareja(ClaseLexica.RESTA);
			E5();
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NOT, ClaseLexica.RESTA);

		}
	}

	private void E5() {
		switch (anticipo.clase()) {
		case PAP:
			empareja(ClaseLexica.PAP);
			E0();
			empareja(ClaseLexica.PCIE);
			break;
		case NENTERO:
			empareja(ClaseLexica.NENTERO);
			break;
		case NREAL:
			empareja(ClaseLexica.NREAL);
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NENTERO, ClaseLexica.DEC, ClaseLexica.EXPON);

		}
	}

	private void op1AI() {
		switch (anticipo.clase()) {
		case AND:
			empareja(ClaseLexica.AND);
			break;
		case OR:
			empareja(ClaseLexica.OR);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR);

		}
	}

	private void resto() {
		switch (anticipo.clase()) {
		case MENEQ:
			empareja(ClaseLexica.MENEQ);
			break;
		case MAYEQ:
			empareja(ClaseLexica.MAYEQ);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.DIST,
					ClaseLexica.EQUIV);
		}
	}

	private void op2AI() {
		switch (anticipo.clase()) {
		case MEN:
			empareja(ClaseLexica.MEN);
			break;
		case MAY:
			empareja(ClaseLexica.MAY);
			break;
		case EQUIV:
			empareja(ClaseLexica.EQUIV);
			break;
		case DIST:
			empareja(ClaseLexica.DIST);
			break;
		case MENEQ:
			empareja(ClaseLexica.MENEQ);
			break;
		case MAYEQ:
			empareja(ClaseLexica.MAYEQ);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MEN,
					ClaseLexica.EQUIV, ClaseLexica.MAY, ClaseLexica.DIST);
		}
	}

	private void op3NA() {
		switch (anticipo.clase()) {
		case MUL:
			empareja(ClaseLexica.MUL);
			break;
		case DIV:
			empareja(ClaseLexica.DIV);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV);
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
