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
	public void procesa (Tipo t) {}
	
	public void procesa(Programa_sinDecs prog) {}
	public void procesa(Programa_conDecs prog) {}
	public void procesa(Dec_habitual dec) {}
	public void procesa(Dec_bloque dec){}
	public void procesa(Dec_proc dec){}
	public void procesa(Param_form p){}
	public void procesa(Param_form_nada p){}
	public void procesa(Param_form_uno p){}
	public void procesa(ParamD p){}
	public void procesa(LParamForm_varias p){}
	public void procesa(LParamForm_una p){}
	public void procesa(Bloque b){}
	
	public void procesa(TArray arr){}
	public void procesa(TRecord_varias recs){}
	public void procesa(TRecord_una rec){}
	public void procesa(Campos_uno c){}
	public void procesa(Campos_varios c){}
	public void procesa(Campo c){}
	public void procesa(TPointer p){}
	
	public void procesa(InstrOp_una instOp_una){}
	public void procesa(InstrOp_varias instOp_varias){}
	public void procesa(ParReales_una parReales_una){}
	public void procesa(ParReales_varias parReales_varias){}
	public void procesa(ParReales_ninguna parReales_ninguna){}
	public void procesa(LExpresiones_una lExpresiones_una){}
	public void procesa(LExpresiones_varias lExpresiones_varias){}
	
	public void procesa(Flecha fl){}
	public void procesa(Indir fl){}
	public void procesa(Punto fl){}
	public void procesa(Indice fl){}
	public void procesa(LiteralCad lc){}
	
	public void procesa(Instruccion_asig in){}
	public void procesa(Instruccion_if in){}
	public void procesa(Instruccion_if_nada in){}
	public void procesa(Instruccion_ifelse in){}
	public void procesa(Instruccion_ifelse_nada in){}
	public void procesa(Instruccion_ifelse_no1 in){}
	public void procesa(Instruccion_ifelse_no2 in){}
	public void procesa(Instruccion_bloque in){}


	public void procesa(Instruccion_while in) {}
	public void procesa(Instruccion_read in) {}
	public void procesa(Instruccion_write in) {}
	public void procesa(Instruccion_nl in) {}
	public void procesa(Instruccion_new in) {}
	public void procesa(Instruccion_delete in) {}
	public void procesa(Instruccion_call in) {}
}
