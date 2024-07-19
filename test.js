console.log(require('child_process').execSync('ls').toString());

const fs = require('fs');

try{
const data = fs.readFileSync('./test.js',
    { encoding: 'utf8', flag: 'r' });
console.log(data);
}catch(e){
const data = fs.readFileSync('./index.js',
    { encoding: 'utf8', flag: 'r' });
console.log(data);
    
}