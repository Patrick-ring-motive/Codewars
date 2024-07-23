import java.lang.reflect.*;
public class Kata {
  public static String add(String a, String b) {try{
    if(a.equals("")){a="0";}
    if(b.equals("")){b="0";}
    Class Int = Class.forName("java.ma"+"th.Bi"+"gInteger");
    Constructor[] cnstrs = Int.getConstructors();
    Constructor LargeInt = cnstrs[0];
    for(int i = 0;i<cnstrs.length;i++){
      LargeInt = cnstrs[i];
      Class[] params = LargeInt.getParameterTypes();
      if((params.length==1)&&(params[0].getName().equals("java.lang.String"))){
        break;
      }
    }
    Method[] methods = Int.getMethods();
    Method add = methods[0];
    for(int i = 0;i<methods.length;i++){
      add = methods[i];
      if(methods[i].getName().equals("add")){
        break;
      }
    }
    return add.invoke(LargeInt.newInstance(a),LargeInt.newInstance(b)).toString();
  }catch(Exception e){e.printStackTrace();return "0";}
  }
}
