object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
object ProdFib {
  def productFib(prod: Long): Array[Long] = {   
        return Static.engine.eval("""
        
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
productFib("""+prod+""");


    """).toString().split(",").map(_.toLong);}}
