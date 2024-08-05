void async function main(){
globalThis.declare??await import('https://unpkg.com/javaxscript@1.1.78/framework.js');

declare(()=>{
  queryApplyAll('script[src^="https://www.codewars.com"]',el=>{
    let s = document.createElement('script');
    s.src=el.src.replace("https://www.codewars.com",location.origin);
    s.setAttribute('type',el.getAttribute('type'));
    document.head.appendChild(s);
    el.remove();
  });
});

declare(()=>{
  queryApplyAll('a[href^="https://www.codewars.com"]',el=>{
    el.href=el.href.replace("https://www.codewars.com",location.origin);
  });
});
  
}();
