package descendente;
import java.io.FileReader;
public class Main{
   public static void main(String[] args) throws Exception {
      AnalizadorSintacticoTiny1 asint = new AnalizadorSintacticoTiny1(new FileReader(args[0]));
	  try{
		  asint.ProgramaPrev();
		  System.out.println("OK");
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
   }
}