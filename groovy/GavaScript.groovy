class EvenOdd {
    static final engine=new javax.script.ScriptEngineManager().getEngineByName("groovy");
    static final evenOrOdd(number){
        return engine.eval("""

      function EvenOdd(const number){

        return number%2?'Odd':'Even';

      }
      EvenOdd(${number});

    """.replaceAll(/(^|[^a-zA-Z0-9])function\s+([a-zA-Z_]\w*)\s*\(/,'$1def $2(')
       .replaceAll(/(^|[^a-zA-Z0-9])function\s+\(/,'$1def lambda'+System.nanoTime()+'(')
       .replaceAll(/(^|[^a-zA-Z0-9])var\s/,'$1static def ')
       .replaceAll(/(^|[^a-zA-Z0-9])let\s/,'$1def ')
       .replaceAll(/(^|[^a-zA-Z0-9])const\s/,'$1final def ')
       .replaceAll(/=>/,'->').replaceAll(/(^|[^\)])\{\}/,'$1[:]')
      ).toString();}}

