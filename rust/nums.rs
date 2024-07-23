use std::process::Command;
fn solution(num: i32) -> i32 {
    
  let script = format!(r#"
sub solution {{
    my ($number) = @_;
    my $sum = 0;
    for my $i (1..$number-1){{
      if((!($i%3))||(!($i%5))){{
        $sum+=$i;
      }}
    }}
    return $sum;
}}

print(solution({}));
1;
"#, num);

    let output = Command::new("perl")
        .arg("-e")
        .arg(script)
        .output()
        .expect("0");

    let result = String::from_utf8(output.stdout).expect("0");
    return result.trim().to_string().parse::<i32>().unwrap_or(0);
}