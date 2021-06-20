package conCup.errors;

import conCup.alex.UnidadLexica;

public class GestionErroresCUP {
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR fila "+fila+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
	   System.out.print("ERROR fila "+unidadLexica.lexema().fila()+","+unidadLexica.lexema().col()+
               ": Elemento inexperado "+unidadLexica.value);
     System.exit(1);
   }
}
