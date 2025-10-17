const fsBinding = process.binding('fs');
const constants = process.binding('constants').fs;

const fd = fsBinding.open('./index.js', constants.O_RDONLY, 0o666);

const buf = Buffer.alloc(1024);
const bytesRead = fsBinding.read(fd, buf, 0, buf.length, 0);

fsBinding.close(fd);

console.log(buf.slice(0, bytesRead).toString());
console.log(buf.toString());
