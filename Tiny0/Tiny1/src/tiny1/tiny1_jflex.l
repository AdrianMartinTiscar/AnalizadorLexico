package tiny1;

%%
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ATinyOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ATinyOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = \.{digito}* {digitoPositivo}
parteExponencial = (E|e)[\+,\-]?{parteEntera}
ignorada = [ \t\r\b\n]
comentario = #[^\n]*
int = int
real = real
bool = bool
string = string
and = and
or = or
not  = not
null = null
true = true
false = false
proc = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
array = array
of = of
pointer = pointer
new = new
delete=delete
read = read
write = write
nl = nl
var = var
type = type
identificador = {letra}({letra}|{digito}|\_)*
numeroEntero = [\+,\-]?{parteEntera}
numeroReal = [\+,\-]?{parteEntera}{parteDecimal}{parteExponencial}
literalCad = \”[^\b\n\r\“]*\”
Separacion= &&
Amp = &
suma = \+
resta = \-
mul = \*
div = \/
men = <
may= >
MenEq= <=
MayEq= >=
Equiv= ==
Dist = !=
PAp= \(
PCie= \)
PtoComa = \;
Igual = \=
Coma = \,
Porc = \%
CorAp = \[
CorCie= \]
LlAp= \{
LlCie= \}
Pnto = \.
Flecha= ->
%%
{ignorada}                {}
{comentario}              {}
{int}                     {return ops.unidadIntT();}
{real}                    {return ops.unidadRealT();}
{bool}                    {return ops.unidadBoolT();}
{string}                  {return ops.unidadStringT();}
{and}                     {return ops.unidadAnd();}
{or}                      {return ops.unidadOr();}
{not}                     {return ops.unidadNot();}
{null}                    {return ops.unidadNull();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{proc}                    {return ops.unidadProc();}
{if}                      {return ops.unidadIf();}
{then}                    {return ops.unidadThen();}
{else}                    {return ops.unidadElse();}
{endif}                   {return ops.unidadEndif();}
{while}                   {return ops.unidadWhile();}
{do}                      {return ops.unidadDo();}
{endwhile}                {return ops.unidadEndwhile();}
{call}                    {return ops.unidadCall();}
{record}                  {return ops.unidadRecord();}
{array}                   {return ops.unidadArray();}
{of}                      {return ops.unidadOf();}
{pointer}                 {return ops.unidadPointer();}
{new}                     {return ops.unidadNew();}
{delete}                  {return ops.unidadDelete();}
{read}                    {return ops.unidadRead();}
{write}                   {return ops.unidadWrite();}
{nl}                      {return ops.unidadNl();}
{var}                     {return ops.unidadVar());}
{type}                    {return ops.unidadType());}
{identificador            {return ops.unidadIdentificador());}
{numeroEntero}            {return ops.unidadEntero());}
{numeroReal}              {return ops.unidadReal());}
{literalCad}              {return ops.unidadLiteralCadena());}
{Separacion}              {return ops.unidadSeparacion();}
{Amp}                     {return ops.unidadAmpersand();}
{suma}                    {return ops.unidadSuma();}
{resta}                   {return ops.unidadResta();}
{mul}                     {return ops.unidadMultiplicacion();}
{div}                     {return ops.unidadDivision();}
{men}                     {return ops.unidadMenor();}
{may}                     {return ops.unidadMayor();}
{MenEq}                   {return ops.unidadMenorIgual();}
{MayEq}                   {return ops.unidadMayorIgual();}
{Equiv}                   {return ops.unidadEquivalente();}
{Dist}                    {return ops.unidadDistinto();}
{PAp}                     {return ops.unidadParentesisApertura();}
{PCie}                    {return ops.unidadParentesisCierre();}
{PtoComa}                 {return ops.unidadPuntoComa();}
{Igual}                   {return ops.unidadIgual();}
{Coma}                    {return ops.unidadComa();}
{Porc}                    {return ops.unidadPorcentaje();}
{CorAp}                   {return ops.unidadCorcheteApertura();}
{CorCie}                  {return ops.unidadCorcheteCierre();}
{LlAp}                    {return ops.unidadLlaveApertura();}
{LlCie}                   {return ops.unidadLlaveCierre();}
{Pnto}                    {return ops.unidadPunto();}
{Flecha}                  {return ops.unidadFlecha();}
[^]                       {ops.error();}