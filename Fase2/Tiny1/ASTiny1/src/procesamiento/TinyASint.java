package procesamiento;

public class TinyASint {
	public static abstract class Exp {
		public Exp() {
		}

		public abstract int prioridad();

		public abstract void procesa(Procesamiento procesamiento);
	}

	public static class StringLocalizado {
		private String s;
		private int fila;
		private int col;

		public StringLocalizado(String s, int fila, int col) {
			this.s = s;
			this.fila = fila;
			this.col = col;
		}

		public int fila() {
			return fila;
		}

		public int col() {
			return col;
		}

		public String toString() {
			return s;
		}

		public boolean equals(Object o) {
			return (o == this) || ((o instanceof StringLocalizado) && (((StringLocalizado) o).s.equals(s)));
		}

		public int hashCode() {
			return s.hashCode();
		}
	}

	private static abstract class ExpBin extends Exp {
		private Exp arg0;
		private Exp arg1;

		public Exp arg0() {
			return arg0;
		}

		public Exp arg1() {
			return arg1;
		}

		public ExpBin(Exp arg0, Exp arg1) {
			super();
			this.arg0 = arg0;
			this.arg1 = arg1;
		}
	}

	private static abstract class ExpAditiva extends ExpBin {
		public ExpAditiva(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 0;
		}
	}

	public static class Suma extends ExpAditiva {
		public Suma(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Resta extends ExpAditiva {
		public Resta(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpAndOr extends ExpBin {
		public ExpAndOr(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 1;
		}
	}

	public static class And extends ExpAndOr {
		public And(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Or extends ExpAndOr {
		public Or(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpRelacionales extends ExpBin {
		public ExpRelacionales(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 2;
		}
	}

	public static class Menor extends ExpRelacionales {
		public Menor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mayor extends ExpRelacionales {
		public Mayor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Menor_igual extends ExpRelacionales {
		public Menor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mayor_igual extends ExpRelacionales {
		public Mayor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Equivalente extends ExpRelacionales {
		public Equivalente(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Distinto extends ExpRelacionales {
		public Distinto(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpMultiplicativa extends ExpBin {
		public ExpMultiplicativa(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 3;
		}
	}

	public static class Mul extends ExpMultiplicativa {
		public Mul(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Div extends ExpMultiplicativa {
		public Div(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mod extends ExpMultiplicativa {
		public Mod(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpDir extends Exp {
		private Exp ar0;
		public ExpDir(Exp arg0) {
			super();
			this.ar0 = arg0;
		}
		public Exp arg0() {
			return ar0;
		}
		public final int prioridad() {
			return 4;
		}
	}

	public static class Indice extends ExpDir {
		private Exp ar1;
		public Indice(Exp arg0, Exp arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public Exp arg1() {
			return ar1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Punto extends ExpDir {
		private StringLocalizado ar1;
		public Punto(Exp arg0, StringLocalizado arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public StringLocalizado arg1() {
			return ar1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Flecha extends ExpDir {
		private StringLocalizado ar1;
		public Flecha(Exp arg0, StringLocalizado arg1) {
			super(arg0);
			ar1 = arg1;
		}
		
		public StringLocalizado arg1() {
			return ar1;
		}
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Indir extends ExpDir {
		public Indir(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpUn extends Exp {
		private Exp arg;

		public Exp arg0() {
			return arg;
		}

		public ExpUn(Exp arg0) {
			super();
			this.arg = arg0;
		}

		public final int prioridad() {
			return 4;
		}
	}

	public static class Neg extends ExpUn {
		public Neg(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Not extends ExpUn {
		public Not(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Num extends Exp {
		private StringLocalizado num;

		public Num(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class NEntero extends Exp {
		private StringLocalizado num;

		public NEntero(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class NReal extends Exp {
		private StringLocalizado num;

		public NReal(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Id extends Exp {
		private StringLocalizado id;

		public Id(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Cierto extends Exp {
		private String cierto;

		public Cierto() {
			super();
			this.cierto = "True";
		}

		public String num() {
			return cierto;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Falso extends Exp {
		private String fals;

		public Falso() {
			super();
			this.fals = "False";
		}

		public String num() {
			return fals;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;
		}
	}

	public static class Nulo extends Exp {
		private String nul;

		public Nulo() {
			super();
			this.nul = "null";
		}

		public String num() {
			return nul;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 5;// PRIORIDAD 5????? O CUAL?
		}
	}

	public static abstract class Dec {
		public Dec() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Dec_habitual extends Dec {
		private Tipo tipo;
		private StringLocalizado id;

		public Dec_habitual(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}
	
	public static class Dec_type extends Dec {
		private Tipo tipo;
		private Tipo id;

		public Dec_type(Tipo tipo, Tipo id) {
			this.id = id;
			this.tipo = tipo;
		}

		public Tipo id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Dec_bloque extends Dec {
		private Tipo tipo;
		private StringLocalizado id;

		public Dec_bloque(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Dec_proc extends Dec {
		private StringLocalizado id;
		private ParamForm pf;
		private Bloque block;

		public Dec_proc(StringLocalizado id, ParamForm pf, Bloque block) {
			this.id = id;
			this.pf = pf;
			this.block = block;
		}

		public StringLocalizado id() {
			return id;
		}

		public ParamForm parF() {
			return pf;
		}

		public Bloque block() {
			return block;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class ParamForm {
		public ParamForm() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Param_form extends ParamForm {
		private ParamD par;
		private LParamForm pars;

		public Param_form(ParamD par, LParamForm pars) {
			this.par = par;
			this.pars = pars;
		}

		public ParamD par() {
			return par;
		}

		public LParamForm lpar() {
			return pars;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param_form_nada extends ParamForm {
		public Param_form_nada() {
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param_form_uno extends ParamForm {
		private ParamD par;

		public Param_form_uno(ParamD par) {
			this.par = par;
		}

		public ParamD par() {
			return par;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParamD {
		private Tipo t;
		private StringLocalizado i;

		public ParamD(Tipo t, StringLocalizado i) {
			this.t = t;
			this.i = i;
		}

		public StringLocalizado id() {
			return i;
		}

		public Tipo tipo() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LParamForm {
		public LParamForm() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LParamForm_varias extends LParamForm {
		private ParamD par;
		private LParamForm pars;

		public LParamForm_varias(ParamD par, LParamForm pars) {
			this.par = par;
			this.pars = pars;
		}

		public ParamD par() {
			return par;
		}

		public LParamForm lpar() {
			return pars;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LParamForm_una extends LParamForm {
		private ParamD par;

		public LParamForm_una(ParamD par) {
			this.par = par;
		}

		public ParamD par() {
			return par;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bloque {
		private Prog p;

		public Bloque(Prog p) {
			this.p = p;
		}

		public Prog cont() {
			return p;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TArray extends Tipo {
		private NEntero n;
		private Tipo t;

		public TArray(StringLocalizado n, Tipo t) {
			super("tArray");
			this.n = new NEntero(n);
			this.t = t;
		}

		public NEntero tam() {
			return n;
		}

		public Tipo of() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class TRecord extends Tipo {
		public TRecord() {
			super("tRecord");
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class TRecord_varias extends TRecord {
		private Campo c;
		private Campos cs;

		public TRecord_varias(Campo c, Campos cs) {
			super();
			this.c = c;
			this.cs = cs;
		}

		public Campo campo() {
			return c;
		}

		public Campos campos() {
			return cs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TRecord_una extends TRecord {
		private Campo c;

		public TRecord_una(Campo c) {
			super();
			this.c = c;
		}

		public Campo campo() {
			return c;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Campos {
		public Campos() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Campos_varios extends Campos {
		private Campo c;
		private Campos cs;

		public Campos_varios(Campo c, Campos cs) {
			super();
			this.c = c;
			this.cs = cs;
		}

		public Campo campo() {
			return c;
		}

		public Campos campos() {
			return cs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Campos_uno extends Campos {
		private Campo c;

		public Campos_uno(Campo c) {
			super();
			this.c = c;
		}

		public Campo campo() {
			return c;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Campo {
		private Tipo t;
		private StringLocalizado id;

		public Campo(Tipo t, StringLocalizado id) {
			super();
			this.t = t;
			this.id = id;
		}

		public Tipo tipo() {
			return t;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TPointer extends Tipo {
		private Tipo t;

		public TPointer(Tipo t) {
			super("tPointer");
			this.t = t;
		}

		public Tipo tipo() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Decs {
		public Decs() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Declaracion_una extends Decs {
		private Dec dec;

		public Declaracion_una(Dec dec) {
			super();
			this.dec = dec;
		}

		public Dec dec() {
			return dec;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Declaracion_varias extends Decs {
		private Dec dec;
		private Decs decs;

		public Declaracion_varias(Dec dec, Decs decs) {
			super();
			this.dec = dec;
			this.decs = decs;
		}

		public Dec dec() {
			return dec;
		}

		public Decs decs() {
			return decs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Inst {
		public Inst() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Instruccion_asig extends Inst {
		private Exp id;
		private Exp val;

		public Instruccion_asig(Exp id, Exp val) {
			this.id = id;
			this.val = val;
		}

		public Exp id() {
			return id;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_if extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_if(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_if_nada extends Inst {
		private Exp val;

		public Instruccion_if_nada(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse extends Inst {
		private Exp val;
		private InstrOp op1;
		private InstrOp op2;

		public Instruccion_ifelse(Exp val, InstrOp op1, InstrOp op2) {
			this.val = val;
			this.op1 = op1;
			this.op2 = op2;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op1() {
			return op1;
		}

		public InstrOp op2() {
			return op2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_nada extends Inst {
		private Exp val;

		public Instruccion_ifelse_nada(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_no1 extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_ifelse_no1(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_ifelse_no2 extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_ifelse_no2(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_bloque extends Inst {
		private Bloque blo;

		public Instruccion_bloque(Bloque blo) {
			this.blo = blo;
		}

		public Bloque blo() {
			return blo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_while extends Inst {
		private Exp val;
		private InstrOp op;

		public Instruccion_while(Exp val, InstrOp op) {
			this.val = val;
			this.op = op;
		}

		public Exp val() {
			return val;
		}

		public InstrOp op() {
			return op;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_read extends Inst {
		private Exp val;

		public Instruccion_read(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_write extends Inst {
		private Exp val;

		public Instruccion_write(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_nl extends Inst {

		public Instruccion_nl() {
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_new extends Inst {
		private Exp val;

		public Instruccion_new(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_delete extends Inst {
		private Exp val;

		public Instruccion_delete(Exp val) {
			this.val = val;
		}

		public Exp val() {
			return val;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_call extends Inst {
		private StringLocalizado str;// QUIZAS ES STRING A SECAS????
		private ParReales pReal;

		public Instruccion_call(StringLocalizado str, ParReales pReal) {
			this.str = str;
			this.pReal = pReal;
		}

		public StringLocalizado str() {
			return this.str;
		}

		public ParReales parReales() {
			return this.pReal;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class ParReales {
		public ParReales() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class ParReales_una extends ParReales {
		private Exp exp;

		public ParReales_una(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return this.exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParReales_varias extends ParReales {
		private Exp exp;
		private LExpresiones lexps;

		public ParReales_varias(Exp exp, LExpresiones lexps) {
			super();
			this.exp = exp;
			this.lexps = lexps;
		}

		public Exp exp() {
			return this.exp;
		}

		public LExpresiones lexps() {
			return this.lexps;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class ParReales_ninguna extends ParReales {

		public ParReales_ninguna() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LExpresiones {
		public LExpresiones() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LExpresiones_una extends LExpresiones {
		private Exp exp;

		public LExpresiones_una(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return this.exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LExpresiones_varias extends LExpresiones {
		private Exp exp;
		private LExpresiones lexp;

		public LExpresiones_varias(Exp exp, LExpresiones lexp) {
			super();
			this.exp = exp;
			this.lexp = lexp;
		}

		public Exp exp() {
			return this.exp;
		}

		public LExpresiones lExpresiones() {
			return this.lexp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class InstrOp {
		public InstrOp() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class InstrOp_una extends InstrOp {
		private Inst instr;

		public InstrOp_una(Inst ins) {
			super();
			this.instr = ins;
		}

		public Inst instrOp() {
			return this.instr;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class InstrOp_varias extends InstrOp {
		private Insts instrs;

		public InstrOp_varias(Insts insts) {
			super();
			this.instrs = insts;
		}


		public Insts instrOps() {
			return this.instrs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}


	public static abstract class Insts {
		public Insts() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Instruccion_una extends Insts {
		private Inst ins;

		public Instruccion_una(Inst ins) {
			super();
			this.ins = ins;
		}

		public Inst ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Instruccion_varias extends Insts {
		private Inst ins;
		private Insts inss;

		public Instruccion_varias(Insts inss, Inst ins) {
			super();
			this.ins = ins;
			this.inss = inss;
		}

		public Inst ins() {
			return ins;
		}

		public Insts inss() {
			return inss;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Prog {
		public Prog() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Programa_conDecs extends Prog {
		private Decs decs;
		private Insts ins;

		public Programa_conDecs(Decs decs, Insts ins) {
			super();
			this.decs = decs;
			this.ins = ins;
		}

		public Decs decs() {
			return decs;
		}

		public Insts ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Programa_sinDecs extends Prog {
		private Insts ins;

		public Programa_sinDecs(Insts ins) {
			super();
			this.ins = ins;
		}

		public Insts ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Tipo {
		private String tipo;

		public Tipo(String tipo) {
			this.tipo = tipo;
		}

		public String getTipo() {
			return this.tipo;
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Intt extends Tipo {
		public Intt() {
			super("Int");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Realt extends Tipo {
		public Realt() {
			super("Real");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Boolt extends Tipo {
		public Boolt() {
			super("Bool");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Stringt extends Tipo {
		public Stringt() {
			super("String");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class TipoIn extends Tipo {
		public TipoIn(String t) {
			super(t);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LiteralCad extends Exp{
		private StringLocalizado cadena;

		public LiteralCad(StringLocalizado cadena) {
			this.cadena = cadena;
		}

		public StringLocalizado cad() {
			return cadena;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public int prioridad() {
			// TODO Auto-generated method stub
			return 5;
		}
	}

	// Constructoras
	public Prog programa_conDecs(Decs decs, Insts inss) {
		return new Programa_conDecs(decs, inss);
	}

	public Prog programa_sinDecs(Insts inss) {
		return new Programa_sinDecs(inss);
	}

	public Exp suma(Exp arg0, Exp arg1) {
		return new Suma(arg0, arg1);
	}

	public Exp resta(Exp arg0, Exp arg1) {
		return new Resta(arg0, arg1);
	}

	public Exp and(Exp arg0, Exp arg1) {
		return new And(arg0, arg1);
	}

	public Exp or(Exp arg0, Exp arg1) {
		return new Or(arg0, arg1);
	}

	public Exp not(Exp arg0) {
		return new Not(arg0);
	}

	public Exp menor(Exp arg0, Exp arg1) {
		return new Menor(arg0, arg1);
	}

	public Exp mayor(Exp arg0, Exp arg1) {
		return new Mayor(arg0, arg1);
	}

	public Exp menor_igual(Exp arg0, Exp arg1) {
		return new Menor_igual(arg0, arg1);
	}

	public Exp mayor_igual(Exp arg0, Exp arg1) {
		return new Mayor_igual(arg0, arg1);
	}

	public Exp equivalente(Exp arg0, Exp arg1) {
		return new Equivalente(arg0, arg1);
	}

	public Exp distinto(Exp arg0, Exp arg1) {
		return new Distinto(arg0, arg1);
	}

	public Exp neg(Exp arg0) {
		return new Neg(arg0);
	}

	public Exp mul(Exp arg0, Exp arg1) {
		return new Mul(arg0, arg1);
	}

	public Exp div(Exp arg0, Exp arg1) {
		return new Div(arg0, arg1);
	}

	public Exp mod(Exp arg0, Exp arg1) {
		return new Mod(arg0, arg1);
	}

	/*
	 * public Exp flecha(Exp arg0, Exp arg1) { return new Flecha(arg0, arg1); }
	 */

	public Exp num(StringLocalizado num) {
		return new Num(num);
	}

	public Exp nEntero(StringLocalizado num) {
		return new NEntero(num);
	}

	public Exp nReal(StringLocalizado num) {
		return new NReal(num);
	}

	public Exp id(StringLocalizado num) {
		return new Id(num);
	}

	public Exp falso() {
		return new Falso();
	}

	public Exp cierto() {
		return new Cierto();
	}

	public Exp nulo() {
		return new Nulo();
	}

	public Dec dec_habitual(Tipo tipo, StringLocalizado id) {
		return new Dec_habitual(tipo, id);
	}

	public Dec dec_proc(StringLocalizado id, ParamForm pf, Bloque block) {
		return new Dec_proc(id, pf, block);
	}

	public Dec dec_bloque(Tipo tipo, StringLocalizado id) {
		return new Dec_bloque(tipo, id);
	}

	public Decs declaracion_una(Dec dec) {
		return new Declaracion_una(dec);
	}

	public Decs declaracion_varias(Dec dec, Decs decs) {
		return new Declaracion_varias(dec, decs);
	}

	public Insts instruccion_varias(Inst ins, Insts inss) {
		return new Instruccion_varias(inss, ins);
	}

	public Insts instruccion_una(Inst ins) {
		return new Instruccion_una(ins);
	}

	public Inst instruccion_asig(Exp id, Exp val) {
		return new Instruccion_asig(id, val);
	}

	public Inst instruccion_if(Exp id, InstrOp val) {
		return new Instruccion_if(id, val);
	}

	public Inst instruccion_if_nada(Exp e) {
		return new Instruccion_if_nada(e);
	}

	public Inst instruccion_ifelse(Exp val, InstrOp in1, InstrOp in2) {
		return new Instruccion_ifelse(val, in1, in2);
	}

	public Inst instruccion_ifelse_nada(Exp val) {
		return new Instruccion_ifelse_nada(val);
	}

	public Inst instruccion_ifelse_no1(Exp val, InstrOp in1) {
		return new Instruccion_ifelse_no1(val, in1);
	}

	public Inst instruccion_ifelse_no2(Exp val, InstrOp in1) {
		return new Instruccion_ifelse_no2(val, in1);
	}

	public InstrOp instrOp_una(Inst ins) {
		return new InstrOp_una(ins);
	}

	public InstrOp instrOp_varias(Insts inss) {
		return new InstrOp_varias(inss);
	}

	public Inst instruccion_bloque(Bloque bloque) {
		return new Instruccion_bloque(bloque);
	}

	public Inst instruccion_while(Exp val, InstrOp op) {
		return new Instruccion_while(val, op);
	}

	public Inst instruccion_read(Exp val) {
		return new Instruccion_read(val);
	}

	public Inst instruccion_write(Exp val) {
		return new Instruccion_write(val);
	}

	public Inst instruccion_nl() {
		return new Instruccion_nl();
	}

	public Inst instruccion_new(Exp val) {
		return new Instruccion_new(val);
	}

	public Inst instruccion_delete(Exp val) {
		return new Instruccion_delete(val);
	}

	public Inst instruccion_call(StringLocalizado str, ParReales pReal) {
		return new Instruccion_call(str, pReal);
	}

	public ParReales parReales_ninguna() {
		return new ParReales_ninguna();
	}

	public ParReales parReales_una(Exp exp) {
		return new ParReales_una(exp);
	}

	public ParReales parReales_varias(Exp exp, LExpresiones lexps) {
		return new ParReales_varias(exp, lexps);
	}

	public LExpresiones lExpresiones_varias(Exp exp, LExpresiones lexps) {
		return new LExpresiones_varias(exp, lexps);
	}

	public LExpresiones lExpresiones_una(Exp exp) {
		return new LExpresiones_una(exp);
	}

	public StringLocalizado str(String s, int fila, int col) {
		return new StringLocalizado(s, fila, col);
	}

	public Tipo intt() {
		return new Intt();
	}

	public Tipo stringt() {
		return new Stringt();
	}

	public Tipo boolt() {
		return new Boolt();
	}

	public Tipo realt() {
		return new Realt();
	}

	public Tipo tipoin(StringLocalizado in) {
		return new TipoIn(in.s);
	}

	public Flecha flecha(Exp a0, StringLocalizado a1) {
		return new Flecha(a0, a1);
	}

	public Indice indice(Exp a0, Exp a1) {
		return new Indice(a0, a1);
	}

	public Indir indir(Exp a0) {
		return new Indir(a0);
	}

	public Punto punto(Exp a0, StringLocalizado a1) {
		return new Punto(a0, a1);
	}

	public Tipo tPointer(Tipo t) {
		return new TPointer(t);
	}

	public Campo campo(Tipo t, StringLocalizado id) {
		return new Campo(t, id);
	}

	public Campos campos_varios(Campo c, Campos cs) {
		return new Campos_varios(c, cs);
	}

	public Campos campos_uno(Campo c) {
		return new Campos_uno(c);
	}

	public TRecord tRecord_varias(Campo c, Campos cs) {
		return new TRecord_varias(c, cs);
	}

	public TRecord tRecord_una(Campo c) {
		return new TRecord_una(c);
	}

	public TArray tArray(StringLocalizado n, Tipo t) {
		return new TArray(n, t);
	}

	public Bloque bloque(Prog p) {
		return new Bloque(p);
	}

	public LParamForm lparamForm_varias(ParamD par, LParamForm pars) {
		return new LParamForm_varias(par, pars);
	}

	public LParamForm lparamForm_una(ParamD par) {
		return new LParamForm_una(par);
	}

	public ParamD paramD(Tipo t, StringLocalizado i) {
		return new ParamD(t, i);
	}

	public ParamForm param_form(ParamD par, LParamForm pars) {
		return new Param_form(par, pars);
	}

	public ParamForm param_form_uno(ParamD par) {
		return new Param_form_uno(par);
	}

	public ParamForm param_form_nada() {
		return new Param_form_nada();
	}
	public Exp literalCad(StringLocalizado s) {
		return new LiteralCad(s);
	}
	public Dec dec_type(Tipo a, Tipo b) {
		return new Dec_type(a, b);
		
	}
}
