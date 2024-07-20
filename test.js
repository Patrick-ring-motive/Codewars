const fs = require('fs');
let files=require('child_process').execSync('ls -a') .toString();
files.split`\n`.forEach(x=>{try{
  console.log(x.trim());
  const data = fs.readFileSync(`./${x.trim()}`,
    { encoding: 'utf8', flag: 'r' });
  console.log(data);
}catch(e){return;}});