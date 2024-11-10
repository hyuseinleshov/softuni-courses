// Perfect Number
function solve(number) {
    let temp = 0;

    for (var i = 1; i <= number / 2; i++) {
        if (number % i === 0) {
            temp += i;
        }
    }

    if (temp === number && temp !== 0) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");
    }
}

solve(6);        // Expected Output: We have a perfect number!
solve(28);       // Expected Output: We have a perfect number!
solve(1236498);  // Expected Output: It's not so perfect.