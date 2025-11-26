public class Boolfuck {
    static final def engine=new javax.script.ScriptEngineManager().getEngineByName("nashorn");
    static final def compile=engine.eval("""
function boolfuck(code, input) {
  input = input || "";
  var inputBits = [];
  var inputLength = input.length;
  (function(){
  for (var i = 0; i !== inputLength; ++i) {
      var charCode = input.charCodeAt(i);
      for (var b = 0; b !== 8; ++b) {
        inputBits.push((charCode >> b) & 1);
      }
    }
  })();
  inputBits.reverse();
  var bracketMap = {};
  var stack = [];
  var codeLength = code.length;
  (function(){
    for (var i = 0; i !== codeLength; ++i) {
      if (code[i] === '[') {
        stack.push(i);
      } else if (code[i] === ']') {
        var start = stack.pop();
        bracketMap[start] = i;
        bracketMap[i] = start;
      }
    }
  })();

  var memory = {};
  var ptr = 0;
  var outputBits = [];

  var getBit = function(){return memory[ptr] ? 1 : 0;};
  
  var setBit = function(val){memory[ptr] = val;};

  for (var ip = 0;ip !== codeLength;++ip) {
    var command = code[ip];
    switch (command) {
      case '+':
        setBit(getBit() === 0 ? 1 : 0);
        break;
      case ',':
        var nextBit = inputBits.pop();
        setBit(nextBit === undefined ? 0 : nextBit);
        break;
      case ';':
        outputBits.push(getBit());
        break;
      case '<':
        ptr--;
        break;
      case '>':
        ptr++;
        break;
      case '[':
        if (getBit() === 0) ip = bracketMap[ip];
        break;
      case ']':
        if (getBit() === 1) ip = bracketMap[ip];
        break;
    }
  }
  var result = "";
  var outputBitsLength = outputBits.length;
  (function(){
    for (var i = 0; i < outputBitsLength; i += 8) {
      var charCode = 0;
      for (var b = 0; b !== 8; ++b) {
        if (i + b < outputBitsLength && outputBits[i + b] === 1) {
          charCode += (1 << b);
        }
      }
      result += String.fromCharCode(charCode);
    }
  })();

  return result;
}

 """);
static final def invocable = (javax.script.Invocable)engine;
public static String interpret (String code, String input) {
     return invocable.invokeFunction("boolfuck",code,input);
}}
