/* Generated By:JavaCC: Do not edit this line. ConstructorAST1.java */
package descendente;

import procesamiento.TinyASint.Exp;
import procesamiento.TinyASint.Dec;
import procesamiento.TinyASint.Decs;
import procesamiento.TinyASint.Prog;
import procesamiento.TinyASint.Inst;
import procesamiento.TinyASint.Insts;
import procesamiento.TinyASint.Tipo;
import procesamiento.SemOps;

public class ConstructorAST1 implements ConstructorAST1Constants {
        private SemOps sem = new SemOps();

  final public Prog ProgramaPrev() throws ParseException {
                         Programa prog;
    prog = Programa();
    jj_consume_token(0);
                                                                 {if (true) return prog;}
    throw new Error("Missing return statement in function");
  }

  final public Prog Programa() throws ParseException {
                     Decs decs; Insts instrs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case proc:
    case var:
    case type:
      decs = Decs();
      jj_consume_token(Separacion);
      instrs = Insts();
                                                                                  {if (true) return sem.programa_conDecs(decs, instrs);}
      break;
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case pif:
    case pwhile:
    case call:
    case pnew:
    case delete:
    case read:
    case write:
    case nl:
    case menos:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
    case 57:
      instrs = Insts();
                                                         {if (true) return sem.programa_sinDecs(instrs);}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Decs Decs() throws ParseException {
                 Dec dec; Decs restDec;
    dec = Dec();
    restDec = restoDec(dec);
                                                                  {if (true) return restDec;}
    throw new Error("Missing return statement in function");
  }

  final public Decs restoDec(Dec dec) throws ParseException {
                            Decs decs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      decs = Decs();
                                                                           {if (true) return sem.declaracion_varias(dec, decs);}
      break;
    default:
      jj_la1[1] = jj_gen;
                                                    {if (true) return sem.declaracion_una(dec);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Dec Dec() throws ParseException {
               Token d; Tipo tipo; Token t; ParamForm param; Prog bloque;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case var:
      d = jj_consume_token(var);
      tipo = Tipo();
      t = jj_consume_token(id);
                                                       {if (true) return sem.dec_habitual(tipo, t);}
      break;
    case type:
      d = jj_consume_token(type);
      tipo = Tipo();
      t = jj_consume_token(id);
                                                        {if (true) return sem.dec_type(tipo, t);}
      break;
    case proc:
      d = jj_consume_token(proc);
      t = jj_consume_token(id);
      param = paramForm();
      bloque = bloque();
                                                                              {if (true) return sem.dec_proc(t, param, bloque);}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ParamForm paramForm() throws ParseException {
                           ParamForm paramD; ParamForm paramL;
    jj_consume_token(49);
    paramD = paramFormD();
    paramL = LparamForm();
    jj_consume_token(50);
                                                                                            {if (true) return sem.param_formAux(paramD, paramL);}
    throw new Error("Missing return statement in function");
  }

  final public ParamForm paramFormD() throws ParseException {
                            Tipo tipo; ParamForm restparam;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pint:
    case real:
    case bool:
    case string:
    case record:
    case pointer:
    case id:
      tipo = Tipo();
      restparam = restParamFormD(tipo);
                                                                                        {if (true) return restparam;}
      break;
    default:
      jj_la1[3] = jj_gen;
                                            {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public ParamForm restParamFormD(Tipo tipo) throws ParseException {
                                         Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
      t = jj_consume_token(id);
                                                                                      {if (true) return sem.ParamDAmp(tipo, t);}
      break;
    case id:
      t = jj_consume_token(id);
                                                                                  {if (true) return sem.ParamD(tipo, t);}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ParamForm LparamForm() throws ParseException {
                            ParamForm param; ParamForm paramL;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 52:
      jj_consume_token(52);
      paramD = paramFormD();
      paramL = LparamForm();
                                                                                         {if (true) return param_formAux(paramD, paramL);}
      break;
    default:
      jj_la1[5] = jj_gen;
                                            {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Prog bloque() throws ParseException {
                   Prog programa;
    jj_consume_token(49);
    programa = Programa();
    jj_consume_token(50);
                                                                {if (true) return programa;}
    throw new Error("Missing return statement in function");
  }

  final public Tipo tipoBas() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pint:
      jj_consume_token(pint);
                                            {if (true) return intt();}
      break;
    case bool:
      jj_consume_token(bool);
                                           {if (true) return boolt();}
      break;
    case real:
      jj_consume_token(real);
                                           {if (true) return realt();}
      break;
    case string:
      jj_consume_token(string);
                                             {if (true) return stringt();}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Tipo Tipo() throws ParseException {
                 Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pint:
    case real:
    case bool:
    case string:
      t = tipoBas();
                                              {if (true) return t;}
      break;
    case id:
      t = tarray();
                                             {if (true) return t;}
      break;
    case record:
      t = trecord();
                                              {if (true) return t;}
      break;
    case pointer:
      t = tpointer();
                                               {if (true) return t;}
      break;
      t = jj_consume_token(id);
                                         {if (true) return t;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Tipo tarray() throws ParseException {
                   Token array; Nentero num; Tipo tipo;
    array = jj_consume_token(id);
    jj_consume_token(53);
    num = jj_consume_token(Nentero);
    jj_consume_token(54);
    jj_consume_token(of);
    tipo = Tipo();
                                                                                      {if (true) return sem.tArray(num, tipo);}
    throw new Error("Missing return statement in function");
  }

  final public Tipo trecord() throws ParseException {
                    Campo campo; Campos campos;
    jj_consume_token(record);
    jj_consume_token(49);
    campo = campo();
    campos = campos();
    jj_consume_token(50);
                                                                                    {if (true) return sem.tRecordAux(campo, campos);}
    throw new Error("Missing return statement in function");
  }

  final public Tipo campos() throws ParseException {
                   Campo campo; Campos campos;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      campo = campo();
      campos = campos();
                                                                            {if (true) return sem.camposAux(campo, campos);}
      break;
    default:
      jj_la1[8] = jj_gen;
                                   {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Tipo campo() throws ParseException {
                  Tipo t; Token i;
    t = Tipo();
    i = jj_consume_token(id);
                                                   {if (true) return sem.campo(t, i);}
    throw new Error("Missing return statement in function");
  }

  final public Tipo tpointer() throws ParseException {
                     Tipo t;
    jj_consume_token(pointer);
    t = Tipo();
                                                             {if (true) return sem.tPointer(t);}
    throw new Error("Missing return statement in function");
  }

  final public Insts Insts() throws ParseException {
                   Inst instr; Insts restoins;
    instr = Inst();
    restoins = restoIns(instr);
                                                            {if (true) return restoins;}
    throw new Error("Missing return statement in function");
  }

  final public Insts restoIns(Inst instr) throws ParseException {
                                Insts instrs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PtoComa:
      jj_consume_token(PtoComa);
      instrs = Insts();
                                                                                             {if (true) return sem.instruccion_varias(instr, instrs);}
      break;
    default:
      jj_la1[9] = jj_gen;
                                                                  {if (true) return sem.instruccion_una(instr);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst Inst() throws ParseException {
                 Exp ex1; Exp ex2; InstrsOp op1; InstrsOp op2; Token i; ParReales par; Prog blo; Insts res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case menos:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
    case 57:
      ex1 = expr();
      jj_consume_token(asig);
      ex2 = expr();
                                                              {if (true) return sem.instuccion_asig(ex1, ex2);}
      break;
    case pif:
      jj_consume_token(pif);
      ex1 = expr();
      jj_consume_token(then);
      op1 = InstrsOp();
      res = restoIf(ex1, op1);
                                                                                                 {if (true) return res;}
      break;
    case pwhile:
      jj_consume_token(pwhile);
      ex1 = expr();
      jj_consume_token(pdo);
      op1 = InstrsOp();
      jj_consume_token(endwhile);
                                                                                        {if (true) return sem.instruccion_while(ex1, op1);}
      break;
    case read:
      jj_consume_token(read);
      ex1 = expr();
                                                      {if (true) return sem.instruccion_read(ex1);}
      break;
    case write:
      jj_consume_token(write);
      ex1 = expr();
                                                       {if (true) return sem.instruccion_write(ex1);}
      break;
    case nl:
      jj_consume_token(nl);
                                         {if (true) return sem.instruccion_nl();}
      break;
    case pnew:
      jj_consume_token(pnew);
      ex1 = expr();
                                                      {if (true) return sem.instruccion_new(ex1);}
      break;
    case delete:
      jj_consume_token(delete);
      ex1 = expr();
                                                        {if (true) return sem.instruccion_delete(ex1);}
      break;
    case call:
      jj_consume_token(call);
      i = jj_consume_token(id);
      par = parReales();
                                                                  {if (true) return sem.instruccion_call(i, par);}
      break;
      blo = bloque();
                                                 {if (true) return sem.instruccion_bloque(blo);}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public InstrsOp InstrsOp() throws ParseException {
                         Insts inst; Insts instrs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case pif:
    case pwhile:
    case call:
    case pnew:
    case delete:
    case read:
    case write:
    case nl:
    case menos:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
    case 57:
      inst = Insts();
      instrs = Insts();
                                                                              {if (true) return sem.instrOpAux(inst, instrs);}
      break;
    default:
      jj_la1[11] = jj_gen;
                                                 {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst restoIf(Exp e, InstrsOp op1) throws ParseException {
                                       InstrsOp op2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case endif:
      jj_consume_token(endif);
                                                                                     {if (true) return sem.instruccion_ifAux(e, op1);}
      break;
    case pelse:
      jj_consume_token(pelse);
      op2 = InstrsOp();
      jj_consume_token(endif);
                                                                                                            {if (true) return sem.instruccion_ifelseAux(e, op1, op2);}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ParReales parReales() throws ParseException {
                           ParReales p;
    jj_consume_token(49);
    p = restoPaRe();
                                                                      {if (true) return p;}
    throw new Error("Missing return statement in function");
  }

  final public ParReales restoPaRe() throws ParseException {
                           Exp ex; LExpresiones lexp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ptrue:
    case pfalse:
    case not:
    case pnull:
    case menos:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
    case 57:
      ex = expr();
      lexp = lExpresiones();
      jj_consume_token(50);
                                                                                      {if (true) return sem.parRealesAux(ex, lexp);}
      break;
    case 50:
      jj_consume_token(50);
                                                       {if (true) return sem.parRealesAux(null, null);}
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public LExpresiones lExpresiones() throws ParseException {
                                 Exp ex; LExpresiones lexp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 52:
      jj_consume_token(52);
      ex = expr();
      lexp = lExpresiones();
                                                                                                    {if (true) return sem.lExpresionesAux(ex, lexp);}
      break;
    default:
      jj_la1[14] = jj_gen;
                                                                 {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp expr() throws ParseException {
                Exp ex;
    ex = E0();
                                     {if (true) return ex;}
    throw new Error("Missing return statement in function");
  }

  final public Exp E0() throws ParseException {
              Exp e1; Exp res;
    e1 = E1();
    res = restoE0(e1);
                                                   {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public Exp restoE0(Exp e1) throws ParseException {
                         Exp ev;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case menos:
      jj_consume_token(menos);
      ev = E1();
                                                                  {if (true) return sem.exp(resta(e1, ev));}
      break;
    case mas:
      jj_consume_token(mas);
      ev = E0();
                                                                {if (true) return sem.exp(suma(e1, ev));}
      break;
    default:
      jj_la1[15] = jj_gen;
                                                 {if (true) return e1;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E1() throws ParseException {
              Exp e2; Exp res;
    e2 = E2();
    res = rest2E1(e2);
                                                   {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public Exp rest2E1(Exp e2) throws ParseException {
                         Token op; Exp ev; Exp res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
    case or:
      op = op1AI();
      ev = E2();
      res = rest2E1(ev);
                                                                             {if (true) return sem.exp(op, e2, res);}
      break;
    default:
      jj_la1[16] = jj_gen;
                                         {if (true) return e2;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E2() throws ParseException {
              Exp e3; Exp res;
    e3 = E3();
    res = rest2E2(e3);
                                                   {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public Exp rest2E2(Exp e3) throws ParseException {
                         Token op; Exp ev; Exp res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 58:
      op = op2AI();
      ev = E3();
      res = rest2E2(ev);
                                                                             {if (true) return sem.exp(op, e3, res);}
      break;
    default:
      jj_la1[17] = jj_gen;
                                         {if (true) return e3;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E3() throws ParseException {
              Exp e4; Exp res;
    e4 = E4();
    res = restE3(e4);
                                                  {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public Exp restE3(Exp e4) throws ParseException {
                        Token op; Exp ev; Exp res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 57:
    case 60:
    case 61:
      op = op3NA();
      ev = E4();
      res = restE3(ev);
                                                                            {if (true) return sem.exp(op, e4, res);}
      break;
    default:
      jj_la1[18] = jj_gen;
                                         {if (true) return e4;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E4() throws ParseException {
              Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case menos:
      jj_consume_token(menos);
      e = E5();
                                          {if (true) return sem.neg(e);}
      break;
    case not:
      jj_consume_token(not);
      e = E4();
                                        {if (true) return sem.not(e);}
      break;
    case ptrue:
    case pfalse:
    case pnull:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
    case 57:
      e = E5();
                                  {if (true) return e;}
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E5() throws ParseException {
              Exp e6; Exp res;
    e6 = E6();
    res = Resto2E5(e6);
                                                    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public Exp Resto2E5(Exp e6) throws ParseException {
                          Exp res; Exp res2; Exp rese5;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 53:
    case 55:
    case 56:
      res = RestoE5(e6);
      res2 = Resto2E5(res);
                                                                                      {if (true) return res2;}
      break;
    default:
      jj_la1[20] = jj_gen;
                                                  {if (true) return e6;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp RestoE5(Exp res) throws ParseException {
                          Exp e; Token i;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 53:
      jj_consume_token(53);
      e = expr();
      jj_consume_token(54);
                                                                    {if (true) return sem.indice(res, e);}
      break;
    case 55:
      jj_consume_token(55);
      i = jj_consume_token(id);
                                                              {if (true) return sem.punto(res, i);}
      break;
    case 56:
      jj_consume_token(56);
      i = jj_consume_token(id);
                                                               {if (true) return sem.flecha(res, i);}
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E6() throws ParseException {
              Exp ev;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 57:
      jj_consume_token(57);
      ev = E6();
                                       {if (true) return sem.indireccion(ev);}
      break;
    case ptrue:
    case pfalse:
    case pnull:
    case id:
    case Nentero:
    case Nreal:
    case literalCad:
    case 49:
      ev = E7();
                                   {if (true) return ev;}
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp E7() throws ParseException {
              Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 49:
      jj_consume_token(49);
      e = E0();
      jj_consume_token(50);
                                          {if (true) return e;}
      break;
    case Nentero:
      e = jj_consume_token(Nentero);
                                       {if (true) return e;}
      break;
    case Nreal:
      e = jj_consume_token(Nreal);
                                     {if (true) return e;}
      break;
    case ptrue:
      e = jj_consume_token(ptrue);
                                     {if (true) return e;}
      break;
    case pfalse:
      e = jj_consume_token(pfalse);
                                      {if (true) return e;}
      break;
    case pnull:
      e = jj_consume_token(pnull);
                                     {if (true) return e;}
      break;
    case literalCad:
      e = jj_consume_token(literalCad);
                                          {if (true) return e;}
      break;
    case id:
      e = jj_consume_token(id);
                                  {if (true) return e;}
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public string op1AI() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
      jj_consume_token(and);
                                           {if (true) return "and";}
      break;
    case or:
      jj_consume_token(or);
                                          {if (true) return "or";}
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public string op2AI() throws ParseException {
                    Token res;
    jj_consume_token(58);
    res = resto('>');
                                                        {if (true) return res;}
    jj_consume_token(59);
    res = resto('<');
                                                        {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  final public string resto(char m) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case asig:
      jj_consume_token(asig);
                                                       {if (true) return (m+'=');}
      break;
    default:
      jj_la1[25] = jj_gen;
                                                  {if (true) return m;}
    }
    throw new Error("Missing return statement in function");
  }

  final public char op3NA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 57:
      jj_consume_token(57);
                                       {if (true) return '*';}
      break;
    case 60:
      jj_consume_token(60);
                                       {if (true) return '/';}
      break;
    case 61:
      jj_consume_token(61);
                                       {if (true) return '%';}
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  public ConstructorAST1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x91e3000,0x0,0x80000,0x90004e00,0x0,0x0,0x4e00,0x90004e00,0x0,0x0,0x9163000,0x9163000,0xc00000,0x63000,0x0,0x0,0x18000,0x0,0x0,0x63000,0x0,0x0,0x43000,0x43000,0x18000,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x203f07f,0x100,0x60,0x2000,0x82000,0x100000,0x0,0x2000,0x100,0x100,0x203f01f,0x203f01f,0x0,0x207f000,0x100000,0x1800,0x0,0x4000000,0x32000000,0x203f000,0x1a00000,0x1a00000,0x203e000,0x3e000,0x0,0x200,0x32000000,};
   }

  public ConstructorAST1(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ConstructorAST1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public ConstructorAST1(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ConstructorAST1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public ConstructorAST1(ConstructorAST1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  public void ReInit(ConstructorAST1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[62];
    for (int i = 0; i < 62; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 62; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}