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

	private Exp RestoE0(Exp exph) {
		switch (anticipo.clase()) {
		case RESTA:
			empareja(ClaseLexica.RESTA);
			Exp e1 = E1();
			return sem.resta(exph, e1);
		case SUMA:
			empareja(ClaseLexica.SUMA);
			Exp e0 = E0();
			return sem.suma(exph, e0);
		case EOF:
		case PTOCOMA:
		case PCIE:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.SUMA, ClaseLexica.PTOCOMA, ClaseLexica.EOF);
			return null;
		}
	}

	private Exp E0() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			Exp exp = E1();
			return RestoE0(exp);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.NOT, ClaseLexica.PAP);
			return null;
		}
	}

	private Exp Rest2E1(Exp exph) {
		switch (anticipo.clase()) {
		case AND:
		case OR:
			String op = op1AI();
			Exp e2 = E2();
			Exp eRes = Rest2E1(e2);
			return sem.exp(op, exph, eRes);
		case EXPRES:
		case NENTERO:
		case NREAL:
		case ID:
		case EOF:
		case PTOCOMA:
		case PCIE:
		case SUMA:
		case RESTA:
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR, ClaseLexica.PCIE, ClaseLexica.SUMA, ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.PCIE);
			return null;
		}
	}

	private Exp E1() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			Exp e2 = E2();
			return Rest2E1(e2);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.RESTA,
					ClaseLexica.NOT, ClaseLexica.PAP);
			return null;
		}
	}

	private Exp Rest2E2(Exp exph) {
		switch (anticipo.clase()) {
		case MAY:
		case MEN:
		case EQUIV:
		case DIST:
		case MENEQ:
		case MAYEQ:
			String op = op2AI();
			Exp e3 = E3();
			Exp eRes = Rest2E2(e3);
			return sem.exp(op, exph,  eRes);
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
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MAY,
					ClaseLexica.MEN, ClaseLexica.EQUIV, ClaseLexica.DIST, ClaseLexica.MENEQ, ClaseLexica.MAYEQ,
					ClaseLexica.SUMA, ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.EOF);
			return null;
		}
	}

	private Exp E2() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			Exp e3 = E3();
			return Rest2E2(e3);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.RESTA, ClaseLexica.NOT);
			return null;
		}
	}

	private Exp RestE3(Exp exph) {
		switch (anticipo.clase()) {
		case MUL:
		case DIV:
			String op = op3NA();
			Exp e4 = E4();
			return sem.exp(op, exph, e4);
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
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV, ClaseLexica.PCIE, ClaseLexica.SUMA,
					ClaseLexica.RESTA, ClaseLexica.PTOCOMA, ClaseLexica.MAY, ClaseLexica.MEN, ClaseLexica.IGUAL,
					ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.EOF);
			return null;

		}
	}

	private Exp E3() {
		switch (anticipo.clase()) {
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
		case SUMA:
		case RESTA:
			Exp e4 = E4();
			return RestE3(e4);
			
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NOT, ClaseLexica.RESTA);
			return null;

		}
	}

	private Exp E4() {
		switch (anticipo.clase()) {
		case NOT:
			return sem.not(E4());
		case EXPRES:
		case PAP:
		case NENTERO:
		case NREAL:
		case ID:
			return E5();
		//Suma debería estar?
		/*case SUMA:
			empareja(ClaseLexica.SUMA);
			E5();
			*/
		case RESTA:
			empareja(ClaseLexica.RESTA);
			return sem.neg(E5());
		case EOF:
			return null;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP,
					ClaseLexica.NOT, ClaseLexica.RESTA);
			return null;

		}
	}

	private Exp E5() {
		switch (anticipo.clase()) {
		case PAP:
			empareja(ClaseLexica.PAP);
			Exp e = E0();
			empareja(ClaseLexica.PCIE);
			return e;
		case NENTERO:
			UnidadLexica entero = anticipo;
			empareja(ClaseLexica.NENTERO);
			return sem.num(sem.str(entero.lexema(), entero.fila(), entero.columna()));
		case NREAL:
			UnidadLexica real = anticipo;
			empareja(ClaseLexica.NREAL);
			return sem.num(sem.str(real.lexema(), real.fila(), real.columna()));
		case ID:
			UnidadLexica id = anticipo;
			empareja(ClaseLexica.ID);
			return sem.id(sem.str(id.lexema(), id.fila(), id.columna()));
		case EOF:
			return null;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PAP);
			return null;

		}
	}

	private String op1AI() {
		switch (anticipo.clase()) {
		case AND:
			empareja(ClaseLexica.AND);
			return "and";
		case OR:
			empareja(ClaseLexica.OR);
			return "or";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND,
					ClaseLexica.OR);
			return null;

		}
	}
	//Creo que esto no hace nada
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

	private String op2AI() {
		switch (anticipo.clase()) {
		case MEN:
			empareja(ClaseLexica.MEN);
			return "<";
		case MAY:
			empareja(ClaseLexica.MAY);
			return ">";
		case EQUIV:
			empareja(ClaseLexica.EQUIV);
			return "==";
		case DIST:
			empareja(ClaseLexica.DIST);
			return "!=";
		case MENEQ:
			empareja(ClaseLexica.MENEQ);
			return "<=";
		case MAYEQ:
			empareja(ClaseLexica.MAYEQ);
			return ">=";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MEN,
					ClaseLexica.EQUIV, ClaseLexica.MAY, ClaseLexica.DIST);
			return null;
		}
	}

	private String op3NA() {
		switch (anticipo.clase()) {
		case MUL:
			empareja(ClaseLexica.MUL);
			return "*";
		case DIV:
			empareja(ClaseLexica.DIV);
			return "/";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MUL,
					ClaseLexica.DIV);
			return null;
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
