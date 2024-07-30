global.Math="delete";
const vm = process.binding('contextify');
const script = new vm.ContextifyScript('x=Math.random();','evalmachine.<anonymous>',0,0,undefined, false, undefined);
let ctx = { x: 0 };
vm.makeContext(ctx, `VM Context 1`, undefined, true, true, null);
script.runInContext(ctx,-1,true,false,false);
console.log(ctx.x);
