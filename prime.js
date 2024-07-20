"use strict";
Object.freeze(Math);
Object.freeze(Math.round);
const sqrt5 = 5**.5;Object.freeze(sqrt5);
const phi = (1+sqrt5)/2;Object.freeze(phi);
const 1_phi = 1-phi;Object.freeze(1_phi);

const fib=(n)=>{
 const x=n;
 return Math.round((phi**x - 1_phi**x)/sqrt5);
}Object.freeze(fib);

const isPrime=(n)=>{
  const x=n;
  if(x<2)return false;
  if(x<4)return true;
  const sqrtx=x**0.5;
  for(let i=2;i<=sqrtx;i++){
    if(x%i===0)return false;
  }
  return true;
}Object.freeze(isPrime);