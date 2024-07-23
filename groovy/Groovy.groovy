class Kata {
    static final def engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
    static final String longToIp(Long ip) {
        return engine.eval("""
    
        function b0(n){return parseInt(n, 2);}
        function longToIp(ip){
          var bytes = ('0000000000000000000000000000000'+ip.toString(2)).slice(-32);
          return b0(bytes.slice(0,8))+'.'+b0(bytes.slice(8,16))+'.'+b0(bytes.slice(16,24))+'.'+b0(bytes.slice(24,32));
        }
        longToIp(${ip});
        
    """).toString();}}