package procesamiento;

import procesamiento.TinyASint.*;
public interface Procesamiento {

	void procesa (Programa prog);
	void procesa (Declaracion_una dec);
	void procesa (Declaracion_varias decs);
	void procesa (Dec d);
	void procesa (Instruccion_una ins);
	void procesa (Instruccion_varias inss);
	void procesa (Inst ins);
	void procesa(Suma exp);
	void procesa(Resta exp);
	void procesa(Mul exp);
	void procesa(And an);
	void procesa(Or or);
	void procesa(Mayor may);
	void procesa(Menor men);
	void procesa(Mayor_igual mayI);
	void procesa(Menor_igual menI);
	void procesa(Equivalente eq);
	void procesa(Distinto dist);
	void procesa(Not not);
	void procesa(Div exp);
	void procesa(Id exp);
	void procesa(Num exp);
	void procesa(Neg neg);
	void procesa(Cierto t);
	void procesa(Falso f);
	void procesa(Exp e);
	
}
