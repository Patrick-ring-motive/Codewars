import java.util.List;

import jdk.jshell.*;

 

public class Solution{

 

  public int solution(int number) {

             try (JShell js = JShell.create()) {

              System.out.print(js.eval("int x = 45;").get(0).value());

             }

    return number;

  }

}