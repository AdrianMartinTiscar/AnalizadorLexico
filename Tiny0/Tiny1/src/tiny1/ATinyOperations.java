package tiny1;

public class ATinyOperations {
	private AnalizadorLexicoTiny aLexi;
	  public ATinyOperations(AnalizadorLexicoTiny alex) {
	   this.aLexi = alex;   
	  }
	  public UnidadLexica unidadId() {
	     return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.ID,
	                                         aLexi.lexema()); 
	  } 
	  
	  public UnidadLexica unidadEntero() {
	     return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.NENTERO,aLexi.lexema()); 
	  } 
	  public UnidadLexica unidadReal() {
	     return new UnidadLexicaMultivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.NREAL,aLexi.lexema()); 
	  } 
	  public UnidadLexica unidadSuma() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.SUMA); 
	  } 
	  public UnidadLexica unidadResta() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.RESTA); 
	  } 
	  public UnidadLexica unidadMultiplicacion() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.MUL); 
	  } 
	  public UnidadLexica unidadDivision() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.DIV); 
	  } 
	  public UnidadLexica unidadParentesisApertura() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.PAP); 
	  } 
	  public UnidadLexica unidadParentesisCierre() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.PCIE); 
	  } 
	  public UnidadLexica unidadIgual() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.IGUAL); 
	  }
	  public UnidadLexica unidadDistinto() {
		 return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.DIST); 
	  } 
	  public UnidadLexica unidadComa() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.COMA); 
	  } 
	  public UnidadLexica unidadEof() {
	     return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.EOF); 
	  }
	  public UnidadLexica unidadAmpersand() {
		 return new UnidadLexicaUnivaluada(aLexi.fila(), aLexi.columna(),ClaseLexica.AMP); 
	 }
	  public void error() {
	    System.err.println("***"+aLexi.fila()+" Caracter inexperado: "+aLexi.lexema());
	  }
	
	
}
