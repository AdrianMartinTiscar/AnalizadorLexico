package procesamiento;
import procesamiento.TinyASint.*;
import procesamiento.ProcesamientoPorDefecto;
public class Impresion extends ProcesamientoPorDefecto{
	public Impresion() {
	}
	
	public void procesa (Programa prog) {
		prog.decs().procesa((Procesamiento) this);
		prog.ins().procesa((Procesamiento) this);
	}
	public void procesa (Declaracion_una dec){
		dec.dec().procesa((Procesamiento)this);
	}
	public void procesa (Declaracion_varias decs){
		decs.dec().procesa((Procesamiento)this);
		System.out.println(",\n");
		decs.decs().procesa((Procesamiento)this);
	}
	public void procesa (Dec d){
		System.out.println(d.id() + " = "+d.val());
	}
	public void procesa (Instruccion_una ins){
		ins.ins().procesa((Procesamiento)this);
	}
	public void procesa (Instruccion_varias inss){
		inss.ins().procesa((Procesamiento)this);
		System.out.println(",\n");
		inss.inss().procesa((Procesamiento)this);
	}
	public void procesa (Inst ins) {
		System.out.println(ins.id() + " = " + ins.val());
	}
	public void procesa(Suma exp){
		System.out.println(exp.arg0() + " + " + exp.arg1());
	}
	public void procesa(Resta exp){
		System.out.println(exp.arg0() + " - " + exp.arg1());
	}
	public void procesa(Mul exp){
		System.out.println(exp.arg0() + " * " + exp.arg1());
	}
	public void procesa(And an){
		System.out.println(an.arg0() + " and " + an.arg1());
	}
	public void procesa(Or or){
		System.out.println(or.arg0() + " or " + or.arg1());
	}
	public void procesa(Mayor may){
		System.out.println(may.arg0() + " > " + may.arg1());
	}
	public void procesa(Menor men){
		System.out.println(men.arg0() + " < " + men.arg1());
	}
	public void procesa(Mayor_igual mayI){
		System.out.println(mayI.arg0() + " >= " + mayI.arg1());
	}
	public void procesa(Menor_igual menI){
		System.out.println(menI.arg0() + " <= " + menI.arg1());
	}
	public void procesa(Equivalente eq){
		System.out.println(eq.arg0() + " == " + eq.arg1());
		}
	public void procesa(Distinto dist){
		System.out.println(dist.arg0() + " != " + dist.arg1());
		}
	public void procesa(Not not){
		System.out.println("not " + not.arg0());
		}
	public void procesa(Div exp){
		System.out.println(exp.arg0() + " / " + exp.arg1());
		}
	public void procesa(Id exp){
		System.out.println(exp.id());
		}
	public void procesa(Num exp){
		System.out.println(exp.num());
		}
	public void procesa(Neg neg){
		System.out.println("-" + neg.arg0());
		}
	public void procesa(Cierto t){
		System.out.println("true");
		}
	public void procesa(Falso f){
		System.out.println("false");
		}
	public void procesa(Exp e) {
		System.out.println("\n\n\n");
		}
	
}
