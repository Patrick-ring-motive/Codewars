object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
def solveRunes(runes: String): Int = {   
        return Static.engine.eval("""
        
String.prototype.includes=function(x){return this.indexOf(x)>-1;};
function solveExpression(exp) {
  exp = exp.replace('=','==').replace('--','- -');
  for(var i=0;i<10;i++){
   if(i==0&&(/([^0-9?]|^)[?][0-9?]/.test(exp)))continue;
   if(!exp.includes(i)&&eval(exp.replace(/[?]/g,i)))return i;
  }
  return -1;
}
solveExpression('"""+runes+"""');


    """).toString().toInt;}
