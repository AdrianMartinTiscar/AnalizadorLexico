package asint;

import java.io.IOException;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import alex.UnidadLexica;
import errores.GestionErroresTiny0;
import procesamiento.SemOps;
import procesamiento.TinyASint.Decs;
import procesamiento.TinyASint.Dec;
import procesamiento.TinyASint.*;
import procesamiento.TinyASint.Inst;
import procesamiento.TinyASint.Insts;

public class AnalizadorSintacticoTiny {

	private UnidadLexica anticipo;
	private AnalizadorLexicoTiny alex;
	private GestionErroresTiny0 errores;
	private SemOps sem;

	public AnalizadorSintacticoTiny(Reader input) throws IOException {
		errores = new GestionErroresTiny0();

		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();
		sem = new SemOps();

	}
	
	public Programa Programa() {
		Decs decs = Decs();
		Separacion(); //Y esto, ninio?
		Insts inss = Instrs();
		empareja(ClaseLexica.EOF);
		return sem.programa(decs, inss);
	}

	private Decs Decs() {
		switch (anticipo.clase()) {
		case BOOL:
		case INT:
		case REAL:
			Dec dec = Dec();
			return RestoDec(sem.declaracion_una(dec));
		case SEPAR:
			return null;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
					ClaseLexica.BOOL, ClaseLexica.INT, ClaseLexica.REAL);
			return null;

		}
	}

	private Decs RestoDec(Decs decsh) {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Dec dec = Dec();
			return RestoDec(sem.declaracion_varias(decsh, dec));
		case SEPAR:
			return decsh;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.SEPAR);
			return null;
		}
	}

	private Dec Dec() {
		UnidadLexica tipo;
		UnidadLexica id;
		switch (anticipo.clase()) {
		case INT:
			tipo = anticipo;
			empareja(ClaseLexica.INT);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec(sem.str(tipo.lexema(),tipo.fila(),tipo.columna()),
                    sem.str(id.lexema(),id.fila(),id.columna()));
		case BOOL:
			tipo = anticipo;
			empareja(ClaseLexica.BOOL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec(sem.str(tipo.lexema(),tipo.fila(),tipo.columna()),
                    sem.str(id.lexema(),id.fila(),id.columna()));
		case REAL:
			tipo = anticipo;
			empareja(ClaseLexica.REAL);
			id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.dec(sem.str(tipo.lexema(),tipo.fila(),tipo.columna()),
                    sem.str(id.lexema(),id.fila(),id.columna()));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.BOOL, ClaseLexica.REAL);
			return null;
		}

	}
	// revisar
	private void Separacion() {
		switch (anticipo.clase()) {
		case SEPAR:
			empareja(ClaseLexica.SEPAR);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.SEPAR);
		}
	}
	
	private Insts Instrs() {
		switch (anticipo.clase()) {
		case ID:
			Inst ins = Instr();
			return restoIns(sem.instruccion_una(ins));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.ID, ClaseLexica.EXPRES);
			return null;

		}
	}

	private Inst Instr() {
		switch (anticipo.clase()) {
		case ID:
			UnidadLexica id = anticipo;
			empareja(ClaseLexica.ID);
			empareja(ClaseLexica.IGUAL);
			UnidadLexica e = anticipo;
			Exp exp = E0();
			return sem.instruccion(sem.str(id.lexema(), id.fila(), id.columna()),
					sem.str(e.lexema(), e.fila(), e.columna()));
			
			
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.ID);
			return null;
		}
	}

	private Insts restoIns(Insts insh) {
		switch (anticipo.clase()) {
		case PTOCOMA:
			empareja(ClaseLexica.PTOCOMA);
			Inst ins = Instr();
			return restoIns(sem.instruccion_varias(insh, ins));
		case EOF:
			return null;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PTOCOMA,
					ClaseLexica.EOF);
			return null;
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
					ClaseLexica.SUMA, ClaseLexica.PTOCOMA, ClaseLexica.EOF);
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
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.NOT, ClaseLexica.PAP);
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
					ClaseLexica.OR, ClaseLexica.PCIE, ClaseLexica.SUMA, ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.PCIE);
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
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.NOT, ClaseLexica.PAP);
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
					ClaseLexica.MEN, ClaseLexica.EQUIV, ClaseLexica.DIST, ClaseLexica.MENEQ, ClaseLexica.MAYEQ,
					ClaseLexica.SUMA, ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.EOF);
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
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.RESTA, ClaseLexica.NOT);
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
					ClaseLexica.DIV, ClaseLexica.PCIE, ClaseLexica.SUMA,
					ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.MAY, ClaseLexica.MEN, ClaseLexica.IGUAL,
					ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.EOF);

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
		case ID:
			empareja(ClaseLexica.ID);
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP);

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
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.RESTA, ClaseLexica.NOT, ClaseLexica.IGUAL);
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
