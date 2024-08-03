class Kata {
    static final def engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
    static def arrayDiff(a, b) {
        return Eval.me("["+engine.eval("""
    
Array.prototype.includes=function(x){return this.indexOf(x)>-1;};
function arrayDiff(a, b) {
  var c = [];
  for(var i=0;i<a.length;i++){
    if(a[i]!==undefined&&!b.includes(a[i])){
      c.push(a[i]);
    }
  }
  return ''+c;
}
arrayDiff((${a}),(${b}));



    """)+"]");
}}