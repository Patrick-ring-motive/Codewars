const fs = require('fs');
const data = fs.readFileSync('./test.js',
    { encoding: 'utf8', flag: 'r' });
console.log(data);