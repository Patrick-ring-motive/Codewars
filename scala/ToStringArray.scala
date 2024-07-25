object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
object DirReduction {
  def dirReduc(arr: Array[String]): Array[String] = {   
        return Static.engine.eval("""

function dirReduc(arr){
  var s = (''+arr).toLowerCase().replace(/[^a-z,]/g,'');
  var re = /north,south|south,north|east,west|west,east/gi;
  while(re.test(s)){
  s=s.replace(re,'').replace(/,+/g,',').replace(/^,|,$/g,'');
  }
  return s==''?'':s.toUpperCase();
}
dirReduc('"""+arr.toSeq+"""'.split('(')[1].split(')')[0]);


    """).toString().split(",");}}
