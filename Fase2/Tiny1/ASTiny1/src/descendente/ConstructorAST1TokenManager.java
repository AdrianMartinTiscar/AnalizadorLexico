/* Generated By:JavaCC: Do not edit this line. ConstructorAST1TokenManager.java */
package descendente;
import procesamiento.TinyASint.Exp;
import procesamiento.TinyASint.Dec;
import procesamiento.TinyASint.Decs;
import procesamiento.TinyASint.Programa;
import procesamiento.TinyASint.Instrs;
import procesamiento.TinyASint.Insts;
import procesamiento.TinyASint.Tipo;
import procesamiento.SemOps;

public class ConstructorAST1TokenManager implements ConstructorAST1Constants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x100180000000000L) != 0L)
            return 9;
         if ((active0 & 0x7ffffffe00L) != 0L)
         {
            jjmatchedKind = 45;
            return 4;
         }
         return -1;
      case 1:
         if ((active0 & 0x1042110000L) != 0L)
            return 4;
         if ((active0 & 0x6fbdeefe00L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 1;
            return 4;
         }
         return -1;
      case 2:
         if ((active0 & 0x4ebdec7c00L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 2;
            return 4;
         }
         if ((active0 & 0x2100028200L) != 0L)
            return 4;
         return -1;
      case 3:
         if ((active0 & 0x44086c1c00L) != 0L)
            return 4;
         if ((active0 & 0xab5806000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 3;
            return 4;
         }
         return -1;
      case 4:
         if ((active0 & 0x294004000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 4;
            return 4;
         }
         if ((active0 & 0x821802000L) != 0L)
            return 4;
         return -1;
      case 5:
         if ((active0 & 0x84000000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 5;
            return 4;
         }
         if ((active0 & 0x210004000L) != 0L)
            return 4;
         return -1;
      case 6:
         if ((active0 & 0x80000000L) != 0L)
            return 4;
         if ((active0 & 0x4000000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 6;
            return 4;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 37:
         return jjStopAtPos(0, 61);
      case 38:
         jjmatchedKind = 51;
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 40:
         return jjStopAtPos(0, 49);
      case 41:
         return jjStopAtPos(0, 50);
      case 42:
         return jjStopAtPos(0, 57);
      case 43:
         return jjStartNfaWithStates_0(0, 43, 9);
      case 44:
         return jjStopAtPos(0, 52);
      case 45:
         jjmatchedKind = 44;
         return jjMoveStringLiteralDfa1_0(0x100000000000000L);
      case 46:
         return jjStopAtPos(0, 55);
      case 47:
         return jjStopAtPos(0, 60);
      case 59:
         return jjStopAtPos(0, 40);
      case 60:
         return jjStopAtPos(0, 59);
      case 61:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 62:
         return jjStopAtPos(0, 58);
      case 91:
         return jjStopAtPos(0, 53);
      case 93:
         return jjStopAtPos(0, 54);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x20008000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x202000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x4c00000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x100200L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x1100060000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x40010000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x80080000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x410000400L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x4000201000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x2000000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x801000000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         break;
      case 61:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         break;
      case 62:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStopAtPos(1, 56);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x2008002000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x710000400L);
      case 102:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 20, 4);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(1, 30, 4);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x1200000L);
      case 108:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 36, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x4808200L);
      case 111:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(1, 25, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x80020800L);
      case 114:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 16, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x820081000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000400L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
      case 100:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 15, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x4800000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x881000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x208042000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x80800L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L);
      case 114:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 37, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x20004000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 116:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 4);
         else if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 17, 4);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 119:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000L);
      case 99:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 4);
         break;
      case 100:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 4);
         break;
      case 101:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 4);
         else if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(3, 22, 4);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 38, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x200000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x804000L);
      case 108:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 4);
         else if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 4);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 4);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 27, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      case 110:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(3, 21, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      case 119:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 4);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(4, 24, 4);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(4, 35, 4);
         break;
      case 102:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 4);
         break;
      case 104:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x280000000L);
      case 121:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(4, 29, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 4);
         break;
      case 101:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(5, 33, 4);
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000L);
      case 103:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 4);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000L);
      case 114:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(6, 31, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(7, 26, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 26;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     jjCheckNAddStates(0, 3);
                  }
                  else if ((0x100002700L & l) != 0L)
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjAddStates(4, 7);
                  else if (curChar == 48)
                  {
                     if (kind > 46)
                        kind = 46;
                     jjCheckNAddTwoStates(14, 17);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(6, 7);
                  else if (curChar == 35)
                  {
                     if (kind > 8)
                        kind = 8;
                     jjCheckNAdd(2);
                  }
                  break;
               case 9:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 47)
                        kind = 47;
                     jjCheckNAddStates(8, 10);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 47)
                        kind = 47;
                     jjCheckNAddTwoStates(14, 17);
                  }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     jjCheckNAdd(10);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 46)
                        kind = 46;
                  }
                  break;
               case 1:
                  if (curChar != 35)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0xfffffffffffffbffL & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(2);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 45)
                     kind = 45;
                  jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 5:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 6:
                  if ((0xffffffffffffd8ffL & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 7:
                  if (curChar == 34 && kind > 48)
                     kind = 48;
                  break;
               case 8:
                  if ((0x280000000000L & l) != 0L)
                     jjAddStates(4, 7);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar == 48 && kind > 46)
                     kind = 46;
                  break;
               case 12:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAddStates(8, 10);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAddStates(8, 10);
                  break;
               case 14:
                  if (curChar == 46)
                     jjCheckNAddStates(11, 13);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(15, 16);
                  break;
               case 16:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(17);
                  break;
               case 18:
                  if ((0x280000000000L & l) != 0L)
                     jjAddStates(14, 15);
                  break;
               case 19:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(20);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(20);
                  break;
               case 21:
                  if (curChar == 48 && kind > 47)
                     kind = 47;
                  break;
               case 22:
                  if (curChar != 48)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(17);
                  break;
               case 23:
                  if (curChar != 48)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAddTwoStates(14, 17);
                  break;
               case 24:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAddStates(0, 3);
                  break;
               case 25:
                  if (curChar != 48)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAddTwoStates(14, 17);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 45)
                     kind = 45;
                  jjCheckNAdd(4);
                  break;
               case 2:
                  if (kind > 8)
                     kind = 8;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 45)
                     kind = 45;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  jjAddStates(16, 17);
                  break;
               case 17:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 6:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(16, 17);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 26 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   10, 13, 14, 17, 9, 11, 12, 23, 13, 14, 17, 15, 16, 22, 19, 21, 
   6, 7, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\151\156\164", 
"\162\145\141\154", "\142\157\157\154", "\164\162\165\145", "\146\141\154\163\145", 
"\163\164\162\151\156\147", "\141\156\144", "\157\162", "\156\157\164", "\156\165\154\154", 
"\160\162\157\143", "\151\146", "\164\150\145\156", "\145\154\163\145", "\145\156\144\151\146", 
"\167\150\151\154\145", "\144\157", "\145\156\144\167\150\151\154\145", "\143\141\154\154", 
"\162\145\143\157\162\144", "\141\162\162\141\171", "\157\146", "\160\157\151\156\164\145\162", 
"\156\145\167", "\144\145\154\145\164\145", "\162\145\141\144", "\167\162\151\164\145", 
"\156\154", "\166\141\162", "\164\171\160\145", "\46\46", "\73", "\75", "\75\75", "\53", 
"\55", null, null, null, null, "\50", "\51", "\46", "\54", "\133", "\135", "\56", 
"\55\76", "\52", "\76", "\74", "\57", "\45", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x3ffffffffffffe01L, 
};
static final long[] jjtoSkip = {
   0x180L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[26];
private final int[] jjstateSet = new int[52];
protected char curChar;
public ConstructorAST1TokenManager(SimpleCharStream stream)
{
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public ConstructorAST1TokenManager(SimpleCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 26; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
