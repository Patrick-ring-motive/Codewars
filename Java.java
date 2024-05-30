public class LeapYears {
  public static final javax.script.ScriptEngine engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
  public static final boolean isLeapYear(int year) {try{
return (""+engine.eval(
        
       "function isLeapYear(year) {"+
          "return !!((!(year%4))"+
                   "&&((year%100)"+
                  "||(!(year%400))));"+
        "}"+
        "isLeapYear("+year+");"
    
)).equals("true");}catch(Exception e){return false;}}}