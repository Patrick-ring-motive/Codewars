// @ts-nocheck
function int32ToIp(int32){
  let bytes = `0000000000000000000000000000000${int32.toString(2)}`.slice(-32);
  return `${+`0b${bytes.slice(0,8)}`}.${+`0b${bytes.slice(8,16)}`}.${+`0b${bytes.slice(16,24)}`}.${+`0b${bytes.slice(24,32)}`}`;
}