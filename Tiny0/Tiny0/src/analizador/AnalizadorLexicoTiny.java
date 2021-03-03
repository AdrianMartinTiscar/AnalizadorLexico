package analizador;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;

public class AnalizadorLexicoTiny {

	private Reader input;
	private StringBuffer lex;
	private int sigCar;
	private int filaInicio;
	private int columnaInicio;
	private int filaActual;
	private int columnaActual;
	private static String NL = System.getProperty("line.separator");

//	private static enum Estado {
//		INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_COMA, REC_IGUAL, REC_MAS, REC_MENOS, REC_ID, REC_ENT, REC_0,
//		REC_IDEC, REC_DEC, REC_COM, REC_EOF
//	}

	private Estado estado;

	public AnalizadorLexicoTiny(Reader input) throws IOException {
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual = 1;
		columnaActual = 1;
	}

//	public UnidadLexica sigToken() throws IOException {
//		estado = Estado.INICIO;
//		filaInicio = filaActual;
//		columnaInicio = columnaActual;
//		lex.delete(0, lex.length());
//		while (true) {
//			switch (estado) {
//			case INICIO:
//				if (hayLetra())
//					transita(Estado.REC_ID);
//				else if (hayDigitoPos())
//					transita(Estado.REC_ENT);
//				else if (hayCero())
//					transita(Estado.REC_0);
//				else if (haySuma())
//					transita(Estado.REC_MAS);
//				else if (hayResta())
//					transita(Estado.REC_MENOS);
//				else if (hayMul())
//					transita(Estado.REC_POR);
//				else if (hayDiv())
//					transita(Estado.REC_DIV);
//				else if (hayPAp())
//					transita(Estado.REC_PAP);
//				else if (hayPCierre())
//					transita(Estado.REC_PCIERR);
//				else if (hayIgual())
//					transita(Estado.REC_IGUAL);
//				else if (hayComa())
//					transita(Estado.REC_COMA);
//				else if (hayAlmohadilla())
//					transitaIgnorando(Estado.REC_COM);
//				else if (haySep())
//					transitaIgnorando(Estado.INICIO);
//				else if (hayEOF())
//					transita(Estado.REC_EOF);
//				else
//					error();
//				break;
//			case REC_ID:
//				if (hayLetra() || hayDigito())
//					transita(Estado.REC_ID);
//				else
//					return unidadId();
//				break;
//			case REC_ENT:
//				if (hayDigito())
//					transita(Estado.REC_ENT);
//				else if (hayPunto())
//					transita(Estado.REC_IDEC);
//				else
//					return unidadEnt();
//				break;
//			case REC_0:
//				if (hayPunto())
//					transita(Estado.REC_IDEC);
//				else
//					return unidadEnt();
//				break;
//			case REC_MAS:
//				if (hayDigitoPos())
//					transita(Estado.REC_ENT);
//				else if (hayCero())
//					transita(Estado.REC_0);
//				else
//					return unidadMas();
//				break;
//			case REC_MENOS:
//				if (hayDigitoPos())
//					transita(Estado.REC_ENT);
//				else if (hayCero())
//					transita(Estado.REC_0);
//				else
//					return unidadMenos();
//				break;
//			case REC_POR:
//				return unidadPor();
//			case REC_DIV:
//				return unidadDiv();
//			case REC_PAP:
//				return unidadPAp();
//			case REC_PCIERR:
//				return unidadPCierre();
//			case REC_IGUAL:
//				return unidadIgual();
//			case REC_COMA:
//				return unidadComa();
//			case REC_COM:
//				if (hayNL())
//					transitaIgnorando(Estado.INICIO);
//				else if (hayEOF())
//					transita(Estado.REC_EOF);
//				else
//					transitaIgnorando(Estado.REC_COM);
//				break;
//			case REC_EOF:
//				return unidadEof();
//			case REC_IDEC:
//				if (hayDigitoPos())
//					transita(Estado.REC_DEC);
//				else if (hayCero())
//					transita(Estado.REC_IDEC);
//				else
//					error();
//				break;
//			case REC_DEC:
//				if (hayDigitoPos())
//					transita(Estado.REC_DEC);
//				else if (hayCero())
//					transita(Estado.REC_IDEC);
//				else
//					return unidadReal();
//				break;
//			}
//		}
//	}

	private void transita(Estado sig) throws IOException {
		lex.append((char) sigCar);
		sigCar();
		estado = sig;
	}

	private void transitaIgnorando(Estado sig) throws IOException {
		sigCar();
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		estado = sig;
	}

	private void sigCar() throws IOException {
		sigCar = input.read();
		if (sigCar == NL.charAt(0))
			saltaFinDeLinea();
		if (sigCar == '\n') {
			filaActual++;
			columnaActual = 0;
		} else {
			columnaActual++;
		}
	}

	private void saltaFinDeLinea() throws IOException {
		for (int i = 1; i < NL.length(); i++) {
			sigCar = input.read();
			if (sigCar != NL.charAt(i))
				error();
		}
		sigCar = '\n';
	}
	
	private boolean haySeparador() {
		return sigCar == '&';
	}

	private boolean hayLetra() {
		return sigCar >= 'a' && sigCar <= 'z' || sigCar >= 'A' && sigCar <= 'z';
	}

	private boolean hayDigitoPos() {
		return sigCar >= '1' && sigCar <= '9';
	}

	private boolean hayCero() {
		return sigCar == '0';
	}

	private boolean hayDigito() {
		return hayDigitoPos() || hayCero();
	}

	private boolean haySuma() {
		return sigCar == '+';
	}

	private boolean hayResta() {
		return sigCar == '-';
	}

	private boolean hayMul() {
		return sigCar == '*';
	}

	private boolean hayDiv() {
		return sigCar == '/';
	}

	private boolean hayPAp() {
		return sigCar == '(';
	}

	private boolean hayPCierre() {
		return sigCar == ')';
	}

	private boolean hayIgual() {
		return sigCar == '=';
	}

	private boolean hayMenor() {
		return sigCar == '<';
	}
	
	private boolean hayMayor() {
		return sigCar == '>';
	}
	
	private boolean hayExclamacion() {
		return sigCar == '!';
	}
	
	private boolean hayPuntoyComa() {
		return sigCar == ';';
	}


	private boolean hayIgnorable() {
		return sigCar == ' ' || sigCar == '\n'|| sigCar == '\b' || sigCar == '\r';
	}
	
	//Posible necesidad de añadir separadores al leer algo????????? son los ignorables????
	
	
	private boolean hayEOF() {//NECESARIO??????????
		return sigCar == -1;
	}

	private UnidadLexica unidadId() {
		switch (lex.toString()) {
		case "int":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.INT);
		case "real":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.REAL);
		case "bool":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.BOOL);
		case "true":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TRUE);
		case "false":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.FALSE);
		case "and":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.AND);
		case "or":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OR);
		case "not":
			return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.NOT);
		default:
			return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.ID, lex.toString());
		}
	}

	private UnidadLexica unidadAsigna() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.ASIG, lex.toString());
	}

	private UnidadLexica unidadEntera() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.NENTERO, lex.toString());
	}

	private UnidadLexica unidadReal() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.NREAL, lex.toString());
	}
	
	private UnidadLexica parteExpo() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.EXPON, lex.toString());
	}
	
	private UnidadLexica parteDecimal() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.DEC, lex.toString());
	}
	
	private UnidadLexica unidadExpresion() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.EXPRES, lex.toString());
	}
	
	private UnidadLexica unidadSeparacion() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.SEPAR, lex.toString());
	}

	private UnidadLexica unidadSuma() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.SUMA);
	}

	private UnidadLexica unidadResta() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.RESTA);
	}

	private UnidadLexica unidadMultiplicacion() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MUL);
	}

	private UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.DIV);
	}

	private UnidadLexica unidadPApertura() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PAP);
	}

	private UnidadLexica unidadPCierre() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PCIE);
	}

	private UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.IGUAL);
	}
	
	private UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MEN);
	}

	private UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MAY);
	}
	
	private UnidadLexica unidadMenorIgual() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MENEQ);
	}
	
	private UnidadLexica unidadMayorIgual() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MAYEQ);
	}
	
	private UnidadLexica unidadPuntoyComa() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PTOCOMA);
	}
	
	private UnidadLexica unidadEquivalencia() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EQUIV);
	}

	private UnidadLexica unidadDistinto() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.DIST);
	}
	
	private UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EOF);
	}
	
	private void error() {
		System.err.println("(" + filaActual + ',' + columnaActual + "):Caracter inexperado");
		System.exit(1);
	}

	public static void main(String arg[]) throws IOException {

		Reader input = new InputStreamReader(new FileInputStream("input.txt"));
		AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
		UnidadLexica unidad;
		do {
			unidad = al.sigToken();
			System.out.println(unidad);
		} while (unidad.clase() != ClaseLexica.EOF);

	}
}
