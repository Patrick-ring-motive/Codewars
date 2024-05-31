try:
    import js2py
except:
    import subprocess
    import sys
    subprocess.check_call([sys.executable, "-m", "pip", "install", "js2py"])
    import js2py
def solution(string):
    return js2py.eval_js("""
    
    function solution(str){
      return str.split('').reverse().join('');
    }
    solution('"""+string+"""');

    """)