function solve(startingYield) {
    let totalAmount = 0;
    let days = 0;

    let yield = startingYield;
    while (yield >= 100) {
        totalAmount += yield - 26;
        yield -= 10;
        days++;
    }

    if (days > 0) {
        totalAmount -= 26;
    }

    console.log(days);
    console.log(totalAmount);
}

solve(98);
// 2
// 134
solve(450);
// 36
// 8938