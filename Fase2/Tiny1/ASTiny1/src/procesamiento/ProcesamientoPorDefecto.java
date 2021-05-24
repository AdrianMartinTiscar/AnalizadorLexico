package procesamiento;

import procesamiento.TinyASint.*;

public class ProcesamientoPorDefecto implements Procesamiento{
	//public void procesa (Programa prog) {}
	public void procesa (Declaracion_una dec){}
	public void procesa (Declaracion_varias decs){}
	public void procesa (Dec d){}
	public void procesa (Instruccion_una ins){}
	public void procesa (Instruccion_varias inss){}
	public void procesa (Inst ins) {}
	public void procesa(Suma exp){}
	public void procesa(Resta exp){}
	public void procesa(Mul exp){}
	public void procesa(And an){}
	public void procesa(Or or){}
	public void procesa(Mayor may){}
	public void procesa(Menor men){}
	public void procesa(Mayor_igual mayI){}
	public void procesa(Menor_igual menI){}
	public void procesa(Equivalente eq){}
	public void procesa(Distinto dist){}
	public void procesa(Not not){}
	public void procesa(Div exp){}
	public void procesa(Id exp){}
	public void procesa(Num exp){}
	public void procesa(Neg neg){}
	public void procesa(Cierto t){}
	public void procesa(Falso f){}
	public void procesa(Exp e) {}
	//public void procesa (Tipo t) {}
	
	public void procesa(Programa_sinDecs prog) {}
	public void procesa(Programa_conDecs prog) {}
}
