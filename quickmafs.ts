let oN=x=>Object.getOwnPropertyNames(x);let aP=Array.prototype,sP=String.prototype,nP=Number.prototype,rP=RegExp.prototype;oN(aP).map(x=>sP[x]??=function(){const y=[...this][x](...arguments);return y?.join('')??y});oN(rP).map(x=>sP[x]??=function(re){return re[x](this);});oN(sP).map(x=>nP[x]??=function(){const y=`${this}`[x](...arguments);return isNaN(y)?y:Number(y);});
  


