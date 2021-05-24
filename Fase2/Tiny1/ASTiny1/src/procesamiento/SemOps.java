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
	    case "->": return flecha(arg0, arg1);
	    //case "." return punto(arg0, arg1);
		}
		throw new UnsupportedOperationException("exp "+op);
	}
	

	public Prog prog(Decs ds, Insts ins) {
		if (ds == null)
				return programa_sinDecs(ins);
		else
			return programa_conDecs(ds, ins);
	}
}
