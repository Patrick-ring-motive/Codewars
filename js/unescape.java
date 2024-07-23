public class Maskify {
  public static final javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
  public static final String maskify(String str) {try{
return (""+engine.eval(
        
       "var s = (''+function(){/*`"+str+"`*/}).split('/*`')[1].split('`*/')[0];"+
       "function maskify(cc) {"+
          "return cc.slice(0,-4).replace(/./g,'#')+cc.slice(-4);"+
        "}"+
        "maskify(s);"
    
));}catch(Exception e){e.printStackTrace();return str;}}}
