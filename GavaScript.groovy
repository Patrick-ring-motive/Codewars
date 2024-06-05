class Kata {
    static final def engine=new javax.script.ScriptEngineManager().getEngineByName("groovy");
    static final noSpace(String str) {
        return engine.eval("""
        
        function noSpace(String str){
          return str.replaceAll(' ','')
        }
        noSpace('${str}');
        
    """.replaceAll(/(^|[^a-zA-Z0-9])function/,'$1def'))).toString();}}