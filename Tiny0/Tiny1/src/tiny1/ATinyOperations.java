package tiny1;

public class ATinyOperations {
	private AnalizadorLexicoTiny aLexi;

	public ATinyOperations(AnalizadorLexicoTiny alex) {
		this.aLexi = alex;
	}

	public UnidadLexica unidadEntero() {
		return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.NENTERO, aLexi.lexema());
	}

	public UnidadLexica unidadReal() {
		return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.NREAL, aLexi.lexema());
	}

	public UnidadLexica unidadSuma() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.SUMA);
	}

	public UnidadLexica unidadResta() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.RESTA);
	}

	public UnidadLexica unidadMultiplicacion() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.MUL);
	}

	public UnidadLexica unidadDivision() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.DIV);
	}

	public UnidadLexica unidadParentesisApertura() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.PAP);
	}

	public UnidadLexica unidadParentesisCierre() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.PCIE);
	}

	public UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.IGUAL);
	}

	public UnidadLexica unidadDistinto() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.DIST);
	}

	public UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.MEN);
	}

	public UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.MAY);
	}

	public UnidadLexica unidadComa() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.COMA);
	}

	public UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.EOF);
	}

	public UnidadLexica unidadAmpersand() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.AMP);
	}

	public UnidadLexica unidadIdentificador() {
		return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.ID, aLexi.lexema());
	}
	public UnidadLexica unidadSeparacion() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.SEPARACION);
	}
	public UnidadLexica unidadMenorIgual() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.MENEQ);
	}
	public UnidadLexica unidadMayorIgual() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.MAYEQ);
	}
	public UnidadLexica unidadEquivalente() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.EQUIV);
	}
	public UnidadLexica unidadDo() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.DO);
	}
	public UnidadLexica unidadIf() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.IF);
	}
	public UnidadLexica unidadNl() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.NL);
	}
	public UnidadLexica unidadOf() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.OF);
	}
	public UnidadLexica unidadOr() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.OR);
	}
	public UnidadLexica unidadAnd() {
		return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.AND);
	}
	public UnidadLexica unidadLiteralCadena() {
		return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(), ClaseLexica.LITCAT, aLexi.lexema());
	}
	public UnidadLexica unidadRecord() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.RECORD); 
	  }
	  public UnidadLexica unidadStringT() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.STRING); 
	  }
	  public UnidadLexica unidadPointer() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.POINTER); 
	  }
	  
	  public UnidadLexica unidadEndwhile() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.ENDWHILE); 
	  }
	
	  public UnidadLexica unidadDelete() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.DELETE); 
	  }
	  public UnidadLexica unidadWrite() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.WRITE); 
	  }
	  
	  public UnidadLexica unidadWhile() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.WHILE); 
	  }
	  
	  public UnidadLexica unidadFalse() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.FALSE); 
	  }
	  public UnidadLexica unidadEndif() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.ENDIF); 
	  }
	  public UnidadLexica unidadArray() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.ARRAY); 
	  }
	  public UnidadLexica unidadType() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.TYPE); 
	  }
	    public UnidadLexica unidadTrue() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.TRUE); 
	  }
	      public UnidadLexica unidadThen() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.THEN); 
	  }
	  
	      public UnidadLexica unidadRealT() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.REAL); 
	  }
	      public UnidadLexica unidadRead() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.READ); 
	  }
	      public UnidadLexica unidadProc() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.PROC); 
	  }
	      public UnidadLexica unidadNull() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.NULL); 
	  }
	      public UnidadLexica unidadElse() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.ELSE); 
	  }
	      public UnidadLexica unidadCall() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.CALL); 
	  }
	      public UnidadLexica unidadBoolT() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.BOOL); 
	  }
	      public UnidadLexica unidadVar() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.VAR); 
	  }
	      public UnidadLexica unidadNot() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.NOT); 
	  }
	      public UnidadLexica unidadNew() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.NEW); 
	  }
	      public UnidadLexica unidadIntT() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.INT); 
	  }
	public void error() {
		System.err.println("***" + aLexi.fila() + " Caracter inexperado: " + aLexi.lexema());
	}



	

	

}
