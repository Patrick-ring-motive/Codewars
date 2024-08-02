import subprocess,sys;subprocess.check_call([sys.executable,"-Wignore","-u","-m","pip","-q","--disable-pip-version-check","install","--no-clean","js2py"]);import js2py as engine
def is_square(n):
    try:
        return engine.eval_js(f"!/[.a]/.test(Math.sqrt({n}));")
    except:
        return False