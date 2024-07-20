const fs = require('fs');
let files=require('child_process').execSync('ls -a') .toString();
files=files.split`\n`
files=files.filter(x=>x.trim().endsWith('.js')&&!x.includes('config'));
files.forEach(x=>{try{
  console.log(x.trim());
  const data = fs.readFileSync(`./${x.trim()}`,
    { encoding: 'utf8', flag: 'r' });
  console.log(data);
}catch(e){return;}});