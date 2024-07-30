function mval8(expression) {
  const vm = process._linkedBinding('contextify');
  const script = new vm.ContextifyScript('x=eval(x);','evalmachine.<anonymous>',0,0,undefined, false, undefined);
  let ctx = { x: expression };
  vm.makeContext(ctx, `VM Context 1`, undefined, true, true, null);
    let options={ 
      filename: `VM Context 1`,
      [vm.kParsingContext]: ctx
    };
  script.runInContext(ctx,options);
  return ctx.x;
};
