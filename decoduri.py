import subprocess,sys;subprocess.check_call([sys.executable,"-Wignore","-u","-m","pip","-q","--disable-pip-version-check","install","--no-clean","js2py"]);import js2py as engine
from urllib.parse import quote
def rot13(message):
    return engine.eval_js("""
    
var s = decodeURI('"""+quote(f"{message}")+"""');
String.prototype.includes=function(x){return this.indexOf(x)>-1;};
var a = 'abcdefghijklmnopqrstuvwxyz'
var A = a.toUpperCase();
var c = 'nopqrstuvwxyzabcdefghijklm'
var C = c.toUpperCase();
function Rot13(m){
  return m.split('').map(function(x){return a.includes(x)?c[a.indexOf(x)]:C.includes(x)?C[A.indexOf(x)]:x}).join('')
}
Rot13(s);

    """)