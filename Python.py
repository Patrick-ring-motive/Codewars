import subprocess,sys;subprocess.check_call([sys.executable,"-Wignore","-u","-m","pip","-q","install","--no-clean","js2py"]);import js2py as engine
def solution(string):
    return js2py.eval_js("""
    
    function solution(str){
      return str.split('').reverse().join('');
    }
    solution('"""+string+"""');

    """)