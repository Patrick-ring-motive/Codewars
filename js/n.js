const n = [0n,1n,2n,3n,4n,5n,6n,7n,8n,9n];
function multiply(a, b){
 return `${BigInt(a)*BigInt(b)}`;
}
function BigInt(num){
  let numn = 0n;
  num.split('').reverse().map((x,i)=>{
    let digit = n[x];
    for(let d=0;d<i;d++){
      digit*=10n;
    }
    numn+=digit;
  });
  return numn;
}
