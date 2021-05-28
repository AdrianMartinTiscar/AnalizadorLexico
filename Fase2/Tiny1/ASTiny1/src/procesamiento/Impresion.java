package procesamiento;

import procesamiento.TinyASint.*;
import procesamiento.ProcesamientoPorDefecto;

public class Impresion extends ProcesamientoPorDefecto {
	public Impresion() {
	}
	
	public void procesa(Programa_sinDecs prog) {
		prog.ins().procesa(this);
	}
	public void procesa(Programa_conDecs prog) {
		prog.decs().procesa(this);
		System.out.println("\n&&");
		prog.ins().procesa(this);
	}
	
	public void procesa(Declaracion_una dec) {
		dec.dec().procesa(this);
	}

	public void procesa(Declaracion_varias decs) {
		decs.dec().procesa(this);
		System.out.println(";");
		decs.decs().procesa(this);
	}


	public void procesa(Instruccion_una ins) {
		ins.ins().procesa(this);
	}

	public void procesa(Instruccion_varias inss) {
		inss.ins().procesa(this);
		System.out.println(";");
		inss.inss().procesa(this);
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
	
	public void procesa(Mod exp) {
		  imprime_arg(exp.arg0(),4); 
	      System.out.print(" % ");
	      imprime_arg(exp.arg1(),4);
	}

	public void procesa(Id exp) {
		System.out.print(exp.id().toString());
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
	
	public void procesa(Dec_habitual dec) {
		System.out.print("var ");
		System.out.print(dec.tipo().getTipo());
		dec.tipo().procesa(this);
		System.out.print(" " +dec.id());
	}
	public void procesa(Dec_type d) {
		System.out.print("type ");
		System.out.print(d.tipo().getTipo()+ " ");
		System.out.print(d.id().getTipo());
		
	}
	public void procesa(Dec_bloque dec){
		System.out.print("type ");
		dec.tipo().procesa(this);
		System.out.print(dec.id());
	}
	public void procesa(Dec_proc dec){
		System.out.print("proc ");
		System.out.print(dec.id());
		dec.parF().procesa(this);
		dec.block().procesa(this);
	}
	public void procesa(Param_form p){
		System.out.print("(");
		p.par().procesa(this);
		p.lpar().procesa(this);
		System.out.print(")");
	}
	public void procesa(Param_form_nada p){
		System.out.print("(");
		System.out.print(")");
	}
	public void procesa(Param_form_uno p){
		System.out.print("(");
		p.par().procesa(this);
		System.out.print(")");
	}
	public void procesa(ParamD p){
		p.tipo().procesa(this);
		System.out.print(p.id());
	}
	public void procesa(ParamDAmp p) {
		p.tipo().procesa(this);
		System.out.print( "&" + p.id());
	}
	public void procesa(LParamForm_varias p){
		System.out.print(", ");
		p.par().procesa(this);
		p.lpar().procesa(this);
	}
	public void procesa(LParamForm_una p){
		p.par().procesa(this);
	}
	public void procesa(Bloque b){
		System.out.println("{");
		b.cont().procesa(this);
		System.out.print("}");
	}
	
	public void procesa(TArray arr){
		System.out.print(" tArray ");
		System.out.print(" [ ");
		arr.tam().procesa(this);
		System.out.print(" ] of ");
		System.out.print(arr.of().getTipo());
	}
	public void procesa(TRecord_varias recs){
		System.out.println(" tRecord {");
		recs.campo().procesa(this);
		recs.campos().procesa(this);
		System.out.print("}");
	}
	public void procesa(TRecord_una rec){
		System.out.print("tRecord {");
		rec.campo().procesa(this);
		System.out.print("}");
	}
	public void procesa(Campos_uno c){
		c.campo().procesa(this);
	}
	public void procesa(Campos_varios c){
		c.campo().procesa(this);
		System.out.print("; ");
		c.campos().procesa(this);
	}
	public void procesa(Campo c){
		c.tipo().procesa(this);
	}
	public void procesa(TPointer p){
		System.out.print(" tPointer ");
		p.tipo().procesa(this);
	}
	
	public void procesa(InstrOp_una instOp_una){
		instOp_una.instrOp().procesa(this);
	}
	public void procesa(InstrOp_varias instOp_varias){
		instOp_varias.instrOps().procesa(this);
	}
	public void procesa(ParReales_una parReales_una){
		System.out.print("(");
		parReales_una.exp().procesa(this);
		System.out.print(")");
	}
	public void procesa(ParReales_varias parReales_varias){
		System.out.print("(");
		parReales_varias.exp().procesa(this);
		parReales_varias.lexps().procesa(this);		
		System.out.print(")");
	}
	public void procesa(ParReales_ninguna parReales_ninguna){
		System.out.print("(");
		System.out.print(")");
	}
	public void procesa(LExpresiones_una lExpresiones_una){
		System.out.print(", ");
		lExpresiones_una.exp().procesa(this);
	}
	public void procesa(LExpresiones_varias lExpresiones_varias){
		System.out.print(", ");
		lExpresiones_varias.exp().procesa(this);
		lExpresiones_varias.lExpresiones().procesa(this);
	}
	
	public void procesa(Flecha fl){
		fl.arg0().procesa(this);
		System.out.print("->");
		System.out.print(fl.arg1().toString());
	}
	public void procesa(Indir fl){
		System.out.print("*");
		fl.arg0().procesa(this);
	}
	public void procesa(Punto fl){
		fl.arg0().procesa(this);
		System.out.print(".");
		System.out.print(fl.arg1().toString());
	}
	public void procesa(Indice fl){
		fl.arg0().procesa(this);
		System.out.print("[");
		fl.arg1().procesa(this);
		System.out.print("]");
	}
	public void procesa(LiteralCad lc){
		System.out.print("\"");
		System.out.print(lc.cad());
		System.out.print("\"");
	}
	
	public void procesa(Instruccion_asig in){
		in.id().procesa(this);
		System.out.print(" = ");
		in.val().procesa(this);		
	}
	
	public void procesa(Instruccion_if in){
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");
		in.op().procesa(this);
		System.out.print(" endif");
	}
	
	public void procesa(Instruccion_if_nada in){//?????????????????????????????????????????
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");
		System.out.print(" endif");		
	}
	
	public void procesa(Instruccion_ifelse in){
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");
		in.op1().procesa(this);
		System.out.print(" else ");
		in.op2().procesa(this);
		System.out.print(" endif");
	}
	
	public void procesa(Instruccion_ifelse_nada in){//¿¿¿¿?????
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");
		System.out.print(" else ");
		System.out.print(" endif");
	}
	
	public void procesa(Instruccion_ifelse_no1 in){
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");
		System.out.print(" else ");
		in.op().procesa(this);
		System.out.print(" endif");
	}
	
	public void procesa(Instruccion_ifelse_no2 in){
		System.out.print("if ");
		in.val().procesa(this);
		System.out.print(" then ");		
		in.op().procesa(this);
		System.out.print(" else ");
		System.out.print(" endif");
	}
	
	public void procesa(Instruccion_bloque in){
		System.out.print("{ ");
		in.blo().procesa(this);
		System.out.print(" }");
	}

	public void procesa(Instruccion_while in) {
		System.out.print("while ");
		in.val().procesa(this);
		System.out.print(" do ");	
		in.op().procesa(this);	
		System.out.print(" endwhile ");
	}
	
	public void procesa(Instruccion_read in) {
		System.out.print("read ");
		in.val().procesa(this);
	}
	
	public void procesa(Instruccion_write in) {
		System.out.print("write ");
		in.val().procesa(this);
	}
	
	public void procesa(Instruccion_nl in) {
		System.out.print("nl");
	}
	
	public void procesa(Instruccion_new in) {
		System.out.print("new ");
		in.val().procesa(this);
	}
	
	public void procesa(Instruccion_delete in) {
		System.out.print("delete ");
		in.val().procesa(this);
	}
	
	public void procesa(Instruccion_call in) {
		System.out.print("call ");
		System.out.print(in.str());
		in.parReales().procesa(this);
	}
	
	public void procesa(NEntero exp){
		System.out.print(exp.num().toString());
	}
	public void procesa(NReal exp){
		System.out.print(exp.num().toString());
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
