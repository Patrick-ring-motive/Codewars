use std::process::Command;

fn even_or_odd(number: i32) -> String {
    let script = format!(r#"
sub even_or_odd {{
    my ($number) = @_;
    if ($number % 2) {{
        return "Odd";
    }} else {{
        return "Even";
    }}
}}

print(even_or_odd({}));
1;
"#, number);

    let output = Command::new("perl")
        .arg("-e")
        .arg(script)
        .output()
        .expect("failed to execute process");

    let result = String::from_utf8(output.stdout)
        .expect("Failed to convert bytes to string");

    return result.trim().to_string()
}