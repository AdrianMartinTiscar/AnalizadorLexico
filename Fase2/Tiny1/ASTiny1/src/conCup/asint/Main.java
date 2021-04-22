package conCup.asint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import conCup.alex.AnalizadorLexicoTiny;

import conCup.alex.UnidadLexica;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
       try{
    	   do {
    	   unidad = al.next_token();
    	   }
    	   while (unidad.clase() != ClaseLexica.EOF);
       }
       catch(Exception e) {
    	   System.out.println(e.getMessage());
       }
    }        
} 
