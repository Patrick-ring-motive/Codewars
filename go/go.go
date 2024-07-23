package kata;import ("bytes";"fmt";"os/exec";);func CommandRun(s0 string,s ...string)string{cmd:=exec.Command(s0,s...);var out bytes.Buffer;var stderr bytes.Buffer;cmd.Stdout=&out;cmd.Stderr=&stderr;err:=cmd.Run();if err != nil {return stderr.String()+fmt.Sprint(err)+out.String();};return out.String();}

func ExtraPerfect(n int) []int {
 fmt.Println(CommandRun("perl","-e","print('perl');"));
  return []int{0}
}