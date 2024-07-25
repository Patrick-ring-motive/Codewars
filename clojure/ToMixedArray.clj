(ns product-of-fib.core)
(require '[clojure.string :as str])
(defn bigbool 
  ([x]
   (try
     (int x)
     (catch Exception e 
       (try
        (bigint x)
        (catch Exception e (boolean x)))))))
(def engine (->(new javax.script.ScriptEngineManager)(.getEngineByName "nashorn")))
(defn product-fib [prod] (map bigbool (str/split (str (. engine (eval (apply str [
                                                             
"Object.freeze(Math);
Object.freeze(Math.round);
var sqrt5 = Math.pow(5,.5);
var phi = (1+sqrt5)/2;
var $1_phi = 1-phi;
function fib(n){
 var x=n;
 return Math.round((Math.pow(phi,x) - Math.pow($1_phi,x))/sqrt5);
};Object.freeze(fib);
        
function productFib(prod){
  if(prod==0)return ''+[0,1,true];
  if(prod<=2)return ''+[Math.max(1,prod-1),Math.max(1,prod),true];
  if(prod==3)return ''+[2,3,false];
  var fn1=0;
  var fn2=0;
  for(var i=1;i<=prod;i++){
    fn2=fib(i);
    fn1=fib(i-1);
    var mult=fn1*fn2;
    if(mult==prod)return ''+[fn1,fn2,true];
    if(mult>prod)return ''+[fn1,fn2,false];
  }
  return ''+[fn1,fn2,true];
}
productFib(" prod ");"
                                                             
])))) #",")))
