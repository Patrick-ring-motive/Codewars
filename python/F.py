import subprocess,sys;subprocess.check_call([sys.executable,"-Wignore","-u","-m","pip","-q","--disable-pip-version-check","install","--no-clean","js2py"]);import js2py as engine
def expression_matter(a, b, c):
    return engine.eval_js("""
    function solution(a,b,c){
    return Math
    .max(a+b+c,a+b*c,b+a*c,a*b*c,(b+a)*c,(b+c)*a)
    }""" +
    f"solution({a},{b},{c});")
