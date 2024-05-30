`function createPhoneNumber(numbers){
  const n = numbers.join('');
  return \`(${n.slice(0,3)}) ${n.slice(3,6)}-${n.slice(6,10)}\`;
}`