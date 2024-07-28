import java.util.Arrays;
class Static{companion object{var engine=javax.script.ScriptEngineManager().getEngineByName("nashorn");}}
fun sum(numbers: IntArray): Int {
return """${Static.engine.eval("""
    
    
        function positiveSum(a){
            a=a.filter(function(x){return x>0;});
            return a.reduce(function(x,y){return y>0?x+y:x;},0);
        }
        positiveSum(${Arrays.toString(numbers)});
    
    
""")}""".toInt();}
