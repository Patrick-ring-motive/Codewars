class Kata {
    static final def engine=new javax.script.ScriptEngineManager().getEngineByName("groovy");
    static final noSpace(String str) {
        return engine.eval("""
        
        def noSpace(String str){
          return str.replaceAll(' ','')
        }
        noSpace('${str}');
        
    """).toString();}}