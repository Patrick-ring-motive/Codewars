import subprocess,sys;subprocess.check_call([sys.executable,"-Wignore","-u","-m","pip","-q","--disable-pip-version-check","install","--no-clean","js2py"]);import js2py as engine
def number(lines):
  try:
    raw = engine.eval_js("""
    
function p(x,y){return eval('function('+x+'){return '+y+'}')}            
var number=function(a){
  return a.map(function(x,i){return ''+(i+1)+': '+x});
}
number("""+f"{lines}"+""");

    """)
    return eval(f"{raw}")
  except Exception as e:
    print(e)
    return []
    
    
