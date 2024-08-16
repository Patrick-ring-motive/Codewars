function copy(iter){
  if(!iter.nativeNext){
    iter.cache=[];
    iter.place=0;
    iter.nativeNext = iter.next;
    iter.next=function(){
      if(iter.place<iter.cache.length){
        const x = iter.cache[iter.place];
        iter.place++;
        return x;
      }else{
        const x = iter.nativeNext();
        iter.cache.push(x);
        return x;
      }
    }
  }
  const fork = [].values();
  fork.parent = iter;
  fork.next = function(){
    if(fork.len === undefined || fork.len >= fork.parent.cache.length){
      const x = fork.parent.next();
      fork.parent.place--;
      if(fork.len === undefined){
        fork.len = fork.parent.cache.length;
      }else{
        fork.len++;
      }
      return x;
    }else{
      const x = fork.parent.cache[fork.len];
      fork.len++;
      return x;
    }
  };
  return fork;
}