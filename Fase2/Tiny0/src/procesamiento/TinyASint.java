package procesamiento;

public class TinyASint {
	public static abstract class Exp  {
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
	     public int fila() {return fila;}
	     public int col() {return col;}
	     public String toString() {
	       return s;
	     }
	     public boolean equals(Object o) {
	         return (o == this) || (
	                (o instanceof StringLocalizado) &&
	                (((StringLocalizado)o).s.equals(s)));                
	     }
	     public int hashCode() {
	         return s.hashCode();
	     }
	  }

	    
	    private static abstract class ExpBin extends Exp {
	        private Exp arg0;
	        private Exp arg1;
	        public Exp arg0() {return arg0;}
	        public Exp arg1() {return arg1;}
	        public ExpBin(Exp arg0, Exp arg1) {
	            super();
	            this.arg0 = arg0;
	            this.arg1 = arg1;
	        }
	    }
	        
	    private static abstract class ExpAditiva extends ExpBin {
	        public ExpAditiva(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public final int prioridad() {
	            return 0;
	        }
	    }
	    
	    public static class Suma extends ExpAditiva {
	        public Suma(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Resta extends ExpAditiva {
	        public Resta(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    
	    private static abstract class ExpAndOr extends ExpBin{
	    	public ExpAndOr(Exp arg0, Exp arg1) {
	    		super(arg0, arg1);
	    	}
	    	public final int prioridad() {
	    		return 1;
	    	}
	    }
	    
	    public static class And extends ExpAndOr {
	        public And(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Or extends ExpAndOr {
	        public Or(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    
	    private static abstract class ExpRelacionales extends ExpBin{
	    	public ExpRelacionales(Exp arg0, Exp arg1) {
	    		super(arg0, arg1);
	    	}
	    	public final int prioridad() {
	    		return 2;
	    	}
	    }

	    public static class Menor extends ExpRelacionales {
	        public Menor(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Mayor extends ExpRelacionales {
	        public Mayor(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Menor_igual extends ExpRelacionales {
	        public Menor_igual(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Mayor_igual extends ExpRelacionales {
	        public Mayor_igual(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Equivalente extends ExpRelacionales {
	        public Equivalente(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Distinto extends ExpRelacionales {
	        public Distinto(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    
	    
	    private static abstract class ExpMultiplicativa extends ExpBin {
	        public ExpMultiplicativa(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public final int prioridad() {
	            return 3;
	        }
	    }
	    
	    public static class Mul extends ExpMultiplicativa {
	        public Mul(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Div extends ExpMultiplicativa {
	        public Div(Exp arg0, Exp arg1) {
	            super(arg0,arg1);
	        }
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    
	    private static abstract class ExpUn extends Exp {
	        private Exp arg;
	        public Exp arg0() {return arg;}
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
	        public StringLocalizado num() {return num;}
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
	        public StringLocalizado id() {return id;}
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	        public final int prioridad() {
	            return 5;
	        }
	    }
	    
	    public static class Cierto extends Exp {
	        private StringLocalizado cierto;
	        public Cierto(StringLocalizado cierto) {
	            super();
	            this.cierto = cierto;
	        }
	        public StringLocalizado num() {return cierto;}
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	        public final int prioridad() {
	            return 5;
	        }
	    }
	    
	    public static class Falso extends Exp {
	        private StringLocalizado fals;
	        public Falso(StringLocalizado fals) {
	            super();
	            this.fals = fals;
	        }
	        public StringLocalizado num() {return fals;}
	        public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	        public final int prioridad() {
	            return 5;
	        }
	    }
	    
	    public static class Dec  {
	    	private String tipo;
	        private StringLocalizado id;
	        public Dec(String tipo, StringLocalizado id) {
	            this.id = id;
	            this.tipo = tipo;
	        }
	        public StringLocalizado id() {return id;}
	        public String tipo() {return tipo;}
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
	       public Dec dec() {return dec;}
	       public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    public static class Declaracion_varias extends Decs {
	       private Dec dec;
	       private Decs decs;
	       public Declaracion_varias(Decs decs, Dec dec) {
	          super();
	          this.dec = dec;
	          this.decs = decs;
	       }
	       public Dec dec() {return dec;}
	       public Decs decs() {return decs;}
	       public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }

	    
	    public static class Inst  {
	        private StringLocalizado id;
	        private Exp val;
	        public Inst(StringLocalizado id, Exp val) {
	            this.id = id;
	            this.val = val;
	        }
	        public StringLocalizado id() {return id;}
	        public Exp val() {return val;}
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
	       public Inst ins() {return ins;}
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
	       public Inst ins() {return ins;}
	       public Insts inss() {return inss;}
	       public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }
	    

	    public static class Programa {
	      private Decs decs;
	      private Insts ins;
	       public Programa(Decs decs, Insts ins) {
	          super();
	          this.decs = decs;
	          this.ins = ins;
	       }   
	       public Decs decs() {return decs;}
	       public Insts ins() {return ins;}
	       public void procesa(Procesamiento p) {
	           p.procesa(this); 
	        }     
	    }

	     // Constructoras    
	    public Programa programa(Decs decs, Insts inss) {
	        return new Programa(decs, inss);
	    }
	    public Exp suma(Exp arg0, Exp arg1) {
	        return new Suma(arg0,arg1);
	    }
	    public Exp resta(Exp arg0, Exp arg1) {
	        return new Resta(arg0,arg1);
	    }
	    public Exp and(Exp arg0, Exp arg1) {
	        return new And(arg0,arg1);
	    }
	    public Exp or(Exp arg0, Exp arg1) {
	        return new Or(arg0,arg1);
	    }
	    public Exp not(Exp arg0) {
	        return new Not(arg0);
	    }
	    public Exp menor(Exp arg0, Exp arg1) {
	        return new Menor(arg0,arg1);
	    }
	    public Exp mayor(Exp arg0, Exp arg1) {
	        return new Mayor(arg0,arg1);
	    }
	    public Exp menor_igual(Exp arg0, Exp arg1) {
	        return new Menor_igual(arg0,arg1);
	    }
	    public Exp mayor_igual(Exp arg0, Exp arg1) {
	        return new Mayor_igual(arg0,arg1);
	    }
	    public Exp equivalente(Exp arg0, Exp arg1) {
	        return new Equivalente(arg0,arg1);
	    }
	    public Exp distinto(Exp arg0, Exp arg1) {
	        return new Distinto(arg0,arg1);
	    }
	    public Exp neg(Exp arg0) {
	        return new Neg(arg0);
	    }
	    public Exp mul(Exp arg0, Exp arg1) {
	        return new Mul(arg0,arg1);
	    }
	    public Exp div(Exp arg0, Exp arg1) {
	        return new Div(arg0,arg1);
	    }
	    public Exp num(StringLocalizado num) {
	        return new Num(num);
	    }
	    public Exp id(StringLocalizado num) {
	        return new Id(num);
	    }
	    public Exp falso(StringLocalizado boo) {
	        return new Falso(boo);
	    }
	    public Exp cierto(StringLocalizado boo) {
	        return new Cierto(boo);
	    }
	    public Dec dec(String tipo, StringLocalizado id) {
	        return new Dec(tipo, id);
	    }
	    public Decs declaracion_una(Dec dec) {
	        return new Declaracion_una(dec);
	    }
	    public Decs declaracion_varias(Decs decs, Dec dec) {
	        return new Declaracion_varias(decs,dec);
	    }
	    public Insts instruccion_varias(Insts inss, Inst ins) {
	        return new Instruccion_varias(inss, ins);
	    }
	    public Insts instruccion_una(Inst ins) {
	        return new Instruccion_una(ins);
	    }
	    public Inst instruccion(StringLocalizado id, Exp val) {
	    	return new Inst(id, val);
	    }
	    
	    public StringLocalizado str(String s, int fila, int col) {
	        return new StringLocalizado(s,fila,col);
	    }
}
