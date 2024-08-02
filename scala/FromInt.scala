object Static{val engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");}
object Sol {
  def isSquare(x: Int): Boolean = {  
        return Static.engine.eval("""
        
            !/[.a]/.test(Math.sqrt("""+x+"""));

    """).toString().toBoolean;}
}