package procesamiento;

import procesamiento.TinyASint.*;
public interface Procesamiento {

	//void procesa (Programa prog);
	void procesa (Declaracion_una dec);
	void procesa (Declaracion_varias decs);
	//void procesa (Dec d);
	void procesa (Instruccion_una ins);
	void procesa (Instruccion_varias inss);
	//void procesa (Inst ins);
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
	void procesa(NEntero exp);
	void procesa(NReal exp);
	void procesa(Neg neg);
	void procesa(Cierto t);
	void procesa(Falso f);
	void procesa(Exp e);
	void procesa(Tipo t);
	
	void procesa(Programa_sinDecs prog);
	void procesa(Programa_conDecs prog);
	void procesa(Dec_habitual dec);
	void procesa(Dec_bloque dec);
	void procesa(Dec_proc dec);
	void procesa(Param_form p);
	void procesa(Param_form_nada p);
	void procesa(Param_form_uno p);
	void procesa(ParamD p);
	void procesa(LParamForm_varias p);
	void procesa(LParamForm_una p);
	void procesa(Bloque b);
	
	void procesa(TArray arr);
	void procesa(TRecord_varias recs);
	void procesa(TRecord_una rec);
	void procesa(Campos_uno c);
	void procesa(Campos_varios c);
	void procesa(Campo c);
	void procesa(TPointer p);
	
	void procesa(InstrOp_una instOp_una);
	void procesa(InstrOp_varias instOp_varias);
	void procesa(ParReales_una parReales_una);
	void procesa(ParReales_varias parReales_varias);
	void procesa(ParReales_ninguna parReales_ninguna);
	void procesa(LExpresiones_una lExpresiones_una);
	void procesa(LExpresiones_varias lExpresiones_varias);
	
	void procesa(Flecha fl);
	void procesa(Indir fl);
	void procesa(Punto fl);
	void procesa(Indice fl);
	void procesa(LiteralCad lc);
	
	void procesa(Instruccion_asig in);
	void procesa(Instruccion_if in);
	void procesa(Instruccion_if_nada in);
	void procesa(Instruccion_ifelse in);
	void procesa(Instruccion_ifelse_nada in);
	void procesa(Instruccion_ifelse_no1 in);
	void procesa(Instruccion_ifelse_no2 in);
	void procesa(Instruccion_bloque in);


	void procesa(Instruccion_while in);
	void procesa(Instruccion_read in);
	void procesa(Instruccion_write in);
	void procesa(Instruccion_nl in);
	void procesa(Instruccion_new in);
	void procesa(Instruccion_delete in);
	void procesa(Instruccion_call in);
	
	void procesa(Dec_type d);
	void procesa(ParamDAmp p);
}
