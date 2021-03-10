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

	private static enum Estado {
		INICIO, RETEOF,RETPTOCOMA, RETID, RETENT, RETIDEC,
		RETDEC, RETEXP, RETISIGN, RETIEXP, RETRES, RETZERO,
		RETSUM, RETAMP, RETDIV, RETMUL, RETMEN, RETMAY,
		RETEQ, RETDIS, RETPAP, RETPCIE, RETIDIS, RETIG, RETMAYIG,
		RETMENIG, RETIAMP
	}

	private Estado estado;

	public AnalizadorLexicoTiny(Reader input) throws IOException {
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual = 1;
		columnaActual = 1;
	}

	public UnidadLexica sigToken() throws IOException {
		estado = Estado.INICIO;
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		lex.delete(0, lex.length());
		while (true) {
			switch (estado) {
			case INICIO:
				if (hayLetra())
					transita(Estado.RETID);
				else if (hayDigitoPos())
					transita(Estado.RETENT);
				else if (hayCero())
					transita(Estado.RETZERO);
				else if (haySuma())
					transita(Estado.RETSUM);
				else if (hayResta())
					transita(Estado.RETMEN);
				else if (hayMul())
					transita(Estado.RETMUL);
				else if (hayDiv())
					transita(Estado.RETDIV);
				else if (hayPAp())
					transita(Estado.RETPAP);
				else if (hayPCierre())
					transita(Estado.RETPCIE);
				else if (hayMenor())
					transita(Estado.RETMEN);
				else if (hayMayor())
					transita(Estado.RETMAY);
				else if (haySeparador())
					transita(Estado.RETIAMP);
				else if (hayDigito())
					transita(Estado.RETENT);
				else if (hayExclamacion())
					transita(Estado.RETDIS);
				else if (hayIgual())
					transita(Estado.RETIG);
				else if (hayPuntoyComa())
					transita(Estado.RETPTOCOMA);
				else if (hayIgnorable())
					transitaIgnorando(Estado.INICIO);
				else if (hayEOF())
					transita(Estado.RETEOF);
				else
					error();
				break;
				
			case RETEOF:
				return unidadEof();
			case RETPTOCOMA:
				return unidadPuntoyComa();
			case RETID:
				if (hayLetra() || hayDigito())
					transita(Estado.RETID);
				else
					return unidadId();
				break;
			case RETENT:
				if (hayDigito())
					transita(Estado.RETENT);
				else if (hayPunto())
					transita(Estado.RETIDEC);
				else if(hayExpo())
					transita(Estado.RETIEXP);
				else
					return unidadEntera();
				break;
			case RETIDEC:
				if(hayCero())
					transita(Estado.RETIDEC);
				else if(hayDigitoPos())
					transita(Estado.RETDEC);
				else
					error();
				break;
			case RETDEC:
				if(hayDigitoPos())
					transita(Estado.RETDEC);
				else if(hayCero())
					transita(Estado.RETIDEC);
				else if(hayExpo())
					transita(Estado.RETIEXP);
				else
					return unidadDecimal();
				break;
			case RETIEXP:
				
				if(hayDigitoPos())
					transita(Estado.RETEXP);
				else if(haySuma() || hayResta())
					transita(Estado.RETISIGN);
				else
					error();
				break;
			case RETEXP:
				if(hayDigito())
					transita(Estado.RETEXP);
				else
					return unidadExpo();
				break;

			case RETISIGN:
				if(hayDigitoPos())
					transita(Estado.RETEXP);
				else
					error();
				break;
			case RETRES:
				if (hayDigitoPos())
					transita(Estado.RETENT);
				else if (hayCero())
					transita(Estado.RETZERO);
				else
					return unidadResta();
				break;
			case RETZERO:
				return unidadEntera();
			case RETSUM:
				if (hayDigitoPos())
					transita(Estado.RETENT);
				else if (hayCero())
					transita(Estado.RETZERO);
				else
					return unidadSuma();
				break;
			case RETIAMP:
				if(haySeparador())
					transita(Estado.RETAMP);
				else error();
				break;
			case RETAMP:
				return unidadSeparacion();
			case RETDIV:
				return unidadDiv();
			case RETMUL:
				return unidadMultiplicacion();
			case RETMEN:
				if(hayIgual())
					transita(Estado.RETMENIG);
				else
					return unidadMenor();
				break;
			case RETMENIG:
				return unidadMenorIgual();
			case RETMAY:
				if(hayIgual())
					transita(Estado.RETMAYIG);
				else
					return unidadMayor();
				break;
			case RETMAYIG:
				return unidadMayorIgual();
			case RETIG:
				if(hayIgual())
					transita(Estado.RETEQ);
				else
					return unidadIgual();
				break;
			case RETEQ:
				return unidadEquivalente();
			case RETIDIS:
				if(hayIgual())
					transita(Estado.RETDIS);
				else
					error();
				break;
			case RETDIS:
				return unidadDistinto();
			case RETPAP:
				return unidadPApertura();
			case RETPCIE:
				return unidadPCierre();				
			}
		}
	}
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
	private boolean hayPunto() {
		return sigCar == '.';
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
	
	private boolean hayExpo() {
		return sigCar == 'e' || sigCar == 'E';
	}


	private boolean hayIgnorable() {
		return sigCar == ' ' || sigCar == '\n'|| sigCar == '\b' || sigCar == '\r' || sigCar == '\t';
	}

		
	private boolean hayEOF() {
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

	private UnidadLexica unidadEntera() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.NENTERO, lex.toString());
	}

	
	private UnidadLexica unidadExpo() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.EXPON, lex.toString());
	}
	
	private UnidadLexica unidadDecimal() {
		return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.DEC, lex.toString());
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
	
	private UnidadLexica unidadEquivalente() {
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
