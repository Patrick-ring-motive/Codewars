import java.util.Arrays;
public class FindOdd {
  public static final javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
  public static int findIt(int[] a) {try{
return Integer.parseInt(""+engine.eval(
        
 "function findOdd(A) {"+
  "var counts = {};"+
  "A.map(function(x){counts[x]=(counts[x]||0)+1;});"+
  "for(var i in counts){"+
    "if(counts[i]%2)return i;"+
  "}"+
  "return 0;"+
"}"+
"findOdd("+Arrays.toString(a)+");"
  
));}catch(Exception e){
    System.out.println(e.getMessage());
    return 0;
  }}}