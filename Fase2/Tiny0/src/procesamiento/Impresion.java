package procesamiento;

import procesamiento.TinyASint.*;
import procesamiento.ProcesamientoPorDefecto;

public class Impresion extends ProcesamientoPorDefecto {
	public Impresion() {
	}

	public void procesa(Programa prog) {
		prog.decs().procesa(this);
		System.out.println("&&");
		prog.ins().procesa(this);
	}

	public void procesa(Declaracion_una dec) {
		dec.dec().procesa(this);
	}

	public void procesa(Declaracion_varias decs) {
		decs.dec().procesa(this);
		decs.decs().procesa(this);
	}

	public void procesa(Dec d) {
		System.out.println(d.tipo() + "  " + d.id());
	}

	public void procesa(Instruccion_una ins) {
		ins.ins().procesa(this);
	}

	public void procesa(Instruccion_varias inss) {
		inss.ins().procesa(this);
		inss.inss().procesa(this);
	}

	public void procesa(Inst ins) {
		System.out.print(ins.id() + " = ");
		ins.val().procesa(this);
		System.out.println("");
	}

	public void procesa(Suma exp) {
	     imprime_arg(exp.arg0(),1); 
	     System.out.print(" + ");
	     imprime_arg(exp.arg1(),0); 
	}

	public void procesa(Resta exp) {
	      imprime_arg(exp.arg0(),1); 
	      System.out.print(" - ");
	      imprime_arg(exp.arg1(),1); 
	}

	public void procesa(Mul exp) {
	      imprime_arg(exp.arg0(),4); 
	      System.out.print(" * ");
	      imprime_arg(exp.arg1(),4);
	}

	public void procesa(And an) {
	      imprime_arg(an.arg0(),1); 
	      System.out.print(" and ");
	      imprime_arg(an.arg1(),2);
	}

	public void procesa(Or or) {
	      imprime_arg(or.arg0(),1); 
	      System.out.print(" or ");
	      imprime_arg(or.arg1(),2);
	}

	public void procesa(Mayor may) {
	      imprime_arg(may.arg0(),2); 
	      System.out.print(" > ");
	      imprime_arg(may.arg1(),3);
	}

	public void procesa(Menor men) {
	      imprime_arg(men.arg0(),2); 
	      System.out.print(" < ");
	      imprime_arg(men.arg1(),3);
	}

	public void procesa(Mayor_igual mayI) {
	      imprime_arg(mayI.arg0(),2); 
	      System.out.print(" >= ");
	      imprime_arg(mayI.arg1(),3);
	}

	public void procesa(Menor_igual menI) {
	      imprime_arg(menI.arg0(),2); 
	      System.out.print(" <= ");
	      imprime_arg(menI.arg1(),3);
	}

	public void procesa(Equivalente eq) {
	      imprime_arg(eq.arg0(),2); 
	      System.out.print(" == ");
	      imprime_arg(eq.arg1(),3);
	}

	public void procesa(Distinto dist) {
	      imprime_arg(dist.arg0(),2); 
	      System.out.print(" != ");
	      imprime_arg(dist.arg1(),3);
	}

	public void procesa(Not not) {
	      System.out.print(" not ");
	      imprime_arg(not.arg0(),5);
	}

	public void procesa(Div exp) {
	      imprime_arg(exp.arg0(),4); 
	      System.out.print(" / ");
	      imprime_arg(exp.arg1(),4);
	}

	public void procesa(Id exp) {
		System.out.print(exp.id());
	}

	public void procesa(Num exp) {
		System.out.print(exp.num());
	}

	public void procesa(Neg neg) {
	      System.out.print(" -");
	      imprime_arg(neg.arg0(),5);
	}

	public void procesa(Cierto t) {
		System.out.print(" true ");
	}

	public void procesa(Falso f) {
		System.out.print(" false ");
	}

	public void procesa(Exp e) {
		e.procesa(this);
	}

	private void imprime_arg(Exp arg, int p) {
		if (arg.prioridad() < p) {
			System.out.print("(");
			arg.procesa(this);
			System.out.print(")");
		} else {
			arg.procesa(this);
		}
	}

}
