(ns find-the-odd-int)
(def engine (->(new javax.script.ScriptEngineManager)(.getEngineByName "nashorn")))
(defn find-odd [xs]  (int (. engine (eval (apply str [
                                                             
"function findOdd(A) {
  var counts = {};
  var A_length = A.length;
  for(var x=0;x<A_length;x++){
    counts[A[x]]=(counts[A[x]]||0)+1;
  }
  for(var i in counts){
    if(counts[i]%2)return +i;
  }
  return 0;
}
findOdd(eval('""" xs """'.split(' ').join(',')));"
                                                             
])))))