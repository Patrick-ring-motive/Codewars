object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
object Kata {
def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int]  = {   
        return Static.engine.eval("""
        
function toArr(x){return x.replace(/[^0-9,]/g,'').split('');}
Array.prototype.includes=function(x){return this.indexOf(x)>-1;};
function arrayDiff(a, b) {
  var c = [];
  for(var i=0;i<a.length;i++){
    b.includes(a[i])||c.push(a[i]);
  }
  return (''+c).replace(/[^0-9,]/g,'');
}
arrayDiff(toArr('"""+a+"""'),toArr('"""+b+"""'));


