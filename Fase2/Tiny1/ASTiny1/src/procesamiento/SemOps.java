package procesamiento;

public class SemOps extends TinyASint{
	public Exp exp(String op, Exp arg0, Exp arg1) {
		switch(op) {
	    case "and": return and(arg0, arg1);
	    case "or": return or(arg0, arg1);
	    case "<" : return menor(arg0, arg1);
	    case ">": return mayor(arg0, arg1);
	    case "<=": return menor_igual(arg0, arg1);
	    case ">=": return mayor_igual(arg0, arg1);
	    case "==": return equivalente(arg0, arg1);
	    case "!=": return distinto(arg0, arg1);
	    case "*": return mul(arg0, arg1);
	    case "/": return div(arg0, arg1);
	    case "%": return mod(arg0,arg1);
		}
		throw new UnsupportedOperationException("exp "+op);
	}
	
	public Exp exp (String op, Exp arg0, StringLocalizado arg1) {
		switch(op) {
		case "->": return flecha(arg0, arg1);
	    case ".": return punto(arg0, arg1);
		}
		throw new UnsupportedOperationException("exp "+op);
	}
	

	public Prog prog(Decs ds, Insts ins) {
		if (ds == null)
				return programa_sinDecs(ins);
		else
			return programa_conDecs(ds, ins);
	}
	
	public ParamForm param_formAux(ParamD param, LParamForm params){
	    if (param == null) {
	        return param_form_nada();
	    }
	    else if (params == null) {
	    	return param_form_uno(param);
	    }
	    else {
	    	return param_form(param, params);
	    }
	}

	public LParamForm lparamFormAux(ParamD param, LParamForm params){
	    if (params == null)
	        return lparamForm_una(param);
	    else
	        return lparamForm_varias(param, params);
	}
	
	public TRecord trecordAux(Campo campo, Campos campos){
	    if (campos==null)
	        return tRecord_una(campo);
	    else
	        return tRecord_varias(campo, campos);
	}
	public Campos campos(Campo c, Campos cs){
	    if (cs ==null)
	        return campos_uno(c);
	    else
	        return campos_varios(c,cs);
	}
	
	public Inst instruccion_ifAux(Exp expr, InstrOp in){
	    if (in ==null)
	        return instruccion_if_nada(expr);
	    else
	        return instruccion_if(expr, in);
	}

	public Inst instruccion_ifelseAux(Exp e, InstrOp i1, InstrOp i2){
	    if (i1 == null && i2 == null)
	        return instruccion_ifelse_nada(e);
	    else if (i1== null)
	        return instruccion_ifelse_no1(e, i2);
	    else if (i2== null)
	        return instruccion_ifelse_no2(e, i1);
	    else
	        return instruccion_ifelse(e, i1, i2);
	}

	public InstrOp instrOpAux (Inst i, Insts is){
	    if (is==null)
	        return instrOp_una(i);
	    else
	        return instrOp_varias(is);
	}

	public ParReales parRealesAux(Exp e, LExpresiones es){
	    if (e == null)
	        return parReales_ninguna();
	    else if (es == null)
	        return parReales_una(e);
	    else
	        return parReales_varias(e, es);
	    
	}

	public LExpresiones lExpresionesAux(Exp e, LExpresiones es){
	    if (es==null)
	        return lExpresiones_una(e);
	    else
	        return lExpresiones_varias(e, es);
	}
}
