package prodfib
class Static{companion object{var engine=javax.script.ScriptEngineManager().getEngineByName("nashorn");}}
fun productFib(prod:Long):LongArray {
return """${Static.engine.eval("""
    
    
Object.freeze(Math);
Object.freeze(Math.round);
var sqrt5 = Math.pow(5,.5);
var phi = (1+sqrt5)/2;
var $1_phi = 1-phi;
function fib(n){
 var x=n;
 return Math.round((Math.pow(phi,x) - Math.pow($1_phi,x))/sqrt5);
};Object.freeze(fib);
        
function productFib(prod){
  if(prod==0)return ''+[0,1,1];
  if(prod<=2)return ''+[Math.max(1,prod-1),Math.max(1,prod),1];
  if(prod==3)return ''+[2,3,0];
  var fn1=0;
  var fn2=0;
  for(var i=1;i<=prod;i++){
    fn2=fib(i);
    fn1=fib(i-1);
    var mult=fn1*fn2;
    if(mult==prod)return ''+[fn1,fn2,1];
    if(mult>prod)return ''+[fn1,fn2,0];
  }
  return ''+[fn1,fn2,1];
}
productFib(${prod});
    
    
""")}""".split(',').map{it.toLong()}.toTypedArray().toLongArray();}
