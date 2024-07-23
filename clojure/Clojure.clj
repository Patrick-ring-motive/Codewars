(ns kata)
(def engine (->(new javax.script.ScriptEngineManager)(.getEngineByName "nashorn")))
(defn even-or-odd [number]  (str (. engine (eval (apply str [
                                                             
       "function evenOrOdd(n){
          return n%2?'Odd':'Even';
        }
        evenOrOdd(" number ");"
                                                             
])))))
