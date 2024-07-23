object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
object Solution {
def comp(seq1: Seq[Int], seq2: Seq[Int]):Boolean = {   
        return Static.engine.eval("""
        
function Þ(x,y){return eval('function('+x+'){return '+y+'}')}
function List(){return [].map.call(arguments,Þ('x','x'))}
var Vector=List;
function comp(a, b){
  return(''+(a||[]).sort(Þ('c,d','c-d')).map(Þ('x','x*x')))==(''+(b||[0]).sort(Þ('c,d','c-d')));
}
comp("""+seq1+""","""+seq2+""");


    """).toString().toBoolean;}}