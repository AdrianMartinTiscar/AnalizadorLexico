package conCup.alex;
import conCup.asint.ClaseLexica;
import java_cup.runtime.Symbol;
import procesamiento.TinyASint.StringLocalizado;

public class UnidadLexica extends Symbol{
	public UnidadLexica(int fila, int col, int clase, String lexema) {
	     super(clase,null);
	     value = new StringLocalizado(lexema,fila,col);
	   }
  public int clase () {return sym;}
  public StringLocalizado lexema() {return (StringLocalizado)value;}
  public String toString() {
      StringLocalizado lexema = (StringLocalizado)value;
      return "[clase="+clase2string(sym)+",lexema="+lexema+",fila="+lexema.fila()+",col="+lexema.col()+"]";
  }
  private String clase2string(int clase) {
      switch(clase) {
      case ClaseLexica.SEPARACION: return "NENTERO";
      case ClaseLexica.LITCAD: return "LITCAD";
      case ClaseLexica.LLCIE: return "LLCIE";
      case ClaseLexica.RESTA: return "RESTA";
      case ClaseLexica.INT: return "INT";
      case ClaseLexica.PORC: return "PORC";
      case ClaseLexica.DELETE: return "DELETE";
      case ClaseLexica.WRITE: return "WRITE";
      case ClaseLexica.CORCIE: return "CORCIE";
      case ClaseLexica.NOT: return "NOT";
      case ClaseLexica.AND: return "AND";
      case ClaseLexica.IGUAL: return "IGUAL";
      case ClaseLexica.NREAL: return "NREAL";
      case ClaseLexica.RECORD : return "RECORD";
      case ClaseLexica.LLAP: return "LLAP";
      case ClaseLexica.TYPE : return "TYPE";
      case ClaseLexica.OR : return "OR";
      case ClaseLexica.BOOL : return "BOOL";
      case ClaseLexica.NENTERO : return "NENTERO";
      case ClaseLexica.CALL : return "CALL";
      case ClaseLexica.DIV : return "DIV";
      case ClaseLexica.SUMA : return "SUMA";
      case ClaseLexica.IF : return "IF";
      case ClaseLexica.ID : return "ID";
      case ClaseLexica.ENDWHILE : return "ENDWHILE";
      case ClaseLexica.PTOCOMA : return "PTOCOMA";
      case ClaseLexica.OF : return "OF";
      case ClaseLexica.DIST : return "DIST";
      case ClaseLexica.EOF : return "EOF";
      case ClaseLexica.AMP : return "AMP";
      case ClaseLexica.PARRAY : return "PARRAY";
      case ClaseLexica.TRUE : return "TRUE";
      case ClaseLexica.PCIE : return "PCIE";
      case ClaseLexica.NEW : return "NEW";
      case ClaseLexica.error : return "error";
      case ClaseLexica.CORAP : return "CORAP";
      case ClaseLexica.COMA : return "COMA";
      case ClaseLexica.MUL : return "MUL";
      case ClaseLexica.PNTO : return "PNTO";
      case ClaseLexica.NULL: return "NULL";
      case ClaseLexica.REAL : return "REAL";
      case ClaseLexica.PAP : return "PAP";
      case ClaseLexica.FLECHA : return "FLECHA";
      case ClaseLexica.ENDIF : return "ENDIF";
      case ClaseLexica.ELSE : return "ELSE";
      case ClaseLexica.MEN : return "MEN";
      case ClaseLexica.NL : return "NL";
      case ClaseLexica.READ : return "READ";
      case ClaseLexica.WHILE : return "WHILE";
      case ClaseLexica.EQUIV : return "EQUIV";
      case ClaseLexica.THEN : return "THEN";
      case ClaseLexica.MENEQ : return "MENEQ";
      case ClaseLexica.PROC : return "PROC";
      case ClaseLexica.STRING : return "STRING";
      case ClaseLexica.POINTER : return "POINTER";
      case ClaseLexica.FALSE : return "FALSE";
      case ClaseLexica.MAYEQ : return "MAYEQ";
      case ClaseLexica.MAY : return "MAY";
      case ClaseLexica.VAR : return "VAR";
      case ClaseLexica.DO : return "DO";
      default: return "?";
      
      }
   }
	}
