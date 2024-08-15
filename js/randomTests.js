  /*copy the iterator without destroying the original*/
  const copyIter = (iter) => { 
      const arr = [...iter];
      const i = arr.values();
      iter.next = () => i.next.call(i);
      return [...arr].values();
  }
  
  /*copy the sequence so the user has no reference to it*/
  const copySeq = (seq) => {
    if(typeof seq == 'string' || seq instanceof String) return `${seq}`;
    if(seq instanceof Set) return new Set(seq);
    if(seq instanceof [].values(/*Iterator*/).constructor) return copyIter(seq);
    return [...seq];
  }
  
  const rndInt = (n=2) => ~~(Math.random() * n);
  const rndFloat = (n=1) => rndInt(n) + Math.random();
  const rndBool = () =>!!rndInt();
  const rndChar = () => String.fromCharCode(32 + rndInt(95));
  const rndArr = (fn=rndInt,n=100) => [...Array(rndInt(n))].map(fn);
  const rndStr = (n=100) => rndArr(rndChar,n).join``;
  const rndAlpha = (n=100) => rndStr.replace(/[^a-zA-Z]/g,'');
  const rndLower = (n=100) => rndStr.replace(/[^a-z]/g,'');
  const rndUpper = (n=100) => rndStr.replace(/[^A-Z]/g,'');
  const rndNumeric = (n=100) => rndStr.replace(/[^0-9]/g,'');
  const rndAlphaNumeric = (n=100) => rndStr.replace(/[^a-zA-Z0-9]/g,'');
  const rndSet = (fn,n=100) => new Set(rndArr(fn,n));
  const rndIter = (fn,n=100) => rndArr(fn,n).values();
  const rndItem = (seq) =>{
    let x = [...copySeq(seq)];
    return x[rndInt(x.length)];
  }
  
