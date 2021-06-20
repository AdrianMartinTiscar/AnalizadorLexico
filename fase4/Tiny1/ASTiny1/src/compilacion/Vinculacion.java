package compilacion;

import java.util.*;

import procesamiento.ProcesamientoPorDefecto;
import procesamiento.TinyASint.*;

public class Vinculacion extends ProcesamientoPorDefecto{
	
	private Deque<HashMap<String, Object>> tsTiny1 = new ArrayDeque<>();
	
	public void procesa(Programa_sinDecs p) {
		tsTiny1.addFirst(new HashMap<String,Object>());
		p.ins().procesa(this);
	}
	
	public void procesa(Programa_conDecs p) {
		tsTiny1.addFirst(new HashMap<String,Object>());
		p.decs().procesa(this);
		p.ins().procesa(this);
	}
	
	public void procesa(Declaracion_una d) {
		d.dec().procesa(this);
	}
	
	public void procesa(Declaracion_varias d) {
		d.dec().procesa(this);
		d.decs().procesa(this);
	}
	
	public void procesa(Dec_habitual d) {
		if (tsTiny1.getFirst().containsKey(d.id().toString()))
			throw new RuntimeException("El identificador " + d.id() + " esta repetido.");
		else
			tsTiny1.getFirst().put(d.id().toString(), d);
	}
	
	public void procesa(Dec_type d) {
		if (tsTiny1.getFirst().containsKey(d.id().toString()))
			throw new RuntimeException("El identificador " + d.id() + " esta repetido.");
		else
			tsTiny1.getFirst().put(d.id().toString(), d);
	}
	
	public void procesa(Dec_proc d) {
		if (tsTiny1.getFirst().containsKey(d.id().toString()))//no permitimos sobrecarga de funciones
			throw new RuntimeException("El identificador " + d.id() + " esta repetido.");
		else {
			tsTiny1.getFirst().put(d.id().toString(), d);//Añadimos el identificador del procedimiento
			tsTiny1.addFirst(new HashMap<String, Object>());
			d.parF().procesa(this);
			d.block().procesa(this);
		}	
	}
	
	public void procesa(Param_form p) {
		p.par().procesa(this);
		p.lpar().procesa(this);
	}
	
	public void procesa(ParamDAmp p) {
		if (tsTiny1.getFirst().containsKey(p.id().toString()))
			throw new RuntimeException("El identificador " + p.id() + " esta repetido.");
		else {
			tsTiny1.getFirst().put(p.id().toString(), p);
		}
	}
	
	public void procesa(ParamD p) {
		if (tsTiny1.getFirst().containsKey(p.id().toString()))
			throw new RuntimeException("El identificador " + p.id() + " esta repetido.");
		else {
			tsTiny1.getFirst().put(p.id().toString(), p);
		}
	}
	
	public void procesa(LParamForm_varias lp) {
		lp.par().procesa(this);
		lp.lpar().procesa(this);
	}
	
	public void procesa(Bloque b) {
		b.cont().procesa(this);
	}
	
	public void procesa(TRecord_varias r) {
		r.campo().procesa(this);
		r.campos().procesa(this);
	}
	
	public void procesa(TArray a) {
		a.of().procesa(this);
	}
	
	public void procesa(TPointer p) {
		p.tipo().procesa(this);
	}
	
	public void procesa(Campos_varios c) {
		c.campo().procesa(this);
		c.campos().procesa(this);
	}
	///////////////////////////////////////////////////////////
	public void procesa(Campo c) {
		if (tsTiny1.getFirst().containsKey(c.id().toString()))
			throw new RuntimeException("El identificador " + c.id().toString() + " esta repetido");
		else {
			tsTiny1.getFirst().put(c.id().toString(), c);
		}
	}
	///////////////////////////////////////////////////////////////
	
	public void procesa(Instruccion_varias i) {
		i.ins().procesa(this);
		i.inss().procesa(this);
	}
	
	public void procesa(Instruccion_una i) {
		i.ins().procesa(this);
	}
	
	public void procesa(Instruccion_asig i) {
		HashMap<String, Object> o = compDeclarado(i.id().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.id().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.id().toString()));
			i.val().procesa(this);
		}
	}
	
	public void procesa(Instruccion_if i) {
		i.val().procesa(this);
		i.op().procesa(this);
	}
	
	public void procesa(Instruccion_ifelse i) {
		i.val().procesa(this);
		i.op1().procesa(this);
		i.op2().procesa(this);
	}
	
	public void procesa(InstrOp_varias i) {
		i.instrOps().procesa(this);
	}
	
	public void procesa (Instruccion_while i) {
		i.val().procesa(this);
		i.op().procesa(this);
	}
	
	public void procesa (Instruccion_read i) {
		i.val().procesa(this);
	}
	
	public void procesa (Instruccion_write i) {
		i.val().procesa(this);
	}
	
	public void procesa (Instruccion_new i) {
		i.val().procesa(this);
	}
	
	public void procesa (Instruccion_delete i) {
		i.val().procesa(this);
	}
	
	public void procesa (Instruccion_call i) {
		HashMap<String, Object> o = compDeclarado(i.str().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.str().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.str().toString()));
			i.parReales().procesa(this);
		}
	}
	
	public void procesa(ParReales_varias p) {
		p.exp().procesa(this);
		p.lexps().procesa(this);
	}
	
	public void procesa(LExpresiones_varias p) {
		p.exp().procesa(this);
		p.lExpresiones().procesa(this);
	}
	
	public void procesa(Instruccion_bloque i) {
		i.blo().procesa(this);
	}
	
	public void procesa(Suma s) {
		s.arg0().procesa(this);
		s.arg1().procesa(this);
	}
	
	public void procesa(Resta r) {
		r.arg0().procesa(this);
		r.arg1().procesa(this);
	}
	
	public void procesa(Mul r) {
		r.arg0().procesa(this);
		r.arg1().procesa(this);
	}
	
	public void procesa(Div r) {
		r.arg0().procesa(this);
		r.arg1().procesa(this);
	}
	
	public void procesa(And a) {
		a.arg0().procesa(this);
		a.arg1().procesa(this);
	}
	
	public void procesa(Or o) {
		o.arg0().procesa(this);
		o.arg1().procesa(this);
	}
	

	public void procesa(Mayor may){
		may.arg0().procesa(this);
		may.arg1().procesa(this);
	}
	
	public void procesa(Menor men){
		men.arg0().procesa(this);
		men.arg1().procesa(this);
	}
	
	public void procesa(Mayor_igual mayI){
		mayI.arg0().procesa(this);
		mayI.arg1().procesa(this);
	}
	
	public void procesa(Menor_igual menI){
		menI.arg0().procesa(this);
		menI.arg1().procesa(this);
	}
	
	public void procesa(Equivalente eq){
		eq.arg0().procesa(this);
		eq.arg1().procesa(this);
	}
	
	public void procesa(Distinto dist){
		dist.arg0().procesa(this);
		dist.arg1().procesa(this);
	}
	
	///////////////////////////////////////////////////////////
	//Exp
	///////////////////////////////
	
	public void procesa(Not n) {
		n.arg0().procesa(this);
	}
	
	public void procesa(Neg n) {
		n.arg0().procesa(this);
	}
	
	public void procesa (Indice i) {
		HashMap<String, Object> o = compDeclarado(i.arg0().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.arg0().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.arg0().toString()));
			i.arg1().procesa(this);
		}
	}
	///////////////////////////////////////////////////////////
	public void procesa (Punto i) {
		HashMap<String, Object> o = compDeclarado(i.arg0().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.arg0().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.arg0().toString()));
			//i.arg1().vincula(this);
		}
	}
	///////////////////////////////////////////////////////////
	
	public void procesa (Flecha i) {
		HashMap<String, Object> o = compDeclarado(i.arg0().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.arg0().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.arg0().toString()));
			//i.arg1().vincula(this);
		}
	}
	
	public void procesa (Indir i) {
		HashMap<String, Object> o = compDeclarado(i.arg0().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.arg0().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.arg0().toString()));
			
		}
	}
	
	public void procesa (Id i) {
		HashMap<String, Object> o = compDeclarado(i.id().toString());
		if(o == null)
			throw new RuntimeException("El identificador " + i.id().toString() + " no esta declarado.");
		else {
			i.put(o.get(i.id().toString()));
			
		}
	}
	
	private HashMap<String, Object> compDeclarado(String id) {
		for(HashMap<String, Object> i : tsTiny1) {
			if (i.containsKey(id))
				return i;
		}
		return null;
	}
	
	////////////////////frrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
	
	/*
	public void procesa (Dec d){}

	public void procesa (Inst ins) {}

	
	public void procesa(NEntero exp){}
	public void procesa(NReal exp){}
	
	public void procesa(Cierto t){}
	public void procesa(Falso f){}
	public void procesa(Exp e) {}
	public void procesa (Tipo t) {}
	
	public void procesa(Dec_bloque dec){}
	
	public void procesa(Param_form_nada p){}
	public void procesa(Param_form_uno p){}
	
	public void procesa(LParamForm_una p){}
	
	public void procesa(Bloque_vacio b) {}
	
	public void procesa(TRecord_una rec){}
	public void procesa(Campos_uno c){}
	
	public void procesa(InstrOp_una instOp_una){}
	
	public void procesa(ParReales_una parReales_una){}
	
	public void procesa(ParReales_ninguna parReales_ninguna){}
	public void procesa(LExpresiones_una lExpresiones_una){}
	
	public void procesa(LiteralCad lc){}

	public void procesa(Instruccion_if_nada in){}
	
	public void procesa(Instruccion_ifelse_nada in){}
	public void procesa(Instruccion_ifelse_no1 in){}
	public void procesa(Instruccion_ifelse_no2 in){}
	
	
	public void procesa(Instruccion_nl in) {}
	*/
	
}
