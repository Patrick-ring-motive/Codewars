function primeFactors(x, factors) {
    while (x % 2n === 0n) {
        factors.push(2n);
        x = x / 2n;
    }

    for (let i = 3n; i * i <= x; i += 2n) {
        while (x % i === 0n) {
            factors.push(i);
            x = x / i;
        }
    }

    if (x > 2n) {
        factors.push(x);
    }
}