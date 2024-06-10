
try{
eval("Math.sum=function(){try{if(arguments.length==1){try{return[...arguments[0]].reduce((x,y)=>+x + +y,0);}catch(e){}}return [...arguments].reduce((x,y)=>+x + +y,0);}catch(e){return 0}};")
}catch(e){
Math.sum=function(){try{if(arguments.length==1){try{var s=arguments[0];if(typeof s=='string'){s=s.split('');}return [].reduce.call(s,function(x,y){return 1*x + 1*y},0);}catch(e){}}var ss=arguments;try{ss=Array.from(ss);}catch(e){}return [].reduce.call(function(x,y){return 1*x + 1*y},0);}catch(e){return 0}};
}
Math.sum=function(){try{if(arguments.length==1){try{return[...arguments[0]].reduce((x,y)=>+x + +y,0);}catch(e){}}return [...arguments].reduce((x,y)=>+x + +y,0);}catch(e){return 0}};
global.copy=function(x){return JSON.parse(JSON.stringify(x));}
global.range=function(){
    var a=arguments;
    if(a.length==1){
        return [...Array(a[0]).keys()]
    }
    var x=Math.min(a[0]||0,a[1]||0);
    var y=Math.max(a[0]||0,a[1]||0);
    return [...Array(y-x+1).keys()].map(z=>z+x);
};

