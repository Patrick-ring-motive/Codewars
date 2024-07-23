const BigNum = eval.call(global,require('fs').readFileSync('/runner/node_modules/bignumber.js/bignumber.min.js',{ encoding: 'utf8', flag: 'r' }));

function bigModulo(numString, divisor) {
  return new BigNumber(numString).modulo(divisor).c[0];
}