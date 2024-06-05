class EvenOdd {

    static final engine=new javax.script.ScriptEngineManager().getEngineByName("groovy");

    static final evenOrOdd(number){

        return engine.eval("""

       

      function EvenOdd(const number){

        return number%2?'Odd':'Even';

      }

      EvenOdd(${number});

       

    """.replaceAll(/(^|[^a-zA-Z0-9])function ([ ]*[a-zA-Z])/,'$1def $2')
       .replaceAll(/(^|[^a-zA-Z0-9])var /,'$1static def ')
       .replaceAll(/(^|[^a-zA-Z0-9])let /,'$1def ')
       .replaceAll(/(^|[^a-zA-Z0-9])const /,'$1final def ')
      ).toString();

    }

}

