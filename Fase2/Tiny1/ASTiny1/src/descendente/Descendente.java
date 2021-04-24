package descendente;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Descendente{
	private String fich;
   public Descendente(String fich){
	   this.fich = fich;
   }
   
   public void init() throws FileNotFoundException {
	   AnalizadorSintacticoTiny1 asint = new AnalizadorSintacticoTiny1(new FileReader(fich));
	   try{
		   asint.ProgramaPrev();
		   System.out.println("OK");
	   }
	   catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	   
   }
}