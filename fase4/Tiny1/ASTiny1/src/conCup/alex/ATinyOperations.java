package conCup.alex;

import conCup.asint.ClaseLexica;

public class ATinyOperations {
	private AnalizadorLexicoTiny aLexi;

	public ATinyOperations(AnalizadorLexicoTiny alex) {
		this.aLexi = alex;
	}

	public UnidadLexica unidadEntero() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NENTERO, aLexi.lexema());
	}

	public UnidadLexica unidadReal() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NREAL, aLexi.lexema());
	}

	public UnidadLexica unidadSuma() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.SUMA, "+");
	}

	public UnidadLexica unidadResta() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.RESTA, "-");
	}

	public UnidadLexica unidadMultiplicacion() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.MUL, "*");
	}

	public UnidadLexica unidadDivision() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.DIV, "/");
	}

	public UnidadLexica unidadParentesisApertura() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PAP, "(");
	}

	public UnidadLexica unidadParentesisCierre() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PCIE, ")");
	}

	public UnidadLexica unidadIgual() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.IGUAL, "=");
	}

	public UnidadLexica unidadDistinto() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.DIST, "!=");
	}

	public UnidadLexica unidadMenor() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.MEN, "<");
	}

	public UnidadLexica unidadMayor() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.MAY, ">");
	}

	public UnidadLexica unidadComa() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.COMA, ",");
	}

	public UnidadLexica unidadEof() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.EOF, "<EOF>");
	}

	public UnidadLexica unidadAmpersand() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.AMP, "&");
	}

	public UnidadLexica unidadIdentificador() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.ID, aLexi.lexema());
	}

	public UnidadLexica unidadSeparacion() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.SEPARACION, "&&");
	}

	public UnidadLexica unidadMenorIgual() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.MENEQ, "<=");
	}

	public UnidadLexica unidadMayorIgual() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.MAYEQ, ">=");
	}

	public UnidadLexica unidadEquivalente() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.EQUIV, "==");
	}

	public UnidadLexica unidadDo() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.DO, "do");
	}

	public UnidadLexica unidadIf() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.IF, "if");
	}

	public UnidadLexica unidadNl() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NL, "nl");
	}

	public UnidadLexica unidadOf() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.OF, "of");
	}

	public UnidadLexica unidadOr() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.OR, "or");
	}

	public UnidadLexica unidadAnd() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.AND, "and");
	}

	public UnidadLexica unidadLiteralCadena() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.LITCAD, aLexi.lexema());
	}

	public UnidadLexica unidadRecord() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.RECORD, "record");
	}

	public UnidadLexica unidadStringT() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.STRING, "string");
	}

	public UnidadLexica unidadPointer() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.POINTER, "pointer");
	}

	public UnidadLexica unidadEndwhile() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.ENDWHILE, "endwhile");
	}

	public UnidadLexica unidadDelete() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.DELETE, "delete");
	}

	public UnidadLexica unidadWrite() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.WRITE, "write");
	}

	public UnidadLexica unidadWhile() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.WHILE, "while");
	}

	public UnidadLexica unidadFalse() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.FALSE, "false");
	}

	public UnidadLexica unidadEndif() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.ENDIF, "endif");
	}

	public UnidadLexica unidadArray() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PARRAY, "array");
	}

	public UnidadLexica unidadType() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.TYPE, "type");
	}

	public UnidadLexica unidadTrue() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.TRUE, "true");
	}

	public UnidadLexica unidadThen() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.THEN, "then");
	}

	public UnidadLexica unidadRealT() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.REAL, "real");
	}

	public UnidadLexica unidadRead() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.READ, "read");
	}

	public UnidadLexica unidadProc() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PROC, "proc");
	}

	public UnidadLexica unidadNull() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NULL, "null");
	}

	public UnidadLexica unidadElse() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.ELSE, "else");
	}

	public UnidadLexica unidadCall() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.CALL, "call");
	}

	public UnidadLexica unidadBoolT() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.BOOL, "bool");
	}

	public UnidadLexica unidadVar() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.VAR, "var");
	}

	public UnidadLexica unidadNot() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NOT, "not");
	}

	public UnidadLexica unidadNew() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.NEW, "new");
	}

	public UnidadLexica unidadIntT() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.INT, "int");
	}

	public void error() {
		System.err.println("***" + aLexi.fila() + " Caracter inexperado: " + aLexi.lexema());
	}

	public UnidadLexica unidadPorcentaje() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PORC, "%");
	}

	public UnidadLexica unidadPunto() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PNTO, ".");
		}

	public UnidadLexica unidadPuntoComa() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.PTOCOMA, ";");
	}

	public UnidadLexica unidadCorcheteApertura() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.CORAP, "[");
	}

	public UnidadLexica unidadCorcheteCierre() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.CORCIE, "[");
	}

	public UnidadLexica unidadLlaveApertura() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.LLAP, "{");
	}

	public UnidadLexica unidadLlaveCierre() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.LLCIE, "}");
	}

	public UnidadLexica unidadFlecha() {
		return new UnidadLexica(aLexi.fila(), aLexi.columna(), ClaseLexica.FLECHA, "->");
	}

}
