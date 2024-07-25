(ns dir-reduc.core)
(require '[clojure.string :as str])
(defn is-nil? [arr]
  (if (.equals "" (get-in arr [0])) nil arr))
(def engine (->(new javax.script.ScriptEngineManager)(.getEngineByName "nashorn")))
(defn dirReduc
  [arr]  (is-nil? (str/split (str (. engine (eval (apply str [
                                                             
"function dirReduc(arr){
  var s = (''+arr).toLowerCase().replace(/[^a-z,]/g,'');
  var re = /north,south|south,north|east,west|west,east/gi;
  while(re.test(s)){
  s=s.replace(re,'').replace(/,+/g,',').replace(/^,|,$/g,'');
  }
  return s==''?'':s.toUpperCase();
}
dirReduc('" arr "'.split(' '));"
                                                             
])))) #",")))
