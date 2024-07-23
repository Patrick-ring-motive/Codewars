class Static{companion object{var engine=javax.script.ScriptEngineManager().getEngineByName("nashorn");}}
fun longToIP(ip: UInt): String {
return """${Static.engine.eval("""
    
    
        function b0(n){return parseInt(n, 2);}
        var int32=${ip};
        var bytes = ('0000000000000000000000000000000'+int32.toString(2)).slice(-32);
        var str = b0(bytes.slice(0,8))+'.'+b0(bytes.slice(8,16))+'.'+b0(bytes.slice(16,24))+'.'+b0(bytes.slice(24,32));
        str;
    
    
""")}""";}
