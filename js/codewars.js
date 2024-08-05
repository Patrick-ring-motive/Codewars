void async function main(){
globalThis.declare??await import('https://unpkg.com/javaxscript@1.1.78/framework.js');

declare(()=>{
  queryApplyAll('script[src^="https://www.codewars.com"]',el=>{
    el.src=el.src.replace("https://www.codewars.com",location.origin);
  });
});
  
}();
